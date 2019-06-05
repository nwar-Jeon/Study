import static org.junit.Assert.*;
import org.junit.*;


public class MainTest {
    int a, b;
    @BeforeClass
    public static void setUp(){
        System.out.println("setup");
    }

    @Before
    public void beforeRun(){
        a=2;
        b=2;
        System.out.println("runbefore");
    }
    @Test
    public void run() {
        assertEquals(a,b);
        System.out.println("run");
    }
    @After
    public void afterRun(){
        System.out.println("runafter");
    }

    @Test(timeout=1)
    public void run2() {
        assertEquals(a,b);
    }

    @Ignore
    @Test(expected = NullPointerException.class)
    public void runException(){
        String a = null;
        System.out.println(a);
    }

    @AfterClass
    public static void exit(){
        System.out.println("종료");
    }
}