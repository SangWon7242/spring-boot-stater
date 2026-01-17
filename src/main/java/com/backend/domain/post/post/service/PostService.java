package com.backend.domain.post.post.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.backend.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import com.backend.domain.post.post.entity.Post;

@Service
@RequiredArgsConstructor
public class PostService {
  private final PostRepository postRepository;

  public List<Post> findAll() {
    return postRepository.findAll();
  }

  public Long count() {
    return postRepository.count();
  }

  public void write(String title, String content) {
    Post post = Post.builder()
        .title(title)
        .content(content)
        .build();

    postRepository.save(post);
  }

  public Post findById(long id) {
    return postRepository.findById(id).orElse(null);
  }
}
