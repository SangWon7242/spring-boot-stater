package com.backend.domain.post.post.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate; // RestTemplate 임포트
import com.backend.domain.post.post.service.PostService;
import com.backend.domain.post.post.dto.Todo; // Todo DTO 임포트

import lombok.RequiredArgsConstructor;
import com.backend.domain.post.post.entity.Post;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
  private final PostService postService;
  private final RestTemplate restTemplate; // RestTemplate 주입

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

  @GetMapping("/list/todos")
  public String getTodos(Model model) {
    String apiUrl = "https://jsonplaceholder.typicode.com/todos";
    // RestTemplate을 사용하여 외부 API 호출
    Todo[] todosArray = restTemplate.getForObject(apiUrl, Todo[].class);
    List<Todo> todos = Arrays.asList(todosArray);

    model.addAttribute("todos", todos); // 모델에 todos 추가

    return "posts/todos";
  }
}
