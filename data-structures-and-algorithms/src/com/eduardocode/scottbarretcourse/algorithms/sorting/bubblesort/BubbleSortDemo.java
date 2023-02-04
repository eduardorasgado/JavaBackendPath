package com.eduardocode.scottbarretcourse.algorithms.sorting.bubblesort;

import com.eduardocode.scottbarretcourse.algorithms.sorting.ArrayAlgorithm;

public class BubbleSortDemo extends ArrayAlgorithm {

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 5, 1, 3};

        printArr(arr);
        bubbleSort(arr);
        printArr(arr);
    }

    private static void bubbleSort(int[] arr) {
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
