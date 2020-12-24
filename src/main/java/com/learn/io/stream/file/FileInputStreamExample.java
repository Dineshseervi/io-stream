package com.learn.io.stream.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamExample {

    public static void main(String[] args) {
        //ClassLoader.getSystemResourceAsStream("")
        File file=new File("/Users/dineshseervi/Desktop/Doc/workDoc/2020_nov/iostream/src/main/resources/abc.txt");
       try {
           FileInputStream fileInputStream=new FileInputStream(file);
            int i=-1;
          while ((i=fileInputStream.read())!=-1)
          {
              System.out.print((char) i);
          }
       }
       catch (IOException ex)
       {
           System.out.println("error: "+ex.getMessage());
       }


    }
}
