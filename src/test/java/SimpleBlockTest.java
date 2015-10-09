import junit.framework.Assert;
import kernel.blocks.Block;
import kernel.blocks.SimpleBlock;
import operationimpl.operator.Divide;
import org.junit.Test;

/**
 * Created by cotletkaman on 10.10.15.
 */
public class SimpleBlockTest {
    @Test
    public void CalculateTest(){
        Divide divide = new Divide();
        Block block = new SimpleBlock();
        block.addArgument(4);
        block.setOperation(divide);
        block.addArgument(2);
        try {
            Assert.assertTrue(block.calculate() == 2);
        }
        catch(Exception e){}
    }

    @Test
    public void NullOpeartionTest(){
        Block block = new SimpleBlock();
        block.addArgument(4);
        block.addArgument(2);
        try {
            Assert.assertTrue(Double.isNaN(block.calculate()));
        }
        catch(Exception e){

        }
    }

    @Test
    public void NonArgumetsTest(){
        Divide divide = new Divide();
        Block block = new SimpleBlock();
        block.setOperation(divide);
        try {
            Assert.assertTrue(Double.isNaN(block.calculate()));
        }
        catch(Exception e){

        }
    }
}
