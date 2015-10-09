package kernel.blocks;

import kernel.operation.Operation;

/**
 * interface defines operations on computing unit
 */
public interface Block {
    public void addArgument(double value);
    public void setOperation(Operation operation);
    public double calculate() throws Exception;
}