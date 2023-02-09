package com.eduardocode.objectorienteddesign.designprinciples.solidprinciples.dependencyinversion.after;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main extends MetadataExtracter {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        MessagePrinter printer = new MessagePrinter();
        Message msg = new Message("This is a message again");
        String msgPath = System.getProperty("user.dir")
                + File.separator
                + getCurrPackagePath()
                + File.separator
                + "test_msg.txt";

        logger.info(msgPath);

        try(PrintWriter writer = new PrintWriter(new FileWriter(msgPath))) {
        //try(PrintWriter writer = new PrintWriter(System.out)) {
            //printer.writeMessage(msg, new TextFormatter(), writer);
            printer.writeMessage(msg, new JsonFormatter(), writer);
        }
        catch (FormatException e) {
            logger.error("Error trying to format a message");
        } catch (IOException e) {
            logger.error("Error trying to write a message");
        }
    }
}