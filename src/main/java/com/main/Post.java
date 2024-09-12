package com.main;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private final int id;
    private  User user;
    private String content;
    private List<Comment> comments;  //adding comments

    public Post(int id, User user, String content) {
        this.id= id;
        this.user =user;
        this.content = content;
        this.comments = new ArrayList<>();
    }
    public int getId(){
        return id;
    }
    public String getContent(){
        return content;
    }
    public void addComment(Comment comment){
        comments.add(comment);
    }
}