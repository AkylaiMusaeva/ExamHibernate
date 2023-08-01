package peaksoft.repository;

import peaksoft.entity.Comment;

import java.util.List;

public interface CommentRepo {
   void saveComment(Long postId, Long userId, Comment comment);

    List<Comment> findCommentByPostId(Long postId);

    void updateComment(Long commentID, String newText);
    public String deleteComment(Comment comment);
}
