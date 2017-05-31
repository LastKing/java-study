package com.api.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by pc on 2017/5/31.
 */
public class UDP_Client {


    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("localhost");
            int port = 8080;
            byte[] data = "用户名：admin;密码：123".getBytes();

            //2、创建数据报，包含发送的数据信息
            DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
            DatagramSocket socket = new DatagramSocket();

            socket.send(packet);

            //1、创建数据报，用于接受服务器端响应数据
            byte[] data2 = new byte[1024];
//            DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
//            //2、接受服务器响应的数据
//            socket.receive(packet2);
//            String raply = new String(data2, 0, packet2.getLenth());
//            System.out.println("我是客户端，服务器说：" + reply);
//            //4、关闭资源
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
