package kernel.operation;

/**
 * Operation is abstract class define any
 * actions in system
 */
public abstract class Operation {
    private final String name;
    private final int numArguments;
    public Operation(String name , int numArguments) throws IllegalArgumentException{
        this.name = name;
        this.numArguments = numArguments;
    }
    public String getName(){
        return name;
    }
    public int getNumArguments(){
        return numArguments;
    }

    /**
     * Check input parameters and invoke define callFunction
     * @param  data         arguments for callFunction
     * @return              result of a operation
     * @throws Exception    occur if <code>data</code> is invalid or
     *                      error in <code>callFunction</code> method
     */
    public double calculate(Double[] data) throws Exception{
        if(data.length != getNumArguments())
            throw new IllegalArgumentException("Not set argument for operation");
        for(int i = 0 ; i < data.length ; i++)
            if(!Double.isFinite(data[i]))
                throw new IllegalArgumentException("Not set " + i  +  " value is ::" + data[i]);
        return callFunction(data);
    }

    /**
     * <code>calculate</code> method call this method defined in child
     * for calculate results
     * @param  data         arguments for callFunction
     * @return              result of a operation
     * @throws Exception    occur if error in <code>callFunction</code> method
     */
    protected abstract double callFunction(Double[] data) throws Exception;
}