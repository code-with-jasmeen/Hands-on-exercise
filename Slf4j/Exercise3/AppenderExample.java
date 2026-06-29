import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        logger.debug("System debugging initialized.");
        logger.info("Application has started successfully.");
        logger.warn("Memory limits are approaching warning thresholds.");
        logger.error("An unexpected error occurred during execution.");
    }
}