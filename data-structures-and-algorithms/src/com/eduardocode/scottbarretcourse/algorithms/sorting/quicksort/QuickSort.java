package com.eduardocode.scottbarretcourse.algorithms.sorting.quicksort;

import com.eduardocode.scottbarretcourse.algorithms.sorting.DivConqSortingAlgorithm;

import java.util.Arrays;

public class QuickSort extends DivConqSortingAlgorithm {

    public static void main(String[] args) {
        QuickSort app = new QuickSort();

        app.runTest(new int[]{5, 4, 7, 1, 3, 2, 8, 6});

        app.runTest(new int[]{4});

        app.runTest(new int[]{14, 2, 60, 15, 10, 23, 0});

        app.runTest(new int[]{5, 4, 7, 1, 3, 2, 8, 6, 7, 3});
    }

    @Override
    protected int[] sort(int[] arr) {
        return quickSort(arr);
    }

    private int[] quickSort(int[] arr) {
        if(arr.length <= 1) return arr;

        int pivotIdx = getPivot(arr);

        int[] left = quickSort(Arrays.copyOfRange(arr, 0, pivotIdx));
        int[] right = quickSort(Arrays.copyOfRange(arr, pivotIdx + 1, arr.length));

        int[] result = new int[left.length + right.length + 1];

        for (int i = 0; i < left.length; i++) {
            result[i] = left[i];
        }

        result[pivotIdx] = arr[pivotIdx];

        for (int i = 0; i < right.length; i++) {
            result[pivotIdx + i + 1] = right[i];
        }

        return result;
    }

    private int getPivot(int[] arr) {
        int pivotIdx = 0;
        int swap = 0;

        for (int currIdx = 1; currIdx < arr.length; currIdx++) {
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
