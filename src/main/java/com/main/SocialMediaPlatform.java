package com.main;

public class SocialMediaPlatform {

    public static void main(String[] args) {
        User user1 = new User("Ali");
        User user2 = new User("Ayşe");

        user1.follow(user2);
        user2.createPost("Merhaba Dünya!");
        user1.addCommentToPost(user2, 0, "Hoş geldin!");
        user1.addToPostFavorites(user2, 0);
        user1.showFeed();
    }
}

