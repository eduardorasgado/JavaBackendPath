package com.eduardocode.scottbarretcourse.algorithms.sorting.quicksort;

import com.eduardocode.scottbarretcourse.algorithms.sorting.DivConqSortingAlgorithm;

import java.util.Arrays;

public class QuickSort extends DivConqSortingAlgorithm {

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
            result[i] = right[i];
        }

        return result;
    }

    private int getPivot(int[] arr) {
        int pivotIdx = 0;
        int firstGreaterThanPivot = 1;
        int currIdx = 1;

        while (currIdx < arr.length) {

            if(arr[currIdx] < arr[pivotIdx]) {
                if(currIdx != firstGreaterThanPivot) {
                    swap(arr, firstGreaterThanPivot, currIdx);
                }

                ++firstGreaterThanPivot;
            }

            ++currIdx;
        }

        int newPivot = firstGreaterThanPivot - 1;
        if(pivotIdx != newPivot) {
            swap(arr, newPivot, pivotIdx);
        }

        return newPivot;
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];

        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        QuickSort app = new QuickSort();

        app.runTest(new int[]{5, 4, 7, 1, 3, 2, 8, 6});

        //app.runTest(new int[]{4});

        //app.runTest(new int[]{14, 2, 60, 15, 10, 23, 0});

        //app.runTest(new int[]{5, 4, 7, 1, 3, 2, 8, 6, 7, 3});
    }
}
