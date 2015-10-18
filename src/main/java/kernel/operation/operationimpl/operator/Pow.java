package kernel.operation.operationimpl.operator;

import kernel.operation.Operation;

/**
 * Created by cotletkaman on 09.10.15.
 */
public class Pow extends Operation{
    public Pow(){
        super("^" , 1);
    }

    public double callFunction(Double[] data){
        return Math.pow(data[0] , data[1]);
    }
}
