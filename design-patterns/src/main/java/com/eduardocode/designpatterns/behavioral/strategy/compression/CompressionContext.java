package com.eduardocode.designpatterns.behavioral.strategy.compression;

import static java.util.Objects.isNull;

public class CompressionContext {
    private CompressionStrategy strategy;

    public void compressFile(String filename) throws IllegalStateException {
        if(isNull(strategy)) {
            throw new IllegalStateException();
        } else {
            strategy.compress(filename);
        }
    }

    public void setStrategy(CompressionStrategy strategy) {
        this.strategy = strategy;
    }
}
