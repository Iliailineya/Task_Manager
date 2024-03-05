package spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.exception.TaskReportNotFoundException;
import spring.model.Task;
import spring.model.TaskReport;
import spring.model.dto.TaskReportDTO;
import spring.repository.TaskReportRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskReportService {
    private final TaskReportRepository taskReportRepository;
    private final TaskService taskService;

    public Long createTaskReport(TaskReportDTO taskReportDTO) {
        TaskReport taskReport = new TaskReport();
        Task task = taskService.getTaskById(taskReportDTO.getTaskId());
        taskReport.setTask(task);
        taskReport.setDescription(taskReportDTO.getDescription());
        taskReport.setCompletionDate(taskReportDTO.getCompletionDate());
        return taskReportRepository.save(taskReport).getId();
    }

    public TaskReport getTaskReportById(long id) {
        return taskReportRepository.findById(id)
                .orElseThrow(() -> new TaskReportNotFoundException("TaskReport with id " + id + " not found"));
    }

    public List<TaskReport> getAllTaskReports() {
        return taskReportRepository.findAll();
    }

    public Long updateTaskReport(long id, TaskReportDTO taskReportDTO) {
        TaskReport taskReport = getTaskReportById(id);
        taskReport.setDescription(taskReportDTO.getDescription());
        taskReport.setCompletionDate(taskReportDTO.getCompletionDate());
        return taskReportRepository.save(taskReport).getId();
    }

    public void deleteTaskReportById(long id) {
        if (taskReportRepository.existsById(id)) {
            taskReportRepository.deleteById(id);
        } else {
            throw new TaskReportNotFoundException("TaskReport with id " + id + " not found");
        }
    }
}
