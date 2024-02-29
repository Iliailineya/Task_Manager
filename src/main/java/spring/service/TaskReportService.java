package spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.exception.EntityNotFoundException;
import spring.model.TaskReport;
import spring.repository.TaskReportRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskReportService {
    private final TaskReportRepository repository;

    public TaskReport createTaskReport(TaskReport taskReport) {
        return repository.save(taskReport);
    }

    public TaskReport getTaskReportById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TaskReport with id " + id + " not found"));
    }

    public List<TaskReport> getAllTaskReports() {
        return repository.findAll();
    }

    public TaskReport updateTaskReport(long id, TaskReport taskReport) {
        if (repository.existsById(id)) {
            taskReport.setId(id);
            return repository.save(taskReport);
        } else {
            throw new EntityNotFoundException("TaskReport with id " + id + " not found");
        }
    }

    public void deleteTaskReportById(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("TaskReport with id " + id + " not found");
        }
    }
}
