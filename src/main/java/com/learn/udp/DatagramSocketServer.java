package com.learn.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class DatagramSocketServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(80);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        while (true) {
            datagramSocket.receive(packet);
            byte[] bytes = packet.getData();
            String s = new String(bytes,0,packet.getLength());
            System.out.println(s);
        }
    }
}
