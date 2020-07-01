package com.codecool.junit5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartReader {

    String filePath;
    int fromLine;
    int toLine;

    public PartReader() {
        this.filePath = "/path";
        this.fromLine = -1;
        this.toLine = -1;
    }

    public void setup(String filePath, int fromLine, int toLine) {

        if (fromLine < 1) {
            throw new IllegalArgumentException("Start line should be greater than 0");
        }

        if (fromLine > toLine) {
            throw new IllegalArgumentException("Start line should be smaller than end line");
        }

        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;


    }

    public String read() {
        String fileContent = "";
        File file = new File(filePath);
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                fileContent = fileContent.concat(scan.nextLine() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return fileContent;
    }

    public String readLines() {
        String text = read();
        String[] rows = text.split("\n");
        StringBuilder newText = new StringBuilder();
        for(int i = fromLine -1; i < rows.length; i++){
            if(i > toLine -1) break;
            if (i != fromLine - 1) newText.append("\n");
            newText.append(rows[i]);
        }
        return newText.toString();

    }

}
