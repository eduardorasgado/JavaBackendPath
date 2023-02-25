package com.eduardocode.objectorienteddesign.designpatterns.structural.facade.orders.email;

import com.eduardocode.objectorienteddesign.designpatterns.structural.facade.orders.Order;

public class EmailFacade {

    private Mailer mailer;

    public EmailFacade() {
        mailer = Mailer.getMailer();
    }

    public boolean sendOrderEmail(Order order) {
        Template template = TemplateFactory.createTemplateFor(Template.TemplateType.Email);
        Stationary stationary = StationaryFactory.createStationary();
        
        return sendMail(createEmail(template, stationary, order));
    }


    private Email createEmail(Template template, Stationary stationary, Order order) {
        return Email.getBuilder()
                .withTemplate(template)
                .withStationary(stationary)
                .forObject(order)
                .build();
    }

    private boolean sendMail(Email email) {
        return mailer.send(email);
    }
}
