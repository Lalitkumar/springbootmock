import com.barclays.mockito.Math;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class MockTest {

    @Mock
    Math mathObj;

    @Before
    public void createMockObj(){
       // mathObj = Mockito.mock(Math.class);
        initMocks(this);
        when(mathObj.add(3,2)).thenReturn(5);
    }

    @Test
    public void math_addTest(){
        Assert.assertEquals(5,mathObj.add(3,2));

        verify(mathObj).add(eq(3), eq(2));
        verify(mathObj,times(2)).add(3,2);

    }

    @Test
    public void math_addNegativeTest(){
        Assert.assertNotEquals(3, mathObj.add(3,2));
    }
}
