package base.serializable.unknown;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Created by toonew on 2017/1/18.
 */
public class SerializeDemo {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;

        try {
            FileOutputStream fos = new FileOutputStream("./test.ser");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(e);
            out.close();
            fos.close();
            System.out.printf("Serialized data is saved in ./employee.ser");
        } catch (Exception i) {
            i.printStackTrace();
        }
    }

}
