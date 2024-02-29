package spring.service;

import spring.exception.EntityNotFoundException;
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
                .orElseThrow(() -> new EntityNotFoundException("Project with id " + id + " not found"));
    }

    public List<Project> getAllProjects() {
        return repository.findAll();
    }

    public Project updateProject(long id, Project project) {
        if (repository.existsById(id)) {
            project.setId(id);
            repository.save(project);
            return project;
        } else {
            throw new EntityNotFoundException("Project with id " + id + " not found");
        }
    }

    public void deleteProjectById(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Project with id " + id + " not found");
        }
    }
}
