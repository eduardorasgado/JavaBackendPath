package com.eduardocode.objectorienteddesign.designpatterns.structural.facade.orders;

import com.eduardocode.objectorienteddesign.designpatterns.structural.facade.orders.email.*;

public class OrdersDemo {

    public static void main(String[] args) {
        Order order = new Order("101", 99.99);

        boolean result = sendOrderEmailWithoutFacade(order);
        System.out.println("[without facade] Order Email "+ (result?"sent!":"NOT sent..."));

        boolean result2 = new EmailFacade().sendOrderEmail(order);
        System.out.println("[with facade] Order Email "+ (result2?"sent!":"NOT sent..."));
    }

    private static boolean sendOrderEmailWithoutFacade(Order order) {
        Template template = TemplateFactory.createTemplateFor(Template.TemplateType.Email);
        Stationary stationary = StationaryFactory.createStationary();

        Email email = Email.getBuilder()
                .withTemplate(template)
                .withStationary(stationary)
                .forObject(order)
                .build();

        Mailer mailer = Mailer.getMailer();
        return mailer.send(email);
    }
}
