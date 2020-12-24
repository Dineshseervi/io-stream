package com.learn.io.stream.file;

import java.io.File;
import java.io.IOException;

public class FileOperationExample {
    public static void main(String[] args) throws IOException {

        File file=new File("/Users/dineshseervi/Desktop/Doc/workDoc/2020_nov/iostream/src/main/resources/Test.txt");
        boolean fileExists = file.exists();
        System.out.println("fileExists: "+fileExists);
        if(!fileExists)
        {
            file.createNewFile();
            System.out.println("file created");
        }
        else{
            System.out.println("file all read present");
        }

        boolean statusRenameTo = file.renameTo(new File("/Users/dineshseervi/Desktop/Doc/workDoc/2020_nov/iostream/src/main/resources/Test2.txt"));
        System.out.println("statusRenameTo : " +statusRenameTo);
        //boolean statusFileDelete =file.delete();
    }
}
