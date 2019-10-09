package _4_Exceptions.Logging.ConfigureLogging;

import java.util.logging.*;


public class ConfigureLogging {
    //private static final Logger LOGGER = Logger.getLogger(ConfigureLogging.class.getName());

    private static final Logger LOGGER_A = Logger.getLogger("org.stepic.java.logging.ClassA");
    private static final Logger LOGGER_B = Logger.getLogger("org.stepic.java.logging.ClassB");
    private static final Logger LOGGER_C = Logger.getLogger("org.stepic.java");


    private static void configureLogging() {
        LOGGER_A.setLevel(Level.ALL);
        LOGGER_B.setLevel(Level.WARNING);

        LOGGER_C.setUseParentHandlers(false);

        ConsoleHandler ch = new ConsoleHandler();
        Formatter sf = new XMLFormatter();
        ch.setFormatter(sf);
        ch.setLevel(Level.ALL);
        LOGGER_C.addHandler(ch);
    }
}
