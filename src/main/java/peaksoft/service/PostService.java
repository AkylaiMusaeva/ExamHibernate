package peaksoft.service;

import peaksoft.entity.Post;

import java.util.List;
import java.util.Map;

public interface PostService {
    String savePost(Long userId, Post post);

    Map<String, List<Post>> getPostsByUserId(Long userId);

    Post searchPost(String query);

    String deletePostById(Long id);
}

