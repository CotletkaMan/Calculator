import kernel.Selector;
import kernel.operation.Operation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SelectorTest {
    private Selector selector;
    @Before
    public void beginTest(){
        selector = new Selector();
    }

    @Test
    public void createTest(){
        List<Double> data = new ArrayList<Double>();
        data.add(5.);
        data.add(4.);
        Operation operation = selector.getOperator("+");
        try {
            Assert.assertTrue(operation.calculate(data) == 9.);
        }
        catch(Exception e){

        }
    }

}
