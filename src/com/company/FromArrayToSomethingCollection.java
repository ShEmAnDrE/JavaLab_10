package com.company;

import java.util.*;

public class FromArrayToSomethingCollection {

    public <T> List<T> arrayToList(T[] array) {
        if(array == null)
            throw new IllegalArgumentException("Null array!");
        List<T> list = new ArrayList<>();
        list.addAll(Arrays.asList((T[]) array)); // перемещаем все в список
        return list;
    }

    public <T> HashSet<T> arrayToHashSet(T[] array){
        if(array == null)
            throw new IllegalArgumentException("Null array!");
        HashSet<T> hashSet = new HashSet<>(array.length);
        hashSet.addAll(Arrays.asList(array));
        return hashSet;
    }

    public <K, V> HashMap<K, V> arrayToHashMap(K[] keyArray, V[] valueArray){
        if(keyArray == null || valueArray == null)
            throw new IllegalArgumentException("Null array!");
        if(valueArray.length < keyArray.length)
            throw new IllegalArgumentException("Value's array more less than key's array!");
        HashMap<K, V> hashMap = new HashMap<>();
        for (int i = 0; i < keyArray.length; i++){
            hashMap.put(keyArray[i], valueArray[i]);
        }
        return hashMap;
    }

    /*public void showList() {
        for (Object ls : list) {
            System.out.print(ls + " ");
        }
        System.out.println();
    }

    public void add(T element) {
        list.add(element);
    }*/
}
