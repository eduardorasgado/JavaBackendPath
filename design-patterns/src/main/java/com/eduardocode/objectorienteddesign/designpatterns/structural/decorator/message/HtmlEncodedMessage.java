package com.eduardocode.objectorienteddesign.designpatterns.structural.decorator.message;

import org.apache.commons.lang3.StringEscapeUtils;

public class HtmlEncodedMessage extends Message {

    public HtmlEncodedMessage(IMessage message) {
        super(message);
    }

    @Override
    public String getContent() {
        return StringEscapeUtils.escapeHtml4(super.getContent());
    }
}
