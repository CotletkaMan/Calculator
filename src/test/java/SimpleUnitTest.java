import junit.framework.Assert;
import kernel.units.SimpleUnit;
import kernel.units.Unit;
import operationimpl.operator.Divide;
import org.junit.Test;

/**
 * Created by cotletkaman on 10.10.15.
 */
public class SimpleUnitTest {
    @Test
    public void calculateTest(){
        Divide divide = new Divide();
        Unit unit = new SimpleUnit();
        unit.addArgument(4);
        unit.setOperation(divide);
        unit.addArgument(2);
        try {
            Assert.assertTrue(unit.calculate() == 2);
        }
        catch(Exception e){}
    }

    @Test
    public void nullOpeartionTest(){
        Unit unit = new SimpleUnit();
        unit.addArgument(4);
        unit.addArgument(2);
        try {
            Assert.assertTrue(Double.isNaN(unit.calculate()));
        }
        catch(Exception e){

        }
    }

    @Test
    public void nonArgumetsTest(){
        Divide divide = new Divide();
        Unit unit = new SimpleUnit();
        unit.setOperation(divide);
        try {
            Assert.assertTrue(Double.isNaN(unit.calculate()));
        }
        catch(Exception e){

        }
    }
}
