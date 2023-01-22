package com.eduardocode.designpatterns.behavioral.strategy.compression;

public class ZipCompressionStrategy implements CompressionStrategy {

    @Override
    public void compress(String filename) {
        System.out.println("Compressing " + filename + " using a ZIP compression strategy.");
    }
}
