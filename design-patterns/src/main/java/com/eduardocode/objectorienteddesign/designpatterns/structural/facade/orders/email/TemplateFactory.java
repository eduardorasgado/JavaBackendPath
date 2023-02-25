package com.eduardocode.objectorienteddesign.designpatterns.structural.facade.orders.email;

import com.eduardocode.objectorienteddesign.designpatterns.structural.facade.orders.email.Template.TemplateType;

public class TemplateFactory {
    public static Template createTemplateFor(TemplateType type) {
        switch (type) {
            case Email:
                return new OrderEmailTemplate();
            default:
                throw new IllegalArgumentException("Unknown TemplateType");
        }
    }
}
