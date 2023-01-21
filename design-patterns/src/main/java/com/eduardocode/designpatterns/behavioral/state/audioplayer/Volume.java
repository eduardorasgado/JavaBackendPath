package com.eduardocode.designpatterns.behavioral.state.audioplayer;

public class Volume {
    private int amount;

    public Volume(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
