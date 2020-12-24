package com.learn.io.stream.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ExampleRandomAccessFile {
    public static void main(String[] args) {
        File file=new File("/Users/dineshseervi/Desktop/Doc/workDoc/2020_nov/iostream/src/main/resources/abcCopy.txt");
        try {
            RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
            byte[] bytes = "Hello Worldfdfdfddfdfdfdfdffdffdfffdf".getBytes("UTF-8");

            randomAccessFile.write(bytes, 2, 5);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
