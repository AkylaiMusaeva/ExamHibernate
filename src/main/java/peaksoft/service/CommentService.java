package peaksoft.service;

import peaksoft.entity.Comment;

import java.util.List;

public interface CommentService {
    String saveComment(Long postId, Long userId, Comment comment);

    List<Comment> findCommentByPostId(Long postId);

    String updateComment(Long commentID, String newText);

    String deleteComment(Comment comment);
}
