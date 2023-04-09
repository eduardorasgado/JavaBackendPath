package com.eduardocode.demo;

public interface ApplicationSettings
{

    int getHeight();

    int getWidth();

    int getOriginHeight();

    int getOriginWidth();

    int getOriginDepth();

    default float centerByWidth(int objectWidthToCenter, int containerWidth)
    {
        return containerWidth / 2 - objectWidthToCenter / 2;
    }
}
