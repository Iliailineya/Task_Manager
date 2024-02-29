package spring.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.model.Task;
import spring.service.TaskService;

import java.util.List;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/tasks")
public class TaskRestController {

    private final TaskService taskService;
    private static final Logger logger = Logger.getLogger(TaskRestController.class);

    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/post")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        logger.info("Creating task: " + task);
        Task createdTask = taskService.createTask(task);
        logger.info("Task created: " + createdTask);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable long id) {
        logger.info("Fetching task with id: " + id);
        Task task = taskService.getTaskById(id);
        logger.info("Fetched task: " + task);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks() {
        logger.info("Fetching all tasks");
        List<Task> tasks = taskService.getAllTasks();
        logger.info("Fetched all tasks: " + tasks);
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id, @RequestBody Task taskDetails) {
        logger.info("Updating task with id: " + id);
        Task updatedTask = taskService.updateTask(id, taskDetails);
        logger.info("Updated task: " + updatedTask);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable long id) {
        logger.info("Deleting task with id: " + id);
        taskService.deleteTaskById(id);
        logger.info("Task deleted with id: " + id);
        return ResponseEntity.noContent().build();
    }
}
