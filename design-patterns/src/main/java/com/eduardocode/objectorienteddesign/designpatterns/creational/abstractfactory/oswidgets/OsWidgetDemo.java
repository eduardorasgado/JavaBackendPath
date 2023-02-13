package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.oswidgets;

import java.util.Scanner;

public class OsWidgetDemo {

    public static void main(String[] args) {
        GuiBuilder builder = new GuiBuilder();
        Scanner sc = new Scanner(System.in);

        System.out.println("Insert your OS: [WINDOWS, MACOS]");
        String platform = sc.nextLine();

        if(platform.equalsIgnoreCase("WINDOWS")) {
            builder.buildWindow(new MsWindowsWidgetFactory());
        }
        else {
            builder.buildWindow(new MacOsWidgetFactory());
        }
    }
}
