package com.eduardocode.objectorienteddesign.designprinciples.solidprinciples.singleresponsability.after;

public class UserPersistence {

    private Store store = new Store();

    public void persist(User user) {
        if(user != null) {
            store.store(user);
        }
    }
}
