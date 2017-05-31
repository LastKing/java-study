package com.api.socket.tcp_1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pc on 2017/5/31.
 */
public class Server_2 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);

            Socket socket = null;

            int count = 0;
            while (true) {
                socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                count++;
                System.out.println("客户端连接的数量：" + count);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
