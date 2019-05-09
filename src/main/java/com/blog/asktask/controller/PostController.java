package com.blog.asktask.controller;

import com.blog.asktask.domain.Post;
import com.blog.asktask.domain.User;
import com.blog.asktask.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String title,
            @RequestParam String description,
            Map<String, Object> model,
            @RequestParam("file") MultipartFile file) throws IOException {
        Post local = new Post(title, description, user);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadFolder = new File(uploadPath);
            if (!uploadFolder.exists()) {
                uploadFolder.mkdir();
            }
            //generate a primary file id
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFileName));

            local.setFilename(resultFileName);
        }

        postService.save(local);

        List<Post> posts = postService.getAll();

        model.put("posts", posts);

        return "mainstream";
    }

    @PostMapping("{id}")
    public String remove(@AuthenticationPrincipal User user, @PathVariable String id){
        postService.removeById(id);
        return "mainstream";
    }
}