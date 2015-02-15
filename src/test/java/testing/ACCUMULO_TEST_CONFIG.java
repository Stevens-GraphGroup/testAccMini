package testing;

import org.apache.accumulo.core.client.security.tokens.PasswordToken;

public class ACCUMULO_TEST_CONFIG {

    /**
     * Set the Accumulo config to use for all test classes here.
     */
    public static IAccumuloTester AccumuloTester;

    static {
        String s = System.getProperty("TEST_ACCUMULO");
        if (s != null)
            switch(s) {
                case "local":
                    AccumuloTester = new RealAccumuloTester("instance","localhost:2181",5000,"root",new PasswordToken("secret"));
                    break;
                case "txe1":
                    AccumuloTester = new RealAccumuloTester("classdb51","classdb51.cloud.llgrid.txe1.mit.edu:2181",5000,"root",new PasswordToken("secret"));
                    break;
                case "mini":
                default:
                    AccumuloTester = new MiniAccumuloTester();
                    break;
            }
    }

    // Alternatives:
//    public static final IAccumuloTester AccumuloTester =
//            new RealAccumuloTester("instance","localhost:2181",5000,"root",new PasswordToken("secret"));

    //"classdb51.cloud.llgrid.txe1.mit.edu:2181"

}
