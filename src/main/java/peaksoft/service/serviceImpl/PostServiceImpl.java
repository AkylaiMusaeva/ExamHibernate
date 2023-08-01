package peaksoft.service.serviceImpl;

import peaksoft.entity.Post;
import peaksoft.repository.PostRepo;
import peaksoft.repository.repoImpl.PostRepoImpl;
import peaksoft.service.PostService;

import java.util.List;
import java.util.Map;

public class PostServiceImpl implements PostService {
    PostRepo postRepo=new PostRepoImpl();
    @Override
    public String savePost(Long userId, Post post) {
        postRepo.savePost(userId,post) ;
        return "Post is successfully saved!";
    }

    @Override
    public Map<String, List<Post>> getPostsByUserId(Long userId) {
        return postRepo.getPostsByUserId(userId);
    }

    @Override
    public Post searchPost(String query) {
        return postRepo.searchPost(query);
    }

    @Override
    public String deletePostById(Long id) {
        postRepo.deletePostById(id);
        return "Successfully deleted post with id="+id;
    }
}
