package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class MyArray<T>{
    private T[] array;
    private int count;
    private int size;

    public MyArray(){
        this(8);
    }

    public MyArray(int size) {
        this.size = size;
        array = (T[]) new Object[size];
        count = 0;
    }

    public MyArray(MyArray<T> otherArray){
        this.count = otherArray.count;
        this.size = otherArray.size;
        this.array = (T[]) new Object[size];
        System.arraycopy(otherArray.array, 0, array, 0, count);
    }

    public void add(T object){
        if(size - count == 1) resize(size*2);
        array[count++] = object;
    }
    public void add(T object, int index){
        if(size - count == 1) resize(size*2);
        System.arraycopy(array, index, array, index+1, count-index);
        array[index] = object;
    }
    public boolean addAll(int index, MyArray<T> otherArray){
        if(otherArray.count == 0) {
            return false;
        }

        int newSize = size;
        while (newSize - count <= otherArray.count) {
            newSize *= 2;
        }
        resize(newSize);
        System.arraycopy(array, index, array, index+otherArray.count, count - index);
        System.arraycopy(otherArray.array, 0, array, index, otherArray.count);
        count += otherArray.count;

        return true;
    }

    public int indexOf(T object) {
        for(int i = 0; i < count; i++) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T object){
        for(int i = count-1; i >=0; i--) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }


    public void sort(Comparator<? super T> comp){
        Arrays.sort(array, comp);
    }

    public void set(int index, T object){
        array[index] = object;
    }

    public T remove(int index){
        if(index > count)
            throw new IndexOutOfBoundsException();
        T object = array[index];
        System.arraycopy(array, index+1, array, index, count-index-1);
        array[--count] = null;

        if(count < size/2) resize(size/2);
        return object;
    }

    private void resize(int newSize){
        if(newSize > size)
            array = Arrays.copyOf(array, newSize);
        else{
            T[] temp = (T[])new Object[newSize];
            System.arraycopy(array, 0, temp, 0, newSize);
            array = temp;
        }
        size = newSize;

    }

    public T get(int index){
        if(index > count) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public int getCount() {
        return count;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Массив: {" + Arrays.toString(array) + " }, количество элементов = " + count + ", размерность = " + size;
    }
}
