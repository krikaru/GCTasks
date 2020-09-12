package mockito;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

public class MockitoExample_2 {
    private List<String> list;

    @Before
    public void setUp(){
        list = new ArrayList<>();
    }

    @Test
    public void test_1(){
        Collection<String> coll = mock(Collection.class);

        when(coll.toArray()).thenReturn(new String[]{"A", "B", "C"});
        when(coll.iterator()).thenReturn(asList("A", "B", "C").iterator());

        coll.size();
        list.addAll(coll);

        Assert.assertThat(list, equalTo(asList("A", "B", "C")));
        verify(coll, times(1)).toArray();
        verify(coll).size();
//        verify(coll).iterator();

        //верифицировать что больше не было вызовов, кроме тех что мы верифицировали
        verifyNoMoreInteractions(coll);
    }
}
