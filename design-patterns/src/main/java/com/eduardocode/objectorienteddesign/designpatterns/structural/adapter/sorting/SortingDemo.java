package com.eduardocode.objectorienteddesign.designpatterns.structural.adapter.sorting;

import java.util.Arrays;

public class SortingDemo {

    public static void main(String[] args) {
        int[] numbers = new int[]{34, 54, 3, 22, 1, 1000, 90};
        Sorter sorter = new SortListAdapter();

        System.out.println("Before: " + Arrays.toString(numbers));
        System.out.println("After: " + Arrays.toString(sorter.sort(numbers)));
    }
}
