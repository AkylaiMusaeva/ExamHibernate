package peaksoft.repository.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import peaksoft.config.DatabaseConnection;
import peaksoft.entity.Profile;
import peaksoft.entity.User;
import peaksoft.repository.ProfileRepo;

public class ProfileRepoImpl implements ProfileRepo {
    private final EntityManagerFactory entityManagerFactory = DatabaseConnection.getEntityManagerFactory();
    private final SessionFactory sessionFactory = DatabaseConnection.getSessionFactory();

    @Override
    public void saveProfile(Long userId, Profile profile) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, userId);
        profile.setUser(user);
        entityManager.persist(profile);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void assignProfileToUser(Long profileId, Long userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Profile profile = entityManager.find(Profile.class, profileId);
        User user = entityManager.find(User.class, userId);
        user.setProfile(profile);
        profile.setUser(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateUserProfile(Long userId, Profile profile) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, userId);
        user.setProfile(profile);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Profile findProfileByUserId(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        Profile profile = user.getProfile();
        entityManager.getTransaction().commit();
        entityManager.close();
        return profile;
    }

    @Override
    public void deleteProfileByUserId(Long userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class,userId);
        Profile profile = user.getProfile();
        user.setProfile(null);
        entityManager.remove(profile);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

