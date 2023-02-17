package com.eduardocode.objectorienteddesign.designpatterns.behavioral.iterator.builtin;

import java.util.*;

public class BuildInIteratorDemo {

    public static void main(String[] args) {
        List<String> arrList = new ArrayList<>() {
            {
                add("I");
                add("want");
                add("to");
                add("code");
            }
        };
        List<String> linkList = new LinkedList<>(){
            {
                add("I");
                add("want");
                add("to");
                add("dance");
            }
        };
        Set<String> hashSet = new HashSet<>() {
            {
                add("I");
                add("want");
                add("to");
                add("dream");
            }
        };

        Iterator<String> iterator1 = arrList.iterator();
        Iterator<String> iterator2 = linkList.iterator();
        Iterator<String> iterator3 = hashSet.iterator();

        while(iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        System.out.println();

        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
        System.out.println();
        
        while(iterator3.hasNext()) {
            System.out.println(iterator3.next());
        }
    }
}
