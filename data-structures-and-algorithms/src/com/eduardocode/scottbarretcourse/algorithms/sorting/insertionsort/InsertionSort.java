package com.eduardocode.scottbarretcourse.algorithms.sorting.insertionsort;

import com.eduardocode.scottbarretcourse.algorithms.sorting.ArraySortingAlgorithm;

public class InsertionSort extends ArraySortingAlgorithm {

    public static void main(String[] args) {
        InsertionSort app = new InsertionSort();

        int[] arr = {4, 2, 6, 5, 1, 3};
        app.runTest(arr);

        int[] arr2 = {4};
        app.runTest(arr2);
    }


    @Override
    protected void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }
}
