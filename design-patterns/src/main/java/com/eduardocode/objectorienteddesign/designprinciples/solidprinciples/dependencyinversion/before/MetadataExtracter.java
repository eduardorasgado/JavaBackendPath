package com.eduardocode.objectorienteddesign.designprinciples.solidprinciples.dependencyinversion.before;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class MetadataExtracter {

    protected static String getCurrPackagePath() {
        return replaceDotBySeparatorInString("src.main.java." + MetadataExtracter.class.getPackageName());
    }

    private static String replaceDotBySeparatorInString(String dotSeparatedString) {
        return String.join(File.separator, dotSeparatedString.split("\\."));
    }
}
