package spring.service;

import spring.exception.ProjectNotFoundException;
import spring.model.Project;
import spring.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService {
    private final ProjectRepository repository;

    public Project createProject(Project project) {
        return repository.save(project);
    }

    public Project getProjectById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project with id " + id + " not found"));
    }

    public List<Project> getAllProjects() {
        return repository.findAll();
    }

    public Project updateProject(long id, Project project) {
        getProjectById(id);
        return repository.save(project);
    }

    public void deleteProjectById(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ProjectNotFoundException("Project with id " + id + " not found");
        }
    }
}
