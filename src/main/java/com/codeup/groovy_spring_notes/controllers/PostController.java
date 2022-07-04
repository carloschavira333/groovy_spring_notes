package com.codeup.groovy_spring_notes.controllers;

import com.codeup.groovy_spring_notes.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
@Controller // Spring will initialize the bean for us with this annotation
public class PostController {

    @GetMapping("/posts")
    // The Model interface replaces the servlet functionality like doGet and doPost
    public String posts(Model model){
        // create an ArrayList with a type of Post (this is the Post class in models pkg) call it something relevant (like "allPosts) set it equal to a new ArrayList<>()
        ArrayList<Post> allPosts = new ArrayList<>();
        // line below is the same as:  request.setAttribute("allPosts", allPosts);
        model.addAttribute("allPosts", allPosts);
        // the value allPosts can then be consumed by the index page with a for each loop
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    //The @PathVariable annotation is used to extract the value form the URI
    public String viewIndividualPost(@PathVariable("id") long id, Model model){
        model.addAttribute("singlePost", new Post("This is a single post."));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String postFormCreate(String create){
        return "Please click here to fill out post " + create;
    }

//    @PostMapping("/posts/create")
//    public String createPost(){
//        return;
//    }



}
