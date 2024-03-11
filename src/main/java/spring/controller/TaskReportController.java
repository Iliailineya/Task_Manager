package spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.model.TaskReport;
import spring.model.dto.TaskReportDTO;
import spring.service.TaskReportService;

import java.util.List;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/task-reports")
public class TaskReportController {

    private final TaskReportService taskReportService;

    public TaskReportController(TaskReportService taskReportService) {
        this.taskReportService = taskReportService;
    }

    @PostMapping
    public ResponseEntity<Long> createTaskReport(@RequestBody TaskReportDTO taskReportDTO) {
        return new ResponseEntity<>(taskReportService.createTaskReport(taskReportDTO), HttpStatus.CREATED);
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
    public ResponseEntity<Long> updateTaskReport(@PathVariable long id, @RequestBody TaskReportDTO taskReportDetails) {
        return ResponseEntity.ok(taskReportService.updateTaskReport(id, taskReportDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskReportById(@PathVariable long id) {
        taskReportService.deleteTaskReportById(id);
        return ResponseEntity.noContent().build();
    }
}
