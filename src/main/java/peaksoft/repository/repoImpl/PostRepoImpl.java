package peaksoft.repository.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import peaksoft.config.DatabaseConnection;
import peaksoft.entity.Post;
import peaksoft.entity.User;
import peaksoft.repository.PostRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRepoImpl implements PostRepo {
    private final EntityManagerFactory entityManagerFactory = DatabaseConnection.getEntityManagerFactory();
    private final SessionFactory sessionFactory = DatabaseConnection.getSessionFactory();

    @Override
    public void savePost(Long userId, Post post) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, userId);
        post.setUser(user);
        entityManager.persist(post);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Map<String, List<Post>> getPostsByUserId(Long userId) {
        Map<String, List<Post>> map = new HashMap<>();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, userId);
        List<Post> posts = user.getPosts();
        map.put(user.getUsername(), posts);
        entityManager.getTransaction().commit();
        entityManager.close();
        return map;
    }

    @Override
    public Post searchPost(String query) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Post post = entityManager.createQuery("""
                select p from Post p where image ilike ?1
                """, Post.class).setParameter(1, query + "%").getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return post;
    }

    @Override
    public void deletePostById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Post post = entityManager.find(Post.class, id);
        post.setUser(null);
        entityManager.remove(post);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
