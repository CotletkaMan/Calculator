package kernel.units;

import kernel.operation.Operation;

/**
 * interface defines operations on computing unit
 */
public interface Unit {
    public void addArgument(double value);
    public void setOperation(Operation operation);
    public double calculate() throws Exception;
}