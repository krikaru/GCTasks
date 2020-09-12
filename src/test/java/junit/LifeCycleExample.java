package junit;

import org.junit.*;

//Before annotations were created junit use reflection for read name of method.
//Name of method must have right name.
public class LifeCycleExample {
    public LifeCycleExample() {
        System.out.println("constructor");
    }

    @BeforeClass
    public static void setUpClass(){
        System.out.println("before class");
    }

    @Before
    public void setUp(){
        System.out.println("before");
    }

    @Test
    public void test0(){
        System.out.println("test0");
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @After
    public void tearDown(){
        System.out.println("After");
    }

    @AfterClass
    public static void tearDownClass(){
        System.out.println("after class");
    }
}
