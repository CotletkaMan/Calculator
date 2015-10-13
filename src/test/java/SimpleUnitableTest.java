import junit.framework.Assert;
import kernel.units.SimpleUnit;
import kernel.units.Unitable;
import operationimpl.operator.Divide;
import org.junit.Test;

/**
 * Created by cotletkaman on 10.10.15.
 */
public class SimpleUnitableTest {
    @Test
    public void calculateTest(){
        Divide divide = new Divide();
        Unitable unitable = new SimpleUnit();
        unitable.addArgument(4);
        unitable.setOperation(divide);
        unitable.addArgument(2);
        try {
            Assert.assertTrue(unitable.calculate() == 2);
        }
        catch(Exception e){}
    }

    @Test
    public void nullOpeartionTest(){
        Unitable unitable = new SimpleUnit();
        unitable.addArgument(4);
        unitable.addArgument(2);
        try {
            Assert.assertTrue(Double.isNaN(unitable.calculate()));
        }
        catch(Exception e){

        }
    }

    @Test
    public void nonArgumetsTest(){
        Divide divide = new Divide();
        Unitable unitable = new SimpleUnit();
        unitable.setOperation(divide);
        try {
            Assert.assertTrue(Double.isNaN(unitable.calculate()));
        }
        catch(Exception e){

        }
    }
}
