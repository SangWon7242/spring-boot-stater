package com.backend.domain.post.post.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.backend.domain.post.post.service.PostService;

import lombok.RequiredArgsConstructor;
import com.backend.domain.post.post.entity.Post;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
  private final PostService postService;

  @GetMapping("/list")
  public String getPosts(Model model) {
    List<Post> posts = postService.findAll();
    model.addAttribute("posts", posts);

    return "posts/list"; // Changed from "post/list" to "posts/list"
  }

  @GetMapping("/{id}")
  public String getPost(@PathVariable long id, Model model) {
    Post post = postService.findById(id);
    model.addAttribute("post", post);

    return "posts/detail"; // Changed from "post/detail" to "posts/detail"
  }
}