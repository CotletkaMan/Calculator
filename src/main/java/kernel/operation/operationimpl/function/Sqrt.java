package kernel.operation.operationimpl.function;

import kernel.operation.Operation;

/**
 * Created by cotletkaman on 18.10.15.
 */
public class Sqrt extends Operation {
    public Sqrt(){
        super("sqrt" , 1);
    }

    public double callFunction(Double[] data){
        return Math.sqrt(data[0]);
    }
}
