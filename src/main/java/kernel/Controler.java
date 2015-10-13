package kernel;

import kernel.units.SimpleUnit;
import kernel.units.Unit;
import kernel.operation.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class managed the state of the block
 */
public class Controler {
    private Unit unit;
    public static final Logger log = LogManager.getLogger();

    public Controler(){
        unit = new SimpleUnit();
    }

    public void addArgument(double value){
        unit.addArgument(value);
        calculate();
    }

    public void setOperation(Operation operation){
        unit.setOperation(operation);
        calculate();
    }

    /**
     * Print result a callFunction defined <code>setOperation</code> method.
     * If result is valid, he print result and create new block.
     * If occur error, the method restart defined block.
     */
    private void calculate(){
        try {
            double result = unit.calculate();
            if (Double.isFinite(result)) {
                System.out.println(">>> " + result);
                unit = new SimpleUnit();
                unit.addArgument(result);
            }
        }
        catch(Exception e){
            log.info(e.getMessage());
            log.info(e.getStackTrace());
            System.out.println(e.toString());
            System.out.println("*************");
            unit = new SimpleUnit();
        }
    }
}
