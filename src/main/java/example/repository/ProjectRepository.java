package example.repository;

import example.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepository {
    private final SessionFactory sessionFactory;

    public ProjectRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Project save(Project project) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(project);
            session.getTransaction().commit();
            return project;
        }
    }

    public List<Project> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Project", Project.class).list();
        }
    }

    public Optional<Project> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Project account = session.get(Project.class, id);
            return Optional.ofNullable(account);
        }
    }

    public void updateProject(Project project) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(project);
            session.getTransaction().commit();
        }
    }

    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Project account = session.get(Project.class, id);
            if (account != null) {
                session.remove(account);
            }
            session.getTransaction().commit();
        }
    }

    public boolean existsById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Project account = session.get(Project.class, id);
            return account != null;
        }
    }
}
