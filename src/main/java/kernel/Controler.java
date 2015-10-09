package kernel;

import kernel.blocks.Block;
import kernel.blocks.SimpleBlock;
import kernel.operation.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class managed the state of the block
 */
public class Controler {
    private Block block;
    public static final Logger log = LogManager.getLogger();

    public Controler(){
        block = new SimpleBlock();
    }

    public void addArgument(double value){
        block.addArgument(value);
        calculate();
    }

    public void setOperation(Operation operation){
        block.setOperation(operation);
        calculate();
    }

    /**
     * Print result a function defined <code>setOperation</code> method.
     * If result is valid, he print result and create new block.
     * If occur error, the method restart defined block.
     */
    private void calculate(){
        try {
            double result = block.calculate();
            if (Double.isFinite(result)) {
                System.out.println(">>> " + result);
                block = new SimpleBlock();
                block.addArgument(result);
            }
        }
        catch(Exception e){
            log.info(e.getMessage());
            log.info(e.getStackTrace());
            System.out.println(e.toString());
            System.out.println("*************");
            block = new SimpleBlock();
        }
    }
}
