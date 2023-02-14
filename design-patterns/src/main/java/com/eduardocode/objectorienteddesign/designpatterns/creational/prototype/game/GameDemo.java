package com.eduardocode.objectorienteddesign.designpatterns.creational.prototype.game;

public class GameDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Swordsman swordsman = new Swordsman();
        System.out.println(swordsman);

        swordsman.move(new Point3D(10f, 12f, 2f), 5f);
        System.out.println(swordsman);

        Swordsman swordsman2 = swordsman.clone();
        System.out.println(swordsman == swordsman2);
        System.out.println(swordsman2);

        General general = new General();
        System.out.println(general.clone());
    }
}
