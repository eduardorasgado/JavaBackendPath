package com.eduardocode.scottbarretcourse.algorithms.sorting.mergesort;

import com.eduardocode.scottbarretcourse.algorithms.sorting.ArraySortingAlgorithm;
import com.eduardocode.scottbarretcourse.algorithms.sorting.DivConqSortingAlgorithm;

/*
    Repeated number inside arrays are not supported for this implementation.
 */
public class MergeSort extends DivConqSortingAlgorithm {

    public static void main(String[] args) {
        MergeSort app = new MergeSort();

        int[] arr = {5, 4, 7, 1, 3, 2, 8, 6};
        app.runTest(arr);

        int[] arr2 = {4};
        app.runTest(arr2);

        int[] arr3 = {14, 2, 60, 15, 10, 23, 0};
        app.runTest(arr3);
    }

    @Override
    protected int[] sort(int[] arr) {
        return mergeSort(arr);
    }

    private int[] mergeSort(int[] arr) {
        return mergeSort(arr, 0, arr.length);
    }

    private int[] mergeSort(int[] arr, int fromIdx, int toIdx) {
        if(toIdx - fromIdx == 1) return new int[]{arr[fromIdx]};

        int mid =  ((toIdx - fromIdx) / 2) + fromIdx;

        int[] left = mergeSort(arr, fromIdx, mid);
        int[] right = mergeSort(arr, mid, toIdx);

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize = right.length;
        int[] newArr = new int[leftSize + rightSize];

        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if(left[i] < right[j]) {
                newArr[k++] = left[i++];
            } else if(left[i] > right[j]) {
                newArr[k++] = right[j++];
            }
        }

        for(; i < leftSize; i++) {
            newArr[k++] = left[i];
        }

        for(; j < rightSize; j++) {
            newArr[k++] = right[j];
        }

        return newArr;
    }
}
