package com.eduardocode.objectorienteddesign.designpatterns.creational.singleton.threadsafe.doublecheckedlocking.order;

public class OrderManagementDemo {

    public static void main(String[] args) {
        OrderManagementService oms1 = OrderManagementService.getInstance();
        OrderManagementService oms2 = OrderManagementService.getInstance();

        System.out.println(oms1 == oms2);
        oms1.placeOrder();
    }
}
