package com.base.io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 基本File方法
 * http://blog.csdn.net/lym152898/article/details/56013835
 * Created by Rain on 2017/3/2.
 */
public class FileTest {

    public static void main(String[] args) throws IOException {

//        File file = new File(FileTest.class.getResource("").getFile()+"FileTest.class");

        File file = new File("d:\\test\\test.txt");

        if (file.exists()) {
            getInfo(file);
        } else if (file.getParentFile().exists()) {
            // 如果不存在，先判断文件的父路径是否存在，不存在先创建目录在创建文件，否则直接创建文件
            // 创建文件
            file.createNewFile();
            // 获取文件信息
            getInfo(file);
        } else {
            // 创建目录
            file.getParentFile().mkdirs();
            // 创建文件
            file.createNewFile();
            // 获取文件信息
            getInfo(file);
        }
        File f = new File("d:\\test\\test2.txt");
        file.renameTo(f);
        File newFile = new File("d:\\test\\test2.txt");
        getInfo(newFile);
        newFile.delete();

    }

    public static void getInfo(File file) {
        // 判断指定路径是否是目录
        System.out.println(file.getName() + (file.isDirectory() ? "是一个目录" : "不是一个目录"));
        // 判断是否是文件
        System.out.println(file.getName() + (file.isFile() ? "是一个文件" : "不是一个文件"));
        // 判断是否为隐藏文件
        System.out.println(file.getName() + (file.isHidden() ? "是隐藏文件" : "不是隐藏文件"));
        // 获取文件的最后修改时间
        long temp = file.lastModified();
        // 将long型数据转换称Date型数据
        Date date = new Date(temp);
        // 将Date型数据转换称时间字符串
        String str = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(date);
        System.out.println(str);
        // 输出文件大小
        System.out.println(file.getName() + ":" + file.length() + "B");
    }

}
