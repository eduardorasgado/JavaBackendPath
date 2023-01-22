package com.eduardocode.designpatterns.behavioral.templatemethod.emails;

public class MarketingEmail extends Email {
    private String product;

    public MarketingEmail(String receiverEmail, String product) {
        super(receiverEmail);
        this.product = product;
    }

    public String getProduct() {
        return product;
    }

    @Override
    protected void setSender() {
        System.out.println("Sender: marketing@example.com");
    }

    @Override
    protected void setSubject() {
        System.out.println("Subject: Special offer on " + getProduct());
    }

    @Override
    protected void setBody() {
        System.out.println("Body: Dont miss out special offer on " + getProduct());
    }

    @Override
    protected void setAttachment() {
        System.out.println("Attachment: " + getProduct() + ",pdf");
    }
}
