package base.serializable.unknown;

import java.io.Serializable;

/**
 * 串行方法（序列化方法）
 * http://blog.csdn.net/hbcui1984/article/details/1549290
 * Created by toonew on 2017/3/10.
 */
public class Student implements Serializable {
    private int id; // 学号
    private String name; // 姓名
    private int age; // 年龄
    private String department; // 系别

    public Student(int id, String name, int age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
