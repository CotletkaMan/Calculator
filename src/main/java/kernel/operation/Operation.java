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
     * Check input parameters and invoke define function
     * @param  data         arguments for function
     * @return              result of a operation
     * @throws Exception    occur if <code>data</code> is invalid or
     *                      error in <code>Function</code> method
     */
    public double Calculate(Double[] data) throws Exception{
        if(data.length != getNumArguments())
            throw new IllegalArgumentException("Not set argument for operation");
        for(int i = 0 ; i < data.length ; i++)
            if(!Double.isFinite(data[i]))
                throw new IllegalArgumentException("Not set " + i  +  " value is ::" + data[i]);
        return Function(data);
    }

    /**
     * <code>Calculate</code> method call this method defined in child
     * for calculate results
     * @param  data         arguments for function
     * @return              result of a operation
     * @throws Exception    occur if error in <code>Function</code> method
     */
    protected abstract double Function(Double[] data) throws Exception;
}