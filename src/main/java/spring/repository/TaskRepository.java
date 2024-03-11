package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
