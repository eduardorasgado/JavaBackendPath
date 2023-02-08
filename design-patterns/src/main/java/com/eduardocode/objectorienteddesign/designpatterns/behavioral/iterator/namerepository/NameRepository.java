package com.eduardocode.objectorienteddesign.designpatterns.behavioral.iterator.namerepository;

import java.util.NoSuchElementException;

public class NameRepository implements Container {

    private final String[] names = new String[999];
    private int nextIndex = 0;

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    @Override
    public void add(Object item) {
        names[nextIndex++] = (String) item;
    }

    private int getIterableSize() {
        return nextIndex;
    }

    private Object getIterableItem(int index) {
        return names[index];
    }

    private class NameIterator implements Iterator {
        private int index = 0;

        @Override
        public boolean hasNext() {
            if(index < getIterableSize()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() throws NoSuchElementException {
            if(hasNext()) {
                return getIterableItem(index++);
            }
            throw new NoSuchElementException();
        }
    }
}
