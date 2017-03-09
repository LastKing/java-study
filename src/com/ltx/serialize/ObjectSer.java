package com.ltx.serialize;

import java.io.*;

/**
 * Created by toonew on 2017/3/10.
 */
public class ObjectSer {

    public static void main(String[] args) {
        Student st = new Student(981036, "chb", 23, "CSD");

        try {
            FileOutputStream fos = new FileOutputStream("./data.txt");

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(st);
            oos.close();

            st = null;

            FileInputStream fis = new FileInputStream("./data.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            st = (Student) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Student Info:");
        System.out.println("ID:" + st.getId());
        System.out.println("Name:" + st.getName());
        System.out.println("Age:" + st.getAge());
        System.out.println("Dep:" + st.getDepartment());
    }

}
