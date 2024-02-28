package spring.repository;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import spring.model.TaskReport;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskReportRepository {
    private final SessionFactory sessionFactory;

    public TaskReportRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public TaskReport save(TaskReport taskReport) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(taskReport);
            session.getTransaction().commit();
            return taskReport;
        }
    }

    public List<TaskReport> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from TaskReport", TaskReport.class).list();
        }
    }

    public Optional<TaskReport> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            TaskReport taskReport = session.get(TaskReport.class, id);
            return Optional.ofNullable(taskReport);
        }
    }

    public void updateTaskReport(TaskReport taskReport) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(taskReport);
            session.getTransaction().commit();
        }
    }

    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            TaskReport taskReport = session.get(TaskReport.class, id);
            if (taskReport != null) {
                session.remove(taskReport);
            }
            session.getTransaction().commit();
        }
    }

    public boolean existsById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            TaskReport taskReport = session.get(TaskReport.class, id);
            return taskReport != null;
        }
    }
}
