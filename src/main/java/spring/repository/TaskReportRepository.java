package spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.TaskReport;

@Repository
public interface TaskReportRepository extends JpaRepository<TaskReport, Long> {
}
