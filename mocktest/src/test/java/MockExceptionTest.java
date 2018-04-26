import com.barclays.mockito.Math;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class MockExceptionTest {

    @Mock
    Math mathObj;

    @Before
    public void createMockObj(){
        initMocks(this);
        when(mathObj.div(anyInt(), eq(0))).thenThrow(new ArithmeticException());
    }

    @Test(expected = ArithmeticException.class)
    public void exceptionTest(){
        mathObj.div(3,0);
    }
}
