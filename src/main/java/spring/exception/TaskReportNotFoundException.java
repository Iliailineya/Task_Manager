package spring.exception;

public class TaskReportNotFoundException extends RuntimeException {
    public TaskReportNotFoundException(String message) {
        super(message);
    }
}
