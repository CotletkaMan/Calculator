package kernel;


import kernel.operation.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class allows the user to enter commands and use
 * input strings for find operation.
 */
public class ControlInput {
    public static final Logger log = LogManager.getLogger();
    private Selector selector;
    private BufferedReader stream;
    private Controler controler;

    public ControlInput() {
        selector = new Selector();
        stream = new BufferedReader(new InputStreamReader(System.in));
        controler = new Controler();
    }

    /**
     * Allows input commands while user input no empty string.
     *
     * @throws IOException if occur error in i/o methods
     */
    public void start() throws IOException {
        printHelloMessage();
        String input;
        while (!(input = stream.readLine()).isEmpty()) {
            parseInputString(input);
        }
    }

    /**
     * Parse input string and find operations
     *
     * @param input input string
     */
    private void parseInputString(String input) {
        Operation operation = selector.getOperator(input);
        if (operation != null)
            controler.setOperation(operation);
        else {
            try {
                double integer = Double.parseDouble(input);
                controler.addArgument(integer);
            } catch (NumberFormatException e) {
                log.info("Not found action ::" + input);
                log.info(e.getStackTrace());
                System.out.println("Not found action ::" + input);
            }
        }
    }

    private void printHelloMessage() {
        System.out.println("Hi, man! I am simple calculator.\n" +
                "I make calculate basic operations.\n" +
                "If you want something tell,\nyou would input next sequence: Number Operation Number.\n" +
                "I would tell you Good Bye, if you input empty string");
    }
}
