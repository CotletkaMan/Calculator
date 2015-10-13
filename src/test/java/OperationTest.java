/**
 * Created by cotletkaman on 09.10.15.
 */

import operationimpl.operator.Divide;
import org.junit.Assert;
import org.junit.Test;


public class OperationTest {
    @Test
    public void divideBasicTest() {
        Divide divide = new Divide();
        Double[] data = new Double[]{5. , 1.};
        Assert.assertTrue(divide.callFunction(data) == 5.);
    }

    @Test
    public void divideExceptionTest(){
        Divide divide = new Divide();
        Double[] data = new Double[]{5. , Double.NaN};
        Assert.assertTrue(Double.isNaN(divide.callFunction(data)));
    }
}
