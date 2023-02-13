package com.eduardocode.objectorienteddesign.designpatterns.creational.simplefactory.posts;

import java.util.NoSuchElementException;

public class PostFactory {

    public enum PostType {
        BLOG,
        NEWS,
        PRODUCT;
    }

    public static Post createPost(PostType type) {
        switch (type) {
            case BLOG:
                return new BlogPost();
            case NEWS:
                return new NewsPost();
            case PRODUCT:
                return new ProductPost();
            default:
                throw new IllegalArgumentException("Given post type is unknown.");
        }
    }
}
