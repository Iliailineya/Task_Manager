package example.service;

import example.exception.ProjectNotFoundException;
import example.model.Project;
import example.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService {
    private final ProjectRepository repository;

    public Project createProject(Project account) {
        return repository.save(account);
    }

    public Project getProjectById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project with id " + id + " not found"));
    }

    public List<Project> getAllProjects() {
        return repository.findAll();
    }

    public Project updateProject(long id, Project project) {
        if (repository.existsById(id)) {
            project.setId(id);
            repository.updateProject(project);
            return project;
        } else {
            throw new ProjectNotFoundException("Account with id " + id + " not found");
        }
    }

    public void deleteProjectById(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ProjectNotFoundException("Account with id " + id + " not found");
        }
    }
}
