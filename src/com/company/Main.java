package com.company;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static ArrayList<String> ReadingDirectory(Path parent) {
        ArrayList<String> list = new ArrayList<>();
        try {
            Files.walkFileTree(parent, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    int count = dir.getNameCount() - parent.getNameCount() + 1;
                    count += dir.getFileName().toString().length();

                    //выравнивание по правому краю
                    String text = String.format("%" + count + "s", dir.getFileName());
                    text = text.replaceAll("[\\s]", "-");
                    list.add(text);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println("Лаба №10");
        System.out.println("Задание 1");
        System.out.println("---------------------------");
        Integer[] arrayInt = new Integer[] {1,2,3,4,5};
        List listInt = new FromArrayToSomethingCollection().arrayToList(arrayInt);
        System.out.println(listInt);

        String[] arrayString = new String[]{"One", "Two", "Three", "Four", "Five"};
        List listString = new FromArrayToSomethingCollection().arrayToList(arrayString);
        System.out.println(listString);
        System.out.println("---------------------------");

        System.out.println("Задания 2 и 3");
        System.out.println("---------------------------");
        MyArray<Integer> array = new MyArray<>(10);
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }
        System.out.println("Возвращаем 5 элемент : " + array.get(5));
        System.out.println("---------------------------");

        System.out.println("Задание 4");
        System.out.println("---------------------------");
        Path path = Paths.get("/Users/andreyshemchuk/Documents/прога на java"); // на маке исправить надо
        ArrayList<String> listOfDirectories = ReadingDirectory(path);
        for (int i = 0; i < 5; i++) {
            System.out.println(listOfDirectories.get(i));
        }
        System.out.println("---------------------------");

        System.out.println("Лаба №11");
        System.out.println("---------------------------");
        String[] arrayOfKeys = {"Lada", "Mercedes-Benz", "Toyota", "UAZ", "Land Rover", "Lada"};
        String[] arrayOfValues = {"2109", "E - class", "Land Cruiser", "Patriot", "Range Rover", "Vesta"};

        HashSet<String> hashSet = new FromArrayToSomethingCollection().arrayToHashSet(arrayOfValues);
        System.out.println(hashSet);

        HashMap<String, String> hashMap = new FromArrayToSomethingCollection().arrayToHashMap(arrayOfKeys,arrayOfValues);
        System.out.println(hashMap);
        System.out.println("---------------------------");
    }
}