package com.eduardocode.objectorienteddesign.designpatterns.behavioral.strategy.compression;

public class RarCompressionStrategy implements CompressionStrategy {

    @Override
    public void compress(String filename) {
        System.out.println("Compressing " + filename + " using a RAR compression strategy.");
    }
}
