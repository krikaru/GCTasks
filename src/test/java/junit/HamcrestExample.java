package junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;

public class HamcrestExample {
    private List<String> list;

    @Before
    public void setUp(){
        this.list = new ArrayList<>();
    }

    @Test
    public void test_java_core(){
        list.add("A");
        if (!list.get(0).equals("A")){
            throw new AssertionError();
        }
    }

    @Test
    public void test_junit(){
        list.add("A");
        Assert.assertTrue(list.get(0).equals("A"));
    }

    @Test
    public void test_hamcrest(){
        list.add("A");
        Assert.assertThat(list.get(0), is("A"));
    }
}
