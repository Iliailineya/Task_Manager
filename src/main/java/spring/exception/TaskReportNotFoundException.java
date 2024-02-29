package spring.exception;

import org.apache.log4j.Logger;

public class TaskReportNotFoundException extends RuntimeException {
    private static final Logger logger = Logger.getLogger(TaskReportNotFoundException.class);

    public TaskReportNotFoundException(String message) {
        super(message);
        logger.warn(message);
    }
}
