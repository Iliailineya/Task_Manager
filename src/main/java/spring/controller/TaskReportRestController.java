package spring.controller;

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

    public TaskReportRestController(TaskReportService taskReportService) {
        this.taskReportService = taskReportService;
    }

    @PostMapping("/post")
    public ResponseEntity<TaskReport> createTaskReport(@RequestBody TaskReport taskReport) {
        TaskReport createdTaskReport = taskReportService.createTaskReport(taskReport);
        return new ResponseEntity<>(createdTaskReport, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskReport> getTaskReportById(@PathVariable long id) {
        TaskReport taskReport = taskReportService.getTaskReportById(id);
        return ResponseEntity.ok(taskReport);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskReport>> getAllTaskReports() {
        List<TaskReport> taskReports = taskReportService.getAllTaskReports();
        return ResponseEntity.ok(taskReports);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskReport> updateTaskReport(@PathVariable long id, @RequestBody TaskReport taskReportDetails) {
        TaskReport updatedTaskReport = taskReportService.updateTaskReport(id, taskReportDetails);
        return ResponseEntity.ok(updatedTaskReport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskReportById(@PathVariable long id) {
        taskReportService.deleteTaskReportById(id);
        return ResponseEntity.noContent().build();
    }
}
