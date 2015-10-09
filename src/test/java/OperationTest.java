/**
 * Created by cotletkaman on 09.10.15.
 */

import operationimpl.operator.Divide;
import org.junit.Assert;
import org.junit.Test;


public class OperationTest {
    @Test
    public void DivideBasicTest() {
        Divide divide = new Divide();
        Double[] data = new Double[]{5. , 1.};
        Assert.assertTrue(divide.Function(data) == 5.);
    }

    @Test
    public void DivideExceptionTest(){
        Divide divide = new Divide();
        Double[] data = new Double[]{5. , Double.NaN};
        Assert.assertTrue(Double.isNaN(divide.Function(data)));
    }
}
