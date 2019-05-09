package com.blog.asktask.controller;

import com.blog.asktask.domain.Post;
import com.blog.asktask.domain.User;
import com.blog.asktask.service.PostService;
import com.blog.asktask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Alvin
 **/

@Controller
@RequestMapping("/")
public class ApplicationController {

    private final PostService postService;
    private final UserService userService;

    @Autowired
    public ApplicationController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping
    public String getAll(@RequestParam(required = false) String filter, Model model) {
        List<Post> posts;

        if (filter != null && !filter.isEmpty()) {
            posts = postService.getByTitle(filter);
        } else {
            posts = postService.getAll();
        }

        model.addAttribute("posts", posts);
        model.addAttribute("filter", filter);
        return "mainstream";
    }

    @GetMapping("addPost")
    public String addPost(){
        return "add";
    }

    @GetMapping("userPosts")
    public String usersPosts(@AuthenticationPrincipal User user, Model model){
        List<Post> posts = userService.getPostsByUserId(user.getId());
        model.addAttribute("posts", posts);
        return "userPosts";
    }
}
