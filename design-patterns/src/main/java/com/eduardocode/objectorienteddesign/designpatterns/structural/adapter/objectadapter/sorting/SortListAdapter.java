package com.eduardocode.objectorienteddesign.designpatterns.structural.adapter.objectadapter.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortListAdapter implements Sorter {
    private final NumberSorter numberSorter;

    public SortListAdapter() {
        numberSorter = new NumberSorter();
    }

    @Override
    public int[] sort(int[] numbers) {
        List<Integer> integers = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        numberSorter.sortList(integers);
        return integers.stream().mapToInt(i -> i).toArray();
    }
}
