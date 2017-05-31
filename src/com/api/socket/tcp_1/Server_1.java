package com.api.socket.tcp_1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pc on 2017/5/31.
 */
public class Server_1 {

    public static void main(String[] args) {

        try {
            //1.创建一个服务端socket，即serverSocket
            ServerSocket serverSocket = new ServerSocket(8080);
            //2.调用  accept() 开始监听，等待客户端连接
            Socket socket = serverSocket.accept();
            //3.获取输入流
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String info = null;
            //readLine 会  阻塞等待客户端输入
            while ((info = br.readLine()) != null) {
                System.out.println("我是服务器，客户端说：" + info);
            }
            socket.shutdownInput();

            //4.响应客户端
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.print("欢迎您！");
            pw.flush();

            //5、关闭资源
            pw.close();
            os.close();
            br.close();
            is.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
