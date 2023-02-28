package com.eduardocode.objectorienteddesign.designpatterns.structural.proxy.dynamicproxybitmap;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ImageInvocationHandler implements InvocationHandler {

    private final String filename;
    private Point2D location;
    private BitmapImage image;

    protected static final Method setLocationMethod;
    protected static final Method getLocationMethod;
    protected static final Method renderMethod;

    private Map<Method, ImageMethodHandler> handlerMap;

    static {
        try {
            setLocationMethod = Image.class.getMethod("setLocation", Point2D.class);
            getLocationMethod = Image.class.getMethod("getLocation");
            renderMethod = Image.class.getMethod("render");
        }
        catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public ImageInvocationHandler(String filename) {
        if(isNull(filename) || filename.isBlank()) {
            throw new IllegalArgumentException("name should not be neither null nor blank");
        }

        this.filename = filename;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        handlerMap.get(method).handle(args);
        return null;
    }

    public void setHandlerMap(Map<Method, ImageMethodHandler> handlerMap) {
        if(isNull(handlerMap) || handlerMap.isEmpty()) {
            throw new IllegalArgumentException("handlerMap should not be neither null nor empty");
        }

        this.handlerMap = handlerMap;
    }

    protected interface ImageMethodHandler {

        Object handle(Object[] args);
    }

    protected class SetLocationMethodHandler implements ImageMethodHandler {

        @Override
        public Object handle(Object[] args) {
            if(isNull(args[0])) {
                throw new IllegalArgumentException("point2d should not be null");
            }

            Point2D point2d = (Point2D) args[0];

            if(nonNull(image)) {
                image.setLocation(point2d);
            }
            else {
                location = point2d;
            }
            return null;
        }
    }

    protected class GetLocationMethodHandler implements ImageMethodHandler {

        @Override
        public Object handle(Object[] args) {
            if(nonNull(image)) {
                return image.getLocation();
            }

            return location;
        }
    }

    protected class RenderMethodHandler implements ImageMethodHandler {

        @Override
        public Object handle(Object[] args) {
            if(isNull(location)) {
                throw new IllegalStateException("location attribute was not set for image");
            }

            if(isNull(image)) {
                image = new BitmapImage(filename);
                image.setLocation(location);
            }

            image.render();

            return null;
        }
    }
}
