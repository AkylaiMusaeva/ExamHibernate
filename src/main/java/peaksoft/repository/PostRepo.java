package peaksoft.repository;

import peaksoft.entity.Post;

import java.util.List;
import java.util.Map;

public interface PostRepo {
    void savePost(Long userId, Post post);

    Map<String, List<Post>> getPostsByUserId(Long userId);

    Post searchPost(String query);

    void deletePostById(Long id);
}
