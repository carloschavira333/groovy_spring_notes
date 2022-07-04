package com.codeup.groovy_spring_notes.models;

public class Post {

    private Long id;
    private String title;
    private String body;

    public Post() {
    }

    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }

    public Post(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
