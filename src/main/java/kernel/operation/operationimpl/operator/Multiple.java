package kernel.operation.operationimpl.operator;

import kernel.operation.Operation;

import java.util.List;

/**
 * Created by cotletkaman on 07.10.15.
 */
public class Multiple extends Operation {
    public Multiple(){
        super("*" , 2);
    }

    public double callFunction(List<Double> data){
        return data.get(0) * data.get(1);
    }

}
