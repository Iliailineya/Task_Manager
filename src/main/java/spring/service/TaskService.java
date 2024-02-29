package spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.exception.EntityNotFoundException;
import spring.model.Task;
import spring.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository repository;

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public Task getTaskById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task with id " + id + " not found"));
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task updateTask(long id, Task task) {
        if (repository.existsById(id)) {
            task.setId(id);
            return repository.save(task);
        } else {
            throw new EntityNotFoundException("Task with id " + id + " not found");
        }
    }

    public void deleteTaskById(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Task with id " + id + " not found");
        }
    }
}

