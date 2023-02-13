package com.eduardocode.objectorienteddesign.designpatterns.structural.adapter.sorting;

import java.util.Collections;
import java.util.List;

public class NumberSorter {

    public void sortList(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
