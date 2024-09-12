package com.main;

//comment class
public class Comment {
    private User user;
    private String content;

    public Comment(User user, String content) {
        this.user = user;
        this.content = content;
    }

    // Getter method
    public String getContent() {
        return content;
    }

    // Setter methodu
    public void setContent(String content) {
        this.content = content;
    }
}