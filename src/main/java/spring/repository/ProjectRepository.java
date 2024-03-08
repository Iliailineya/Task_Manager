package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    boolean existsByProjectName(String username);
}
