package com.eduardocode.scottbarretcourse.algorithms.sorting.mergesort;

import com.eduardocode.scottbarretcourse.algorithms.sorting.ArraySortingAlgorithm;

public class MergeSort extends ArraySortingAlgorithm {

    public static void main(String[] args) {
        MergeSort app = new MergeSort();

        int[] arr = {4, 2, 6, 5, 1, 3};
        app.runTest(arr);

        int[] arr2 = {4};
        app.runTest(arr2);
    }

    @Override
    protected void sort(int[] arr) {
        
    }
}
