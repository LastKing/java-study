package com.api.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by pc on 2017/5/31.
 */
public class Url_2 {
    public static void main(String[] args) {

        try {
            URL url = new URL("http://www.baidu.com");
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String data = br.readLine();
            while (data != null) {
                System.out.println(data);
                data = br.readLine();
            }

            br.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
