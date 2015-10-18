package kernel.operation.operationimpl.operator;


import kernel.operation.Operation;

import java.util.List;

public class Divide extends Operation {
    public Divide(){
        super("/" , 2);
    }

    public double callFunction(List<Double> data){
        return data.get(0) / data.get(1);
    }
}
