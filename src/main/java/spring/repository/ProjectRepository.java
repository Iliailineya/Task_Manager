package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    boolean existsByProjectName(String username);
}
