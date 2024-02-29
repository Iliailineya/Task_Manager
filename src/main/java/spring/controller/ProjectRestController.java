package spring.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.model.Project;
import spring.service.ProjectService;

import java.util.List;

@SuppressWarnings("unused")
@Log4j
@RestController
@RequestMapping("/api/projects")
public class ProjectRestController {

    private final ProjectService projectService;

    public ProjectRestController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/post")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        log.info("Creating project: " + project);
        Project createdProject = projectService.createProject(project);
        log.info("Project created: " + createdProject);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable long id) {
        log.info("Fetching project with id: " + id);
        Project project = projectService.getProjectById(id);
        log.info("Fetched project: " + project);
        return ResponseEntity.ok(project);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Project>> getAllProjects() {
        log.info("Fetching all projects");
        List<Project> projects = projectService.getAllProjects();
        log.info("Fetched all projects: " + projects);
        return ResponseEntity.ok(projects);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable long id, @RequestBody Project projectDetails) {
        log.info("Updating project with id: " + id);
        Project updatedProject = projectService.updateProject(id, projectDetails);
        log.info("Updated project: " + updatedProject);
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectById(@PathVariable long id) {
        log.info("Deleting project with id: " + id);
        projectService.deleteProjectById(id);
        log.info("Project deleted with id: " + id);
        return ResponseEntity.noContent().build();
    }
}
