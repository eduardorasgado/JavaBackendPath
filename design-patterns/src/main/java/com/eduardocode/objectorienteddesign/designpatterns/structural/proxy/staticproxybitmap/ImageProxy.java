package com.eduardocode.objectorienteddesign.designpatterns.structural.proxy.staticproxybitmap;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ImageProxy implements Image {
    private BitmapImage image;
    private final String name;
    private Point2D location;

    public ImageProxy(String name) {
        if(isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("name should not be neither null nor blank");
        }

        this.name = name;
    }

    @Override
    public void setLocation(Point2D point2d) {
        if(isNull(point2d)) {
            throw new IllegalArgumentException("point2d should not be null");
        }

        if(nonNull(image)) {
            image.setLocation(point2d);
        }
        else {
            location = point2d;
        }
    }

    @Override
    public Point2D getLocation() {
        if(nonNull(image)) {
            return image.getLocation();
        }

        return location;
    }

    @Override
    public void render() {
        if(isNull(location)) {
            throw new IllegalStateException("location attribute was not set for image");
        }

        if(isNull(image)) {
            image = new BitmapImage(name);
            image.setLocation(location);
        }

        image.render();
    }
}
