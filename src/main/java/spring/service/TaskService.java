package spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.exception.TaskNotFoundException;
import spring.model.Project;
import spring.model.Task;
import spring.model.dto.TaskDTO;
import spring.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final ProjectService projectService;

    public Long createTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setPriority(taskDTO.getPriority());
        task.setCreatedDate(taskDTO.getCreatedDate());
        task.setDueDate(taskDTO.getDueDate());
        Project project = projectService.getProjectById(taskDTO.getProjectId());
        task.setProject(project);
        return taskRepository.save(task).getId();
    }

    public Task getTaskById(long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with id " + id + " not found"));
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Long updateTask(long id, TaskDTO taskDTO) {
        Task task = getTaskById(id);
        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setPriority(taskDTO.getPriority());
        task.setCreatedDate(taskDTO.getCreatedDate());
        task.setDueDate(taskDTO.getDueDate());
        Project project = projectService.getProjectById(taskDTO.getProjectId());
        task.setProject(project);
        return taskRepository.save(task).getId();
    }

    public void deleteTaskById(long id) {
        getTaskById(id);
        taskRepository.deleteById(id);
    }
}

