package spring.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.model.Task;
import spring.service.TaskService;

import java.util.List;

@SuppressWarnings("unused")
@Log4j
@RestController
@RequestMapping("/api/tasks")
public class TaskRestController {

    private final TaskService taskService;

    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/post")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        log.info("Creating task: " + task);
        Task createdTask = taskService.createTask(task);
        log.info("Task created: " + createdTask);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable long id) {
        log.info("Fetching task with id: " + id);
        Task task = taskService.getTaskById(id);
        log.info("Fetched task: " + task);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks() {
        log.info("Fetching all tasks");
        List<Task> tasks = taskService.getAllTasks();
        log.info("Fetched all tasks: " + tasks);
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id, @RequestBody Task taskDetails) {
        log.info("Updating task with id: " + id);
        Task updatedTask = taskService.updateTask(id, taskDetails);
        log.info("Updated task: " + updatedTask);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable long id) {
        log.info("Deleting task with id: " + id);
        taskService.deleteTaskById(id);
        log.info("Task deleted with id: " + id);
        return ResponseEntity.noContent().build();
    }
}
