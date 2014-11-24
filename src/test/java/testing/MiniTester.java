package testing;

import junit.framework.TestCase;
import org.apache.accumulo.core.client.Instance;
import org.apache.accumulo.core.client.ZooKeeperInstance;
import org.apache.accumulo.minicluster.MiniAccumuloCluster;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;

/**
 * Subclasses should implement "testXXX" methods that use a MiniAccumuloCluster
 * and a static suite() method that returns its own class object.
 */
public abstract class MiniTester
    extends TestCase
{
    /* Fixture State */
    private File tempDir;
    private MiniAccumuloCluster miniaccumulo;
    protected Instance instance;
    public static final String USER = "root";
    public static final String PASSWORD = "password";

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MiniTester(String testName)
    {
        super( testName );
    }

    /** Runs before every test */
    public void setUp() throws Exception {
        super.setUp();
        tempDir = Files.createTempDirectory("tempMini",new FileAttribute<?>[] {}).toFile();
        miniaccumulo = new MiniAccumuloCluster(tempDir, PASSWORD);
        miniaccumulo.start();
        instance = new ZooKeeperInstance(miniaccumulo.getInstanceName(), miniaccumulo.getZooKeepers());
        System.out.println("setUp ok - instance: "+instance.getInstanceName());
    }

    /** Runs after every test */
    public void tearDown() throws Exception {
        super.tearDown();
        instance = null;
        miniaccumulo.stop();
        tempDir.delete();
        System.out.println("tearDown ok - instance destroyed");
    }

    //protected String instanceName() {}

    /*
     * @return the suite of tests being tested
     */
    /*public static Test suite()
    {
        return new TestSuite( MiniTester.class );
    }*/



}
