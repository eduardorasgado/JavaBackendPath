package com.eduardocode.scottbarretcourse.algorithms.sorting.quicksort;

import com.eduardocode.scottbarretcourse.algorithms.sorting.ArraySortingAlgorithm;

import java.util.Arrays;

public class QuickSort extends ArraySortingAlgorithm {

    public static void main(String[] args) {
        QuickSort app = new QuickSort();

        app.runTest(new int[]{5, 4, 7, 1, 3, 2, 8, 6});

        app.runTest(new int[]{4});

        app.runTest(new int[]{14, 2, 60, 15, 10, 23, 0});

        app.runTest(new int[]{5, 4, 7, 1, 3, 2, 8, 6, 7, 3});
    }

    @Override
    protected void sort(int[] arr) {
        quickSort(arr);
    }

    private void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length);
    }

    private void quickSort(int[] arr, int fromIdx, int toIdx) {
        if(toIdx - fromIdx > 1) {
            int pivotIdx = getPivot(arr, fromIdx, toIdx);

            quickSort(arr, fromIdx, pivotIdx);
            quickSort(arr, pivotIdx + 1, toIdx);
        }
    }

    private int getPivot(int[] arr, int pivotIdx, int endIdx) {
        int swap = pivotIdx;

        for (int currIdx = pivotIdx + 1; currIdx < endIdx; currIdx++) {
            if(arr[currIdx] < arr[pivotIdx]) {
                ++swap;

                swap(arr, swap, currIdx);
            }
        }

        if(pivotIdx != swap) {
            swap(arr, swap, pivotIdx);
        }

        return swap;
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];

        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
