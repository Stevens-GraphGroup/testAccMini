package testing;

import org.apache.accumulo.core.data.ByteSequence;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Range;
import org.apache.accumulo.core.data.Value;
import org.apache.accumulo.core.iterators.LongCombiner;
import org.apache.accumulo.core.iterators.TypedValueCombiner;
import org.apache.accumulo.core.iterators.WrappingIterator;

import java.io.IOException;
import java.util.Collection;

/**
 * Emit one value that is a function of entries from the parent iterator.
 */
public class SingleOutputIterator extends WrappingIterator {
  private static final TypedValueCombiner.Encoder<Long> encoder = new LongCombiner.StringEncoder();
  private Key emitKey;
  private Value emitValue;

  @Override
  public void seek(Range range, Collection<ByteSequence> columnFamilies, boolean inclusive) throws IOException {
    super.seek(range, columnFamilies, inclusive);
    myFunction();
  }

  /**
   * Reads all entries from the parent iterator, computing the value you want to emit.
   * Example given is summing the Values of parent entries, interpreted as Longs.
   */
  private void myFunction() throws IOException {
    Long val = 0l;
    while (super.hasTop()) {
      val += encoder.decode(super.getTopValue().get());
      super.next();
    }
    emitKey = new Key(); // replace this with the key you want to emit
    emitValue = new Value(encoder.encode(val));
  }

  @Override
  public Key getTopKey() {
    return emitKey;
  }

  @Override
  public Value getTopValue() {
    return emitValue;
  }

  @Override
  public boolean hasTop() {
    return emitKey != null;
  }

  @Override
  public void next() throws IOException {
    emitKey = null;
    emitValue = null;
  }
}
