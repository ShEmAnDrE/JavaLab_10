package com.company;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
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
        System.out.println("Задание 1");
        System.out.println("---------------------------");
        Integer[] arrayInt = new Integer[] {1,2,3,4,5};
        FromArrayToList<Integer> listInt = new FromArrayToList<>(arrayInt);
        listInt.showList();

        String[] arrayString = new String[]{"One", "Two", "Three", "Four", "Five"};
        FromArrayToList<String> listString = new FromArrayToList<>(arrayString);
        listString.showList();
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
    }
}