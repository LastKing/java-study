package com.api.socket.tcp_1;

import java.net.Socket;

/**
 * Created by pc on 2017/5/31.
 */
public class ServerThread extends Thread {

    Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }
}
