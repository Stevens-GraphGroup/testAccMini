package testing.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.TestName;
import testing.IAccumuloTester;
import testing.TEST_CONFIG;

/**
 * Similar to {@link org.apache.accumulo.harness.AccumuloIT}.
 */
public class AccumuloTestBase {
  private static final Logger log = LogManager.getLogger(AccumuloTestBase.class);

  /** This is setup once for the entire class. */
  @ClassRule
  public static IAccumuloTester tester = TEST_CONFIG.AccumuloTester;

  @Rule
  public TestName testName = new TestName();

  public String[] getUniqueNames(int num) {
    String[] names = new String[num];
    for (int i = 0; i < num; i++)
      names[i] = this.getClass().getSimpleName() + "_" + testName.getMethodName() + i;
    return names;
  }
}
