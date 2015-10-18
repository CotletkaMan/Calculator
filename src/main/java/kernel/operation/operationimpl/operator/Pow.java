package kernel.operation.operationimpl.operator;

import kernel.operation.Operation;

import java.util.List;

/**
 * Created by cotletkaman on 09.10.15.
 */
public class Pow extends Operation{
    public Pow(){
        super("^" , 1);
    }

    public double callFunction(List<Double> data){
        return Math.pow(data.get(0) , data.get(1));
    }
}
