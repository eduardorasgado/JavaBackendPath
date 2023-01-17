package com.eduardocode.designpatterns.creational.objectpool.stringbuilder;

import java.util.LinkedList;

public class StringBuilderPool {
    private final LinkedList<StringBuilder> availableBuilders;
    private final int poolSize = 3;

    public StringBuilderPool() {
        this.availableBuilders = new LinkedList<>();

        for (int i = 0; i < poolSize; i++) {
            availableBuilders.add(new StringBuilder());
        }
    }

    public StringBuilder acquire() {
        if(!availableBuilders.isEmpty()) {
            return availableBuilders.pop();
        }

        return new StringBuilder();
    }

    public void release(StringBuilder stringBuilder) {
        availableBuilders.add(stringBuilder);
    }
}
