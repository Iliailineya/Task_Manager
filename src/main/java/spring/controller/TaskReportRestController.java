package spring.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.model.TaskReport;
import spring.service.TaskReportService;

import java.util.List;

@SuppressWarnings("unused")
@Log4j
@RestController
@RequestMapping("/api/task-reports")
public class TaskReportRestController {

    private final TaskReportService taskReportService;

    public TaskReportRestController(TaskReportService taskReportService) {
        this.taskReportService = taskReportService;
    }

    @PostMapping("/post")
    public ResponseEntity<TaskReport> createTaskReport(@RequestBody TaskReport taskReport) {
        log.info("Creating task report: " + taskReport);
        TaskReport createdTaskReport = taskReportService.createTaskReport(taskReport);
        log.info("Task report created: " + createdTaskReport);
        return new ResponseEntity<>(createdTaskReport, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskReport> getTaskReportById(@PathVariable long id) {
        log.info("Fetching task report with id: " + id);
        TaskReport taskReport = taskReportService.getTaskReportById(id);
        log.info("Fetched task report: " + taskReport);
        return ResponseEntity.ok(taskReport);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskReport>> getAllTaskReports() {
        log.info("Fetching all task reports");
        List<TaskReport> taskReports = taskReportService.getAllTaskReports();
        log.info("Fetched all task reports: " + taskReports);
        return ResponseEntity.ok(taskReports);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskReport> updateTaskReport(@PathVariable long id, @RequestBody TaskReport taskReportDetails) {
        log.info("Updating task report with id: " + id);
        TaskReport updatedTaskReport = taskReportService.updateTaskReport(id, taskReportDetails);
        log.info("Updated task report: " + updatedTaskReport);
        return ResponseEntity.ok(updatedTaskReport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskReportById(@PathVariable long id) {
        log.info("Deleting task report with id: " + id);
        taskReportService.deleteTaskReportById(id);
        log.info("Task report deleted with id: " + id);
        return ResponseEntity.noContent().build();
    }
}
