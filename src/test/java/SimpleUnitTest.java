import junit.framework.Assert;
import kernel.operation.operationimpl.operator.Divide;
import kernel.units.SimpleUnit;
import kernel.units.Unit;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by cotletkaman on 10.10.15.
 */
public class SimpleUnitTest {
    private Divide divide;
    private Unit unit;
    @Before
    public void beginTest(){
        divide = new Divide();
        unit = new SimpleUnit();
    }
    @Test
    public void calculateTest(){
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
        unit.setOperation(divide);
        try {
            Assert.assertTrue(Double.isNaN(unit.calculate()));
        }
        catch(Exception e){

        }
    }
}
