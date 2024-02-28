package spring.repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import spring.model.Task;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepository {
    private final SessionFactory sessionFactory;

    public TaskRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Task save(Task task) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(task);
            session.getTransaction().commit();
            return task;
        }
    }

    public List<Task> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Task", Task.class).list();
        }
    }

    public Optional<Task> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Task task = session.get(Task.class, id);
            return Optional.ofNullable(task);
        }
    }

    public void updateTask(Task task) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(task);
            session.getTransaction().commit();
        }
    }

    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Task task = session.get(Task.class, id);
            if (task != null) {
                session.remove(task);
            }
            session.getTransaction().commit();
        }
    }

    public boolean existsById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Task task = session.get(Task.class, id);
            return task != null;
        }
    }
}
