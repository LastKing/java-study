package com.api.socket.tcp_1;

import java.io.*;
import java.net.Socket;

/**
 * 客户端
 * 1.创建socket，建立连接
 * 2.连接后，发送信息
 * 3.获取服务器向响应的信息
 * 4.关闭响应
 * Created by pc on 2017/5/31.
 */
public class client {

    public static void main(String[] args) {

        try {
            //1.创建客户端socket，指定服务器ip和端口
            Socket socket = new Socket("localhost", 8080);
            //2.获取输出流，向服务器端发送信息
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("用户名：admin；密码：123");
            pw.flush();
            socket.shutdownOutput(); //结束 信息输出

            //3获取输入流，并读取服务器端的响应信息W
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("我是客户端，服务器说：" + info);
            }

            //4、关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
