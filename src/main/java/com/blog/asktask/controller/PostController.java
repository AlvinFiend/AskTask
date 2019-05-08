package com.blog.asktask.controller;

import com.blog.asktask.domain.Post;
import com.blog.asktask.domain.User;
import com.blog.asktask.service.PostService;
import com.blog.asktask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final UserService userService;
    private final PostService postService;

    @Autowired
    public PostController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping
    public String getAll(Map<String, Object> model) {
        List<Post> posts = postService.getAll();

        model.put("posts", posts);
        return "mainstream";
    }

    @PostMapping
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String title,
            @RequestParam String description,
            Map<String, Object> model) {
        Post local = new Post(title, description);

        postService.save(local);

        List<Post> posts = postService.getAll();

        model.put("posts", posts);

        return "mainstream";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {

        List<Post> posts;

        if (filter != null && !filter.isEmpty()) {
            posts = postService.getByTitle(filter);
        } else {
            posts = postService.getAll();
        }

        model.put("posts", posts);

        return "mainstream";
    }
}