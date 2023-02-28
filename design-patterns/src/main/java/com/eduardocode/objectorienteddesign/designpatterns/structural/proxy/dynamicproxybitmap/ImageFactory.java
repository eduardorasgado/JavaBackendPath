package com.eduardocode.objectorienteddesign.designpatterns.structural.proxy.dynamicproxybitmap;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ImageFactory {

    public static Image getImage(String filename) {

        ImageInvocationHandler proxyHandler = new ImageInvocationHandler(filename);

        Map<Method, ImageInvocationHandler.ImageMethodHandler> handlerMap = new HashMap<>();
        handlerMap.put(ImageInvocationHandler.setLocationMethod, proxyHandler.new SetLocationMethodHandler());
        handlerMap.put(ImageInvocationHandler.getLocationMethod, proxyHandler.new GetLocationMethodHandler());
        handlerMap.put(ImageInvocationHandler.renderMethod, proxyHandler.new RenderMethodHandler());
        proxyHandler.setHandlerMap(handlerMap);

        return (Image) Proxy.newProxyInstance(
                ImageFactory.class.getClassLoader(), new Class[] {Image.class}, proxyHandler);
    }
}
