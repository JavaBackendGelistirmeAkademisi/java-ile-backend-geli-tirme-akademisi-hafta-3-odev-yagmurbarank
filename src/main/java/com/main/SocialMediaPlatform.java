package com.main;
import java.util.*;


public class SocialMediaPlatform {


    class User{
        private String name;
        private LinkedHashMap<Integer, Post> posts; //Kullanıcının gönderileri
        private HashSet<User> following; //Takip edilen kullanıcılar
        private TreeSet<Post> favorites; //Beğenilen Gönderiler
        private static int postCounter = 0; //Gönderi Sayacı

        public User(String name){
            this.name = name;
            this.posts = new LinkedHashMap<Integer, Post>();
            this.following = new HashSet<>();
            this.favorites = new TreeSet<>(Comparator.comparingInt(Post::getId));

        }
        public String getName(){
            return name;
        }

        public void follow (User user){
            following.add(user);
            System.out.println(name + ", " + user.getName() + "kullanıcısını takip ediyor");

        }

        public void createPost (String content){
            Post newPost = new Post(postCounter++, this, content);
            posts.put(newPost.getId(), newPost);
            System.out.println(name + "yeni bir gönderi yayınladı:" + content);
        }

        public void addCommentToPost (User user, int postId, String comment){
            Post post = user.getPost(postId);
            if (post != null){
                post.addComment(new Comment(this, comment));
                System.out.println(name + ", " + user.getName() + "'in gönderisine yorum yaptı." + comment);
            }

            }

        public void addToPostFavorites(User user, int postId){
            Post post = user.getPost(postId);
            if (post != null){
                favorites.add(post);
                System.out.println(name + ", " + user.getName() + "'in gönderisini beğendi"+ post.getContent());
            }


        }



        public void showFeed(){
            System.out.println("\n" + name + "'in  Ana Sayfası");
            for (User user : following){
                user.showPosts();
            }


        }
        public  Post getPost(int postId){
            return posts.get(postId);
        }
        public void showPosts(){
            for(Post post : posts.values()){
                System.out.println(post.getContent());
            }
        }
    }
    //post class for post
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
        public static void main(String[] args) {
            SocialMediaPlatform platform = new SocialMediaPlatform();
            User user1 = platform.new User("Ali");
            User user2 = platform.new User("Ayşe");

            user1.follow(user2);
            user2.createPost("Merhaba Dünya!");
            user1.addCommentToPost(user2, 0, "Hoş geldin!");
            user1.addToPostFavorites(user2, 1);
            user1.showFeed();

    }

}
