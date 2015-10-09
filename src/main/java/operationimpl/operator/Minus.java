package operationimpl.operator;

import kernel.operation.Operation;


public class Minus extends Operation {
    public Minus(){
        super("-" , 2);
    }

    protected double Function(Double[] data){
        return data[0] - data[1];
    }
}