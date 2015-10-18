import kernel.Selector;
import kernel.operation.Operation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SelectorTest {
    private Selector selector;
    @Before
    public void beginTest(){
        selector = new Selector();
    }

    @Test
    public void createTest(){
        Double[] data = new Double[]{5. , 4.};
        Operation operation = selector.getOperator("+");
        try {
            Assert.assertTrue(operation.calculate(data) == 9.);
        }
        catch(Exception e){

        }
    }

}
