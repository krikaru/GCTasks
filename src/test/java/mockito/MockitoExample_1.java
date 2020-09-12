package mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

public class MockitoExample_1 {

    @Test
    public void test_1(){
        List<String> list = mock(List.class);

        when(list.get(anyInt())).thenReturn("0");
        when(list.get(eq(5))).thenReturn("A");

        ArgumentMatcher<Integer> matcher = new ArgumentMatcher<Integer>() {
            @Override
            public boolean matches(Integer arg) {
                return arg % 3 == 0;
            }
        };

        when(list.get(intThat(matcher))).thenReturn("every third");
        when(list.get(eq(9))).thenThrow(new RuntimeException("Boo!"));

        for (int k = 0; k < 10; k++){
            System.out.println("list.get(" + k + "): " + list.get(k));
        }
    }
}
