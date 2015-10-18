package kernel.operation.operationimpl.operator;

import kernel.operation.Operation;

import java.util.List;


public class Minus extends Operation {
    public Minus(){
        super("-" , 2);
    }

    protected double callFunction(List<Double> data){
        return data.get(0) - data.get(1);
    }
}
