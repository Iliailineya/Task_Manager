package spring.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.model.TaskReport;
import spring.service.TaskReportService;

import java.util.List;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/task-reports")
public class TaskReportRestController {

    private final TaskReportService taskReportService;
    private static final Logger logger = Logger.getLogger(TaskReportRestController.class);

    public TaskReportRestController(TaskReportService taskReportService) {
        this.taskReportService = taskReportService;
    }

    @PostMapping("/post")
    public ResponseEntity<TaskReport> createTaskReport(@RequestBody TaskReport taskReport) {
        logger.info("Creating task report: " + taskReport);
        TaskReport createdTaskReport = taskReportService.createTaskReport(taskReport);
        logger.info("Task report created: " + createdTaskReport);
        return new ResponseEntity<>(createdTaskReport, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskReport> getTaskReportById(@PathVariable long id) {
        logger.info("Fetching task report with id: " + id);
        TaskReport taskReport = taskReportService.getTaskReportById(id);
        logger.info("Fetched task report: " + taskReport);
        return ResponseEntity.ok(taskReport);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskReport>> getAllTaskReports() {
        logger.info("Fetching all task reports");
        List<TaskReport> taskReports = taskReportService.getAllTaskReports();
        logger.info("Fetched all task reports: " + taskReports);
        return ResponseEntity.ok(taskReports);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskReport> updateTaskReport(@PathVariable long id, @RequestBody TaskReport taskReportDetails) {
        logger.info("Updating task report with id: " + id);
        TaskReport updatedTaskReport = taskReportService.updateTaskReport(id, taskReportDetails);
        logger.info("Updated task report: " + updatedTaskReport);
        return ResponseEntity.ok(updatedTaskReport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskReportById(@PathVariable long id) {
        logger.info("Deleting task report with id: " + id);
        taskReportService.deleteTaskReportById(id);
        logger.info("Task report deleted with id: " + id);
        return ResponseEntity.noContent().build();
    }
}
