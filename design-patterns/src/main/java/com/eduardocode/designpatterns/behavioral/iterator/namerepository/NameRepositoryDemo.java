package com.eduardocode.designpatterns.behavioral.iterator.namerepository;

public class NameRepositoryDemo {

    public static void main(String[] args) {
        Container nameRepo = new NameRepository();
        nameRepo.add("Eduard");
        nameRepo.add("Robert");
        nameRepo.add("Steven");
        nameRepo.add("Michael");
        nameRepo.add("Mario");

        Iterator iter;
        for(iter = nameRepo.getIterator(); iter.hasNext();) {
            String name = (String) iter.next();
            System.out.println("Name: " + name);
        }

        // exception
        String name = (String) iter.next();
    }
}
