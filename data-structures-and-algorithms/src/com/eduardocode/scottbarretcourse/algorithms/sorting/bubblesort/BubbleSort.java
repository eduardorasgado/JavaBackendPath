package com.eduardocode.scottbarretcourse.algorithms.sorting.bubblesort;

import com.eduardocode.scottbarretcourse.algorithms.sorting.ArraySortingAlgorithm;

public class BubbleSort extends ArraySortingAlgorithm {

    public static void main(String[] args) {
        BubbleSort app = new BubbleSort();

        int[] arr = {4, 2, 6, 5, 1, 3};
        app.runTest(arr);
    }


    @Override
    protected void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
