package com.eduardocode.objectorienteddesign.designpatterns.behavioral.iterator.color;

import java.util.NoSuchElementException;

public enum ThemeColor {
    RED,
    ORANGE,
    BLACK,
    WHITE;

    public static Iterator<ThemeColor> getIterator() {
        return new ThemeColorIterator();
    }

    private static class ThemeColorIterator implements Iterator<ThemeColor>{

        private int position;

        public ThemeColorIterator() {
            this.position = 0;
        }

        @Override
        public boolean hasNext() {
            return position < ThemeColor.values().length;
        }

        @Override
        public ThemeColor next() {
            if(hasNext()) {
                return ThemeColor.values()[position++];
            }
            throw new NoSuchElementException("Theme Color iterator has no more elements to iterate over");
        }
    }
}
