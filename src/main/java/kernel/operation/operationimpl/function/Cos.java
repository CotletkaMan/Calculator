package kernel.operation.operationimpl.function;

import kernel.operation.Operation;

import java.util.List;

/**
 * Created by cotletkaman on 18.10.15.
 */
public class Cos extends Operation {
    public Cos(){
        super("cos" , 1);
    }

    public double callFunction(List<Double> data){
        return Math.cos(data.get(0));
    }
}
