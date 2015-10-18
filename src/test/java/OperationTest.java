/**
 * Created by cotletkaman on 09.10.15.
 */

import kernel.Selector;
import kernel.operation.Operation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class OperationTest {
    private Operation divide;
    private Selector selector;
    @Before
    public void beginTest(){
        selector = new Selector();
        divide = selector.getOperator("/");
    }

    @Test
    public void divideBasicTest() throws Exception{
        Double[] data = new Double[]{5. , 1.};
        Assert.assertTrue(divide.calculate(data) == 5.);
    }

    @Test
    public void divideExceptionTest() throws  Exception{
        Double[] data = new Double[]{5. , Double.NaN};
        Assert.assertTrue(Double.isNaN(divide.calculate(data)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void argumentTest() throws Exception{
        Double[] data = new Double[]{1.};
        divide.calculate(data);
    }
}
