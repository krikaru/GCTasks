package junit;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.sin;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class HamcrestExample2 {
    //погрешность
    private static final double ERROR = 0.0001;

    @Test
    public void test_float(){
        assertThat(sin(100.0), is(closeTo(-0.5, ERROR)));
    }

    @Test
    public void test_hasItem(){
        List<String> list = Arrays.asList("A", "B", "C");
        assertThat(list, hasItem("B"));
    }

    @Test
    public void test_X_or_Y(){
        List<String> list = Arrays.asList("A", "X", "Y");
        //логическое или
        assertThat(list, anyOf(hasItem("X"), hasItem("Y")));
    }

    @Test
    public void test_onlyX_or_onlyY() {
        List<String> list = Arrays.asList("A", "Y", "X");
        //(("X")&&(!"Y"))||((!"X")&&("Y"))
        assertThat(list, anyOf(allOf(hasItem("X"), not(hasItem("Y"))), allOf(not(hasItem("X")), hasItem("Y"))));
    }

    @Test
    public void test_only_strict_count_X(){
        List<String> list = Arrays.asList("A", "Y", "X", "A", "Y", "X");
        assertThat(list, hasStrictCount("X", 2));

    }

    public static <T> Matcher<Collection<T>> hasStrictCount(final T expectedElem, final int expectedCount){
        return new BaseMatcher<Collection<T>>() {
            private int actualCount;
            private Object arg;

            @Override
            public boolean matches(Object item) {
                this.arg = item;
                actualCount = 0;
                for (T value: ((Iterable<T>) item)){
                    actualCount += value.equals(expectedElem) ? 1 : 0;
                }
                return actualCount == expectedCount;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Expected: " + expectedCount + " of " + expectedElem + " but found " + actualCount);
            }
        };
    }

}
