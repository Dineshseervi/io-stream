package com.learn.io.stream.file;

import java.io.*;

public class ReaderWriterExample {
    public static void main(String[] args) throws IOException {
        File file=new File("/Users/dineshseervi/Desktop/Doc/workDoc/2020_nov/iostream/src/main/resources/abc.txt");
        File fileSecond=new File("/Users/dineshseervi/Desktop/Doc/workDoc/2020_nov/iostream/src/main/resources/abcCopy.txt");

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {


            // bufferedReader = new BufferedReader(new FileReader(file));
            if(bufferedReader.markSupported())
            {
                System.out.println("mark");
                bufferedReader.mark(8192);
            }
            bufferedReader.lines().forEach(str-> System.out.println(str));
            System.out.println("----------");
            bufferedReader.reset();
            bufferedReader.lines().forEach(str-> System.out.println(str));
            System.out.println("----------");
            //bufferedReader.reset();
            bufferedReader.lines().forEach(str-> System.out.println(str));
        }
        finally {

        }


    }
}
