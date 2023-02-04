package com.eduardocode.scottbarretcourse.algorithms.sorting.selectionsort;

import com.eduardocode.scottbarretcourse.algorithms.sorting.ArrayAlgorithm;

public class SelectionSortDemo extends ArrayAlgorithm {

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 5, 1, 3};

        printArr(arr);
        selectionSort(arr);
        printArr(arr);

        int[] arr2 = {4};

        printArr(arr2);
        selectionSort(arr2);
        printArr(arr2);
    }

    private static void selectionSort(int[] arr) {
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
