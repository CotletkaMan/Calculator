package kernel.units;

import kernel.operation.Operation;
import java.util.ArrayList;
/**
 * Block describes the behavior of a simple block.
 * It allows you to record only a single operator.
 */
public class SimpleUnit implements Unitable {
    private ArrayList<Double> data;
    private Operation operation;
    public SimpleUnit(){
        data = new ArrayList<Double>();
        operation = null;
    }

    /**
     * Adds arguments in block. If the operation is not set,
     * the value replaces the first argument of the unit.
     *
     * @param value argument for operation
     */
    public void addArgument(double value){
        if(operation == null)
            if(data.size() == 0)
                data.add(value);
            else
                data.set(0, value);
        else
            data.add(value);
    }

    /**
     * Sets operation for block. Forbids the addition operation is not set argument.
     * @param operation operation for block
     */
    public void setOperation(Operation operation){
        if(data.size() > 0 && operation != null)
            this.operation = operation;
        else{
            System.out.println("Please input integer");
        }
    }

    public double calculate() throws Exception{
        if(operation != null && operation.getNumArguments() == data.size()) {
            double result = operation.calculate(data.toArray(new Double[data.size()]));
            if(!Double.isFinite(result))
                throw new Exception("result operation = " + result);
            return result;
        }
        return Double.NaN;
    }

}
