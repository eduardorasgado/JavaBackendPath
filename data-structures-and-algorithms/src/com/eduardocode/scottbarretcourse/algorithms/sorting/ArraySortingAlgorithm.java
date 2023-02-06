package com.eduardocode.scottbarretcourse.algorithms.sorting;

public abstract class ArraySortingAlgorithm {
    private final ArrayPrinter arrayPrinter;

    public ArraySortingAlgorithm() {
        this.arrayPrinter = new ArrayPrinter();
    }

    protected void runTest(int[] arr) {
        arrayPrinter.printArr(arr);
        sort(arr);
        arrayPrinter.printArr(arr);
        System.out.println();
    }

    protected abstract void sort(int[] arr);
}
