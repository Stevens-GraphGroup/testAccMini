package testing;

import org.apache.accumulo.core.client.Instance;
import org.junit.rules.TestRule;

public interface IAccumuloTester extends TestRule {

    public String getUser();

    public String getPassword();

    public Instance getInstance();

}
