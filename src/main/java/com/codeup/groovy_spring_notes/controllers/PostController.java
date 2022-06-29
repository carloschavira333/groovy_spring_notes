package com.codeup.groovy_spring_notes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class PostController {

    @GetMapping("/posts")
    public String posts(String posts){
        return "Here are your posts " + posts;
    }

    @GetMapping("/posts/{id}")
    public String viewInvidualPost(String id){
        return "posts " + id;
    }

    @GetMapping("/posts/create")
    public String postFormCreate(String create){
        return "Please click here to fill out post " + create;
    }

    @PostMapping("/posts/create")
    public String createPost(){
        return;
    }



}
