package com.eduardocode.scottbarretcourse.algorithms.sorting;

public abstract class DivConqSortingAlgorithm {
    private final ArrayPrinter arrayPrinter;

    public DivConqSortingAlgorithm() {
        this.arrayPrinter = new ArrayPrinter();
    }

    protected void runTest(int[] arr) {
        arrayPrinter.printArr(arr);
        arrayPrinter.printArr(sort(arr));
    }

    protected abstract int[] sort(int[] arr);
}
