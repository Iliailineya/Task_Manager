package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.model.TaskReport;

public interface TaskReportRepository extends JpaRepository<TaskReport, Long> {
}
