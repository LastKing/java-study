package com.api.child_processes;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 自进程学习
 * Created by pc on 2017/5/27.
 */
public class test1 {

    public static void main(String[] args) {

        String videoPath = "";

        String imagePath = "";

        try {
//            Runtime.getRuntime()
//                    .exec("cmd /c strat d://freat.bat "
//                            + videoPath + " " + imagePath);

            Process p = Runtime.getRuntime()
                    .exec("cmd dir d://"
                            + videoPath + " " + imagePath);

            //取得命令结果的输出流
            InputStream fis = p.getInputStream();
            //用一个读输出流类去读
            InputStreamReader isr = new InputStreamReader(fis, "GBK");
            //用缓冲器读行
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            //直到读完为止
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
