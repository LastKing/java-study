package base.serializable.unknown;

import java.io.Serializable;

/**
 * Created by toonew on 2017/1/18.
 */
public class Employee implements Serializable {

    public String name;
    public String address;
    public transient int SSN;
    public int number;

    public void mailCheck() {
        System.out.println("Mailing a check to " + name
                + " " + address);
    }

}
