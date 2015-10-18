package kernel.operation.operationimpl.operator;

import kernel.operation.Operation;
/**
 * Created by cotletkaman on 07.10.15.
 */
public class Plus extends Operation {
    public Plus(){
        super("+" , 2);
    }

    public double callFunction(Double[] data){
        return data[0] + data[1];
    }
}
