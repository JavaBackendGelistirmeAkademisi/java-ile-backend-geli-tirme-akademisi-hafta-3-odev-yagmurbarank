package com.main;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.TreeSet;

public class User {
    private String name;
    private LinkedHashMap<Integer, Post> posts;
    private HashSet<User> following;
    private TreeSet<Post> favorites;
    private static int postCounter = 0;

    public User(String name) {
        this.name = name;
        this.posts = new LinkedHashMap<>();
        this.following = new HashSet<>();
        this.favorites = new TreeSet<>(Comparator.comparingInt(Post::getId));
    }

    public String getName() {
        return name;
    }

    public void follow(User user) {
        following.add(user);
        System.out.println(name + " follows " + user.getName());
    }

    public void createPost(String content) {
        Post newPost = new Post(postCounter++, this, content);
        posts.put(newPost.getId(), newPost);
        System.out.println(name + " shared new post: " + content);
    }

    public void addCommentToPost(User user, int postId, String comment) {
        Post post = user.getPost(postId);
        if (post != null) {
            post.addComment(new Comment(this, comment));
            System.out.println(name + " commented on " + user.getName() + "'s post: " + comment);
        }
    }

    public void addToPostFavorites(User user, int postId) {
        Post post = user.getPost(postId);
        if (post != null) {
            favorites.add(post);
            System.out.println(name + " liked " + user.getName() + "'s post: " + post.getContent());
        }
    }

    public void showFeed() {
        System.out.println("\n" + name + "'s homepage");
        for (User user : following) {
            user.showPosts();
        }
    }

    public Post getPost(int postId) {
        return posts.get(postId);
    }

    public void showPosts() {
        for (Post post : posts.values()) {
            System.out.println(post.getContent());
        }
    }
}
