package DeepSkill.Slf4j.Exercise2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        // Here are the variables we want to log
        String targetSystem = "Django Backend";
        int responseTime = 45;
        
        // The {} acts as a placeholder. SLF4J will safely insert the variables into these spots.
        logger.info("Successfully connected to the {} in {} milliseconds.", targetSystem, responseTime);
        
        // Another example showing multiple types of variables
        String user = "Aditya";
        boolean isComplete = true;
        logger.debug("Task execution for user '{}': completion status is {}", user, isComplete);
    }
}