package aditi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.paallelhw4.Q6.BoundedBuffer;
import java.math.BigInteger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aditi
 */
public class Big {

    public Big() {
    }

    double[] data = new double[100000];
    private long LOCKUP_DETECT_TIMEOUT = 1000;
    private static final int CAPACITY = 100;//10000
    private static final long THRESHOLD = 100000000;
                                       // 3529101024

    @Test
    public void testLeak() throws InterruptedException {
        BoundedBuffer<Big> bb = new BoundedBuffer<Big>(CAPACITY);
        long heapSize1 = snapshotHeap();/* snapshot heap */;
        for (int i = 0; i < CAPACITY; i++) {
            bb.put(new Big());
        }
        for (int i = 0; i < CAPACITY; i++) {
            bb.take();
        }
        long heapSize2 = snapshotHeap();/* snapshot heap */;
        //System.out.println("final: "+(heapSize1 - heapSize2));
        assertTrue(Math.abs(heapSize1 - heapSize2) < (THRESHOLD * 100));
    }

    private long snapshotHeap() {
        /* Snapshot heap and return heap size */
        //Runtime.getRuntime().totalMemory(); 
        
        long heapMaxSize= Runtime.getRuntime().maxMemory();

        long heapFreeSize = Runtime.getRuntime().freeMemory(); 
       // System.out.println(heapMaxSize+" -" +heapFreeSize +"="+(heapMaxSize - heapFreeSize));
        
        return heapMaxSize-heapFreeSize;
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
