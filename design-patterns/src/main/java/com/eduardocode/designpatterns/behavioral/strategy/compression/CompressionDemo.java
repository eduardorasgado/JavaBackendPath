package com.eduardocode.designpatterns.behavioral.strategy.compression;

public class CompressionDemo {

    public static void main(String[] args) {
        CompressionContext context = new CompressionContext();

        context.setStrategy(new RarCompressionStrategy());
        context.compressFile("example.txt");

        context.setStrategy(new ZipCompressionStrategy());
        context.compressFile("example.txt");
    }
}
