package com.api.socket.udp;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by pc on 2017/5/31.
 */
public class UDP_SERVER {

    public static void main(String[] args) {

        try {
            DatagramSocket socket = new DatagramSocket(8080);

            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);

            socket.receive(packet);

            String info = new String(data, 0, data.length);
            System.out.println("我的服务器，客户端告诉我" + info);

            //向客户端响应数据
            InetAddress address = packet.getAddress();
            int port = packet.getPort();

            byte[] data2 = "欢迎您！".getBytes();

            DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
            socket.send(packet2);
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
