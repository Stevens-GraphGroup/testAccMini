package testing;

import org.apache.accumulo.core.client.Instance;
import org.junit.rules.TestRule;

/**
 * Provides an Accumulo instance to a test method.
 * Handles setup and teardown.
 */
public interface IAccumuloTester extends TestRule {

    public String getUser();

    public String getPassword();

    public Instance getInstance();

}
