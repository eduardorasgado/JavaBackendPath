package com.eduardocode.objectorienteddesign.designpatterns.behavioral.mediator.tv;

public class TvDemo {

    public static void main(String[] args) {
         Mediator mediator = new Mediator();

         Tv tv = new Tv(mediator);
         Display display = new Display(mediator);

         Button remoteControlButton = new Button(mediator);

         mediator.setTv(tv);
         mediator.setDisplay(display);

        System.out.println("Tv is on: " + tv.isOn());

        remoteControlButton.press();
        System.out.println("Tv is on: " + tv.isOn());

        remoteControlButton.press();
        System.out.println("Tv is on: " + tv.isOn());
    }
}
