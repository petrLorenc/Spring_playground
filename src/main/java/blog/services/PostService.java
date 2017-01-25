package blog.services;

import blog.models.Post;

import java.util.List;

/**
 * Created by United121 on 1/23/2017.
 *

 */
public interface PostService {
    List<Post> findAll();
    List<Post> findLatest5();
    Post findById(Long id);
    Post create(Post post);
    Post edit(Post post);
    void deleteById(Long id);
}
