package spring.exception;

import org.apache.log4j.Logger;

public class TaskNotFoundException extends RuntimeException {
    private static final Logger logger = Logger.getLogger(TaskNotFoundException.class);

    public TaskNotFoundException(String message) {
        super(message);
        logger.warn(message);
    }
}
