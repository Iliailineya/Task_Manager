package spring.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.model.Project;
import spring.service.ProjectService;

import java.util.List;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/projects")
public class ProjectRestController {

    private final ProjectService projectService;
    private static final Logger logger = Logger.getLogger(ProjectRestController.class);

    public ProjectRestController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/post")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        logger.info("Creating project: " + project);
        Project createdProject = projectService.createProject(project);
        logger.info("Project created: " + createdProject);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable long id) {
        logger.info("Fetching project with id: " + id);
        Project project = projectService.getProjectById(id);
        logger.info("Fetched project: " + project);
        return ResponseEntity.ok(project);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Project>> getAllProjects() {
        logger.info("Fetching all projects");
        List<Project> projects = projectService.getAllProjects();
        logger.info("Fetched all projects: " + projects);
        return ResponseEntity.ok(projects);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable long id, @RequestBody Project projectDetails) {
        logger.info("Updating project with id: " + id);
        Project updatedProject = projectService.updateProject(id, projectDetails);
        logger.info("Updated project: " + updatedProject);
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectById(@PathVariable long id) {
        logger.info("Deleting project with id: " + id);
        projectService.deleteProjectById(id);
        logger.info("Project deleted with id: " + id);
        return ResponseEntity.noContent().build();
    }
}
