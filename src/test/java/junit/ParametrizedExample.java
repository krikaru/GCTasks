package junit;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.regex.Matcher;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class ParametrizedExample {

    @Parameters
    public static Iterable<Object[]> data(){
        return Arrays.asList(new Object[][]{{-3, 3}, {-2, 2}, {0, 0}, {2, 2}});
    }

    @Parameter(0)
    public int input;

    @Parameter(1)
    public int expectedResult;

    @Test
    public void test(){
        System.out.println(input);
        assertThat(Math.abs(input), is(expectedResult));
    }

}
