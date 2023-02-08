package com.eduardocode.objectorienteddesign.designpatterns.behavioral.templatemethod.emails;

public class TransactionalEmail extends Email {
    private String transactionId;

    public TransactionalEmail(String receiverEmail, String transactionId) {
        super(receiverEmail);
        this.transactionId = transactionId;
    }

    private String getTransactionId() {
        return transactionId;
    }

    @Override
    protected void setSender() {
        System.out.println("Sender: transaction@example.com");
    }

    @Override
    protected void setSubject() {
        System.out.println("Subject: Transaction " + getTransactionId() + " receipt");
    }

    @Override
    protected void setBody() {
        System.out.println("Body: Please find the receipt of transaction " + getTransactionId() + " attached.");
    }

    @Override
    protected void setAttachment() {
        System.out.println("Attachment: receipt_" + getTransactionId() + ".pdf");
    }
}
