package leetcode.string;

/**
 * 字符串 反转
 *
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/32/
 *
 * @author toonew on 2018/6/21
 */
public class Test1 {

    public static String reverseString(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }

        char[] chars = s.toCharArray();

        char[] chars2 = new char[chars.length];

        for (int i = chars.length - 1, j = 0; i >= 0; i--, j++) {
            chars2[j] = chars[i];
        }

        return new String(chars2);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
    }


}
