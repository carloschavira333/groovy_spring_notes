package com.codeup.groovy_spring_notes.controllers;

import com.codeup.groovy_spring_notes.models.Post;
import com.codeup.groovy_spring_notes.repositories.PostRepository;
import com.codeup.groovy_spring_notes.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller // Spring will initialize the bean for us with this annotation
public class PostController {
// before we can use methods of other classes,
// we first need to create the object of that class
// One of the ways we can do this, is in the constructor.
// Spring provides us with some facilities to use
// automatic dependency injection in our classes.
//
// The following example shows how we can inject
// AdRepository into our AdController.
//class AdController {
//    private final AdRepository adDao;
//
//    public AdController(AdRepository adDao) {
//        this.adDao = adDao;
//    }
//}
    // create field
    private final PostRepository postDao;
    private final UserRepository userDao;
    // add/create constructor
    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String posts(Model model){
//        // create an ArrayList with a type of Post (this is the Post class in models pkg) call it something relevant (like "allPosts) set it equal to a new ArrayList<>()
//        ArrayList<Post> allPosts = new ArrayList<>();
//        // line below is the same as:  request.setAttribute("allPosts", allPosts);
//        model.addAttribute("allPosts", allPosts);
//        // the value allPosts can then be consumed by the index page with a for each loop

        model.addAttribute("posts", postDao.findAll());
        model.addAttribute("users", userDao.findAll());


        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    //The @PathVariable annotation is used to extract the value form the URI
    public String viewIndividualPost(@PathVariable("id") long id, Model model){
        Post post = postDao.getById(id);
        model.addAttribute("singlePost", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String postFormCreate(Model model){

        model.addAttribute("newPost", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam("title") String title, @RequestParam("body") String body){
        postDao.save(new Post(title, body));
        return "redirect:/posts";

    }

    @GetMapping("/post/{id}/edit")
    public String editPost(@PathVariable long id, Model model){
        Post post = postDao.getById(id);

        model.addAttribute("post",post);
        return "posts/edit";

    }

    @PostMapping("post/{id}/edit")
    public String editAndSubmit(@PathVariable long id, @ModelAttribute Post post){
        postDao.save(post);
        return "redirect:/post";
    }



}
