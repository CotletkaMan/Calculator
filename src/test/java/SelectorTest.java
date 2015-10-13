import kernel.Selector;
import operationimpl.operator.Plus;
import org.junit.Assert;
import org.junit.Test;

public class SelectorTest {
    @Test
    public void createTest(){
        Selector selector = new Selector();
        Plus plus = new Plus();
        Assert.assertTrue(plus.getName().equals(selector.getOperator("+").getName()));
    }
}
