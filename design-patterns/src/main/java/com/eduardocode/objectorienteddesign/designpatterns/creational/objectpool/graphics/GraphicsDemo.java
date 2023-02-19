package com.eduardocode.objectorienteddesign.designpatterns.creational.objectpool.graphics;

import java.util.Objects;

public class GraphicsDemo {
    public static final ObjectPool<Bitmap> bitmapPool = new ObjectPool<>(() -> new Bitmap("Logo.bmp"), 3);

    public static void main(String[] args) {
        Bitmap b1 = bitmapPool.get();
        b1.setLocation(new Point2D(5, 5));
        System.out.println(b1);
        b1.draw();

        Bitmap b2 = bitmapPool.get();
        b2.setLocation(new Point2D(0, 14));
        System.out.println(b2);
        b2.draw();

        Bitmap b3 = bitmapPool.get();
        b3.setLocation(new Point2D(23, 11));
        System.out.println(b3);
        b3.draw();

        bitmapPool.release(b3);

        Bitmap b4 = bitmapPool.get();
        System.out.println(b4);
        b4.setLocation(new Point2D(1000, 100));
        System.out.println(b4);
        b4.draw();

        System.out.println(Objects.equals(b3, b4));
    }
}
