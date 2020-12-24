package com.learn.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        URL url = new URL("http://jenkov.com");

        URLConnection urlConnection = url.openConnection();
        InputStream input = urlConnection.getInputStream();

        int data = input.read();
        while(data != -1){
            System.out.print((char) data);
            data = input.read();
            //Thread.sleep(10);
        }
        input.close();
    }
}
