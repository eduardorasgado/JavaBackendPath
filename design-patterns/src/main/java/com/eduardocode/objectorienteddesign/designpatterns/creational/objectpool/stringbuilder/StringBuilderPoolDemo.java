package com.eduardocode.objectorienteddesign.designpatterns.creational.objectpool.stringbuilder;

public class StringBuilderPoolDemo {

    public static void main(String[] args) {
        StringBuilderPool pool = new StringBuilderPool();
        StringBuilder sb1 = pool.acquire();

        sb1.append("Hello ");
        sb1.append("Neighbor ");
        sb1.append(" from ");
        sb1.append(" here");

        System.out.println(sb1.toString());

        StringBuilder sb2 = pool.acquire();
        sb2.append("Hello");

        pool.release(sb1);

        StringBuilder sb3 = pool.acquire();
        sb3.append("World");

        System.out.println(sb2.toString());
        System.out.println(sb3.toString());

        pool.release(sb3);
        pool.release(sb2);

        sb1 = pool.acquire();

        System.out.println(sb1.toString());
    }
}
