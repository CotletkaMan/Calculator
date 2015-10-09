package operationimpl.operator;

import kernel.operation.Operation;
/**
 * Created by cotletkaman on 07.10.15.
 */
public class Multiple extends Operation {
    public Multiple(){
        super("*" , 2);
    }

    public double Function(Double[] data){
        return data[0] * data[1];
    }

}
