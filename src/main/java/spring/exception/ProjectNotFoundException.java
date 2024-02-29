package spring.exception;

import org.apache.log4j.Logger;

public class ProjectNotFoundException extends RuntimeException {
    private static final Logger logger = Logger.getLogger(ProjectNotFoundException.class);

    public ProjectNotFoundException(String message) {
        super(message);
        logger.warn(message);
    }
}