package peaksoft.service.serviceImpl;

import peaksoft.entity.Comment;
import peaksoft.repository.CommentRepo;
import peaksoft.repository.repoImpl.CommentRepoImpl;
import peaksoft.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    CommentRepo commentRepo=new CommentRepoImpl();
    @Override
    public String saveComment(Long postId, Long userId, Comment comment) {
        commentRepo.saveComment(postId, userId, comment);
        return "Successfully saved a new comment!";
    }

    @Override
    public List<Comment> findCommentByPostId(Long postId) {
        return commentRepo.findCommentByPostId(postId);
    }

    @Override
    public String updateComment(Long commentID, String newText) {
        commentRepo.updateComment(commentID,newText);
        return "Successfully updated comment with id ="+commentID;
    }

    @Override
    public String deleteComment(Comment comment) {
        return commentRepo.deleteComment(comment);
    }
}
