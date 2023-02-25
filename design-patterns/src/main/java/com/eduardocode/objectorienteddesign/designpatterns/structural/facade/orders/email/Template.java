package com.eduardocode.objectorienteddesign.designpatterns.structural.facade.orders.email;

public abstract class Template {

    public enum TemplateType {Email, NewsLetter};

    public abstract String format(Object obj);
}
