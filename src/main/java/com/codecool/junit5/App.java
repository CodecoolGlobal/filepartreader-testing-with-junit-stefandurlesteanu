package com.codecool.junit5;

public class App {
    public static void main(String[] args) {
        PartReader reader = new PartReader();
        reader.setup("/Users/durlesteanu/Desktop/cap.txt", 1, 100);
        System.out.println(reader.read());
    }
}
