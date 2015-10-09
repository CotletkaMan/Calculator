package kernel;



import kernel.operation.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

/**
 * Class allows the user to enter commands and use
 * input strings for find operation.
 */
public class ControlInput {
    private Selector selector;
    private BufferedReader stream;
    private Controler controler;
    public static final Logger log = LogManager.getLogger();
    public ControlInput(){
        selector = new Selector();
        stream = new BufferedReader(new InputStreamReader(System.in));
        controler = new Controler();
    }

    /**
     * Allows input commands while user input no empty string.
     * @throws IOException if occur error in i/o methods
     */
    public void start() throws IOException{
        String input;
        while(!(input = stream.readLine()).isEmpty()){
            excecute(input);
        }
    }

    /**
     * Parse input string and find operations
     * @param input input string
     */
    private void excecute(String input){
        try {
            double integer = Double.parseDouble(input);
            controler.addArgument(integer);
        }
        catch (Exception e){
            Operation operation = selector.getOperator(input);
            if(operation == null){
                log.info("Not found action ::" + input);
                log.info(e.getStackTrace());
                System.out.println("Not found action ::" + input);
                return;
            }
            controler.setOperation(operation);
        }
    }
}
