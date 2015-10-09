package kernel;

import kernel.operation.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * Class loads and storage operation defined in system.
 * Load made by Properties methods.
 */
public class Selector {
    private HashMap<String , Operation> operations;
    public static final Logger log = LogManager.getLogger();


    /**
     * Create object and load accessible operations
     */
    public Selector(){
        Properties props = new Properties();
        operations = new HashMap<String, Operation>();
        try {
            props.load(new FileInputStream(new File("config.ini")));
            String[] operatorPaths = props.getProperty("PATH_TO_OPERATOR_DEFINE").split(";");
            addOperation(operations, operatorPaths);
        }
        catch(FileNotFoundException e){
            log.fatal("Not found config file in path :: config.ini");
            throw new RuntimeException("Not found config file in path :: config.ini");
        }
        catch(IOException e){
            log.fatal("You don't have access to config file src/main/resources/config.ini");
            throw new RuntimeException("You don't have access to config file");
        }
    }

    /**
     * Adds valid <code>Operations</code> in local storage.
     * @param destination   local storage
     * @param paths         for <code>Operation</code> code
     */
    private void addOperation(HashMap<String , Operation> destination , String[] paths){
        for (String path : paths) {
            try {
                Operation operation = (Operation)Class.forName(path).newInstance();
                if(operation.getName() != null && operation.getNumArguments() > 0) {
                    if (!destination.containsKey(operation.getName()))
                        destination.put(operation.getName(), operation);
                    else
                        log.error("Class " + operation.getClass().getName() + " don't load because of name is already exists");
                }
                else{
                    log.error("Class " + operation.getClass().getName() + " don't load because of name is null and(or) argument count lesser 1");
                }
            }
            catch (Exception e){
                log.error("Class not found " + e.getMessage());
            }
        }
    }

    public Operation getOperator(String name){
        return operations.get(name);
    }
}