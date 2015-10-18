package kernel.operation.operationimpl.function;

import kernel.operation.Operation;

/**
 * Created by cotletkaman on 18.10.15.
 */
public class Sin extends Operation {
    public Sin(){
        super("sin" , 1);
    }

    public double callFunction(Double[] data){
        return Math.sin(data[0]);
    }
}
