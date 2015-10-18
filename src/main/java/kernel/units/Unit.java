package kernel.units;

import kernel.operation.Operation;

/**
 * interface defines operations on computing unit
 */
public interface Unit {
    void addArgument(double value);
    void setOperation(Operation operation);
    double calculate() throws Exception;
}