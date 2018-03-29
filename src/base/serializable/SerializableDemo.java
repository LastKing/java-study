package base.serializable;

import java.io.*;
import java.util.Date;

/**
 * create by toonew on 2018/3/14
 */
public class SerializableDemo {

    public static void main(String[] args) throws Exception {
        //Initializes The Object
        User user = new User();
        user.setName("hollis");
        user.setGender("male");
        user.setAge(23);
        user.setBirthday(new Date());
        System.out.println(user);

        //Write Obj to File
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));

        oos.writeObject(user);
        oos.close();

        //Read Obj from File
        File file = new File("tempFile");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User newUser = (User) ois.readObject();
        System.out.println(newUser);
        ois.close();
    }

}
