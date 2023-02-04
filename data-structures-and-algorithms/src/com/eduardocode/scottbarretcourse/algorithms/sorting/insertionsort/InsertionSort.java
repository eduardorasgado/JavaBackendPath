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

            for (int j = i; j > 0; j--) {
                if(arr[j] < arr[j - 1]) {
                    int temp = arr[j];

                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
