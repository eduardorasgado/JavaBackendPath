package com.eduardocode.objectorienteddesign.designprinciples.solidprinciples.dependencyinversion.before;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Main extends MetadataExtracter {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {

        Message msg = new Message("This is a message again");

        MessagePrinter printer = new MessagePrinter();

        String msgPath = System.getProperty("user.dir")
                + File.separator
                + getCurrPackagePath()
                + File.separator
                + "test_msg.txt";

        logger.info(msgPath);
        printer.writeMessage(msg, msgPath);
    }

}