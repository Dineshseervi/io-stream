package com.learn.io.stream.file;

import java.io.*;

public class BufferedInputStreamExample {
    public static void main(String[] args) {
        BufferedInputStreamExample dataInputStreamExample=new BufferedInputStreamExample();
        File file=new File("/Users/dineshseervi/Desktop/Doc/workDoc/2020_nov/iostream/src/main/resources/abc.txt");
        File fileSecond=new File("/Users/dineshseervi/Desktop/Doc/workDoc/2020_nov/iostream/src/main/resources/abcCopy.txt");
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            try (FileOutputStream fileOutputStream = new FileOutputStream(fileSecond)) {
                try (BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {


                    if (bufferedInputStream.markSupported()) {
                        bufferedInputStream.mark(8192);
                    }
                    dataInputStreamExample.copy(bufferedInputStream, fileOutputStream);
                    System.out.println("---------");
                    bufferedInputStream.reset();
                    dataInputStreamExample.copy(bufferedInputStream, fileOutputStream);
                    //fileInputStream.markSupported()
            /*int i=-1;
            while ((i=fileInputStream.read())!=-1)
            {
                System.out.print((char) i);
            }*/
                }
            }
        } catch (IOException ex) {
            System.out.println("error: " + ex.getMessage());
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
