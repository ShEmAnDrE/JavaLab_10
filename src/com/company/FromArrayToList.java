package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FromArrayToList<T> {
    private List<T> list = new ArrayList<>();

    public FromArrayToList(T[] array) {
        list.addAll(Arrays.asList((T[]) array));
    }

    public void showList() {
        for (Object ls : list) {
            System.out.print(ls + " ");
        }
        System.out.println();
    }

    public void add(T element) {
        list.add(element);
    }
}
