package com.api.socket;

import java.net.InetAddress;

/**
 * Created by pc on 2017/5/31.
 */
public class InetAddress_1 {

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();

            System.out.println(address.getHostName());//获取计算机名
            System.out.println(address.getAddress()); //获取IP地址
            byte[] bytes = address.getAddress();//获取字节数组形式的IP地址,以点分隔的四部分

            System.out.println(bytes);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
