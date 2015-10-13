package kernel;

import kernel.units.SimpleUnit;
import kernel.units.Unitable;
import kernel.operation.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class managed the state of the block
 */
public class Controler {
    private Unitable unitable;
    public static final Logger log = LogManager.getLogger();

    public Controler(){
        unitable = new SimpleUnit();
    }

    public void addArgument(double value){
        unitable.addArgument(value);
        calculate();
    }

    public void setOperation(Operation operation){
        unitable.setOperation(operation);
        calculate();
    }

    /**
     * Print result a callFunction defined <code>setOperation</code> method.
     * If result is valid, he print result and create new block.
     * If occur error, the method restart defined block.
     */
    private void calculate(){
        try {
            double result = unitable.calculate();
            if (Double.isFinite(result)) {
                System.out.println(">>> " + result);
                unitable = new SimpleUnit();
                unitable.addArgument(result);
            }
        }
        catch(Exception e){
            log.info(e.getMessage());
            log.info(e.getStackTrace());
            System.out.println(e.toString());
            System.out.println("*************");
            unitable = new SimpleUnit();
        }
    }
}
