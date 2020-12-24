package com.learn.io.stream.file;

import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.*;

public class DataInputStreamExample {
    public static void main(String[] args) {
        DataInputStreamExample dataInputStreamExample=new DataInputStreamExample();
        File file=new File("/Users/dineshseervi/Desktop/Doc/workDoc/2020_nov/iostream/src/main/resources/abc.txt");
        File fileSecond=new File("/Users/dineshseervi/Desktop/Doc/workDoc/2020_nov/iostream/src/main/resources/abcCopy.txt");
        try {

            FileInputStream fileInputStream=new FileInputStream(file);
            FileOutputStream fileOutputStream=new FileOutputStream(fileSecond);
            dataInputStreamExample.copy(fileInputStream,fileOutputStream);
            //fileInputStream.markSupported()
            /*int i=-1;
            while ((i=fileInputStream.read())!=-1)
            {
                System.out.print((char) i);
            }*/
        }
        catch (IOException ex)
        {
            System.out.println("error: "+ex.getMessage());
        }

    }

    void copy(InputStream source, OutputStream target) throws IOException {
        //byte[] buf = new byte[8192];
        byte[] buf = new byte[8192];
        int length;
        while ((length = source.read(buf)) > 0) {
            System.out.println("read--");
            System.out.println("length--"+length);
            target.write(buf, 0, length);
        }
    }
}
