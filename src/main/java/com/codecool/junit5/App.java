package com.codecool.junit5;

public class App {
    public static void main(String[] args) {
        PartReader reader = new PartReader();
        reader.setup("/Users/durlesteanu/Desktop/cap.txt", 1,1 );
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        System.out.println(reader.readLines());



    }
}
