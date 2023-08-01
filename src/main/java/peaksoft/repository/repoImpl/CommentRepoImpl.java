package peaksoft.repository.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import peaksoft.config.DatabaseConnection;
import peaksoft.entity.Comment;
import peaksoft.entity.Post;
import peaksoft.entity.User;
import peaksoft.repository.CommentRepo;

import java.util.List;

public class CommentRepoImpl implements CommentRepo {
    private final EntityManagerFactory entityManagerFactory = DatabaseConnection.getEntityManagerFactory();
    private final SessionFactory sessionFactory = DatabaseConnection.getSessionFactory();

    @Override
    public void saveComment(Long postId, Long userId, Comment comment) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Post post = entityManager.find(Post.class, postId);
        User user = entityManager.find(User.class, userId);
        post.setUser(user);
        comment.setUser(user);
        post.setComments(List.of(comment));
        entityManager.persist(comment);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Comment> findCommentByPostId(Long postId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Post post = entityManager.find(Post.class, postId);
        List<Comment> comments = post.getComments();
        entityManager.getTransaction().commit();
        entityManager.close();
        return comments;
    }

    @Override
    public void updateComment(Long commentID, String newText) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Comment comment = entityManager.find(Comment.class, commentID);
        comment.setText(newText);
        entityManager.merge(comment);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public String deleteComment(Comment comment) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        comment.setPosts(null);
        comment.setUser(null);
        entityManager.remove(comment);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully deleted!";
    }
}

