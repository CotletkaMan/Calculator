/**
 * Created by cotletkaman on 09.10.15.
 */

import kernel.Selector;
import kernel.operation.Operation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


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
        List<Double> data = new ArrayList<Double>();
        data.add(5.);
        data.add(1.);
        Assert.assertTrue(divide.calculate(data) == 5.);
    }

    @Test
    public void divideExceptionTest() throws  Exception{
        List<Double> data = new ArrayList<Double>();
        data.add(5.);
        data.add(Double.NaN);
        Assert.assertTrue(Double.isNaN(divide.calculate(data)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void argumentTest() throws Exception{
        List<Double> data = new ArrayList<Double>();
        data.add(5.);
        divide.calculate(data);
    }
}
