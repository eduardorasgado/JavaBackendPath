package com.eduardocode.objectorienteddesign.designpatterns.creational.simplefactory.posts;

public class PostsDemo {

    public static void main(String[] args) {
        Post post = PostFactory.createPost(PostFactory.PostType.BLOG);
        System.out.println(post.getClass());

        post = PostFactory.createPost(PostFactory.PostType.NEWS);
        System.out.println(post.getClass());
    }
}
