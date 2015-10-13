package operationimpl.operator;


import kernel.operation.Operation;

public class Divide extends Operation {
    public Divide(){
        super("/" , 2);
    }

    public double callFunction(Double[] data){
        return data[0] / data[1];
    }
}
