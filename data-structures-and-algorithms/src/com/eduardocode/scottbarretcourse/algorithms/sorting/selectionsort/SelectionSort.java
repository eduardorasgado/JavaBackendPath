package com.eduardocode.scottbarretcourse.algorithms.sorting.selectionsort;


import com.eduardocode.scottbarretcourse.algorithms.sorting.ArraySortingAlgorithm;

public class SelectionSort extends ArraySortingAlgorithm {

    public static void main(String[] args) {
        SelectionSort app = new SelectionSort();

        int[] arr = {4, 2, 6, 5, 1, 3};
        app.runTest(arr);

        int[] arr2 = {4};
        app.runTest(arr2);

    }

    @Override
    protected void sort(int[] arr) {
        int minValIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            minValIndex = i;

            for (int j = minValIndex + 1; j < arr.length; j++) {
                if(arr[j] < arr[minValIndex]) {
                    minValIndex = j;
                }
            }

            if(minValIndex != i) {
                int temp = arr[i];

                arr[i] = arr[minValIndex];
                arr[minValIndex] = temp;
            }
        }
    }
}
