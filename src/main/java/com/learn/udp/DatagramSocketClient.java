package com.learn.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramSocketClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        DatagramSocket datagramSocket = new DatagramSocket();
        int i=0;
        while (i<100) {
            System.out.println("count : "+i);
            byte[] buffer = ("0123456789" + " " + System.currentTimeMillis()+" "+i++).getBytes();
            InetAddress receiverAddress = InetAddress.getLocalHost();


            DatagramPacket packet = new DatagramPacket(
                    buffer, buffer.length, receiverAddress, 80);
            datagramSocket.send(packet);
            Thread.sleep(5000);
        }
    }
}
