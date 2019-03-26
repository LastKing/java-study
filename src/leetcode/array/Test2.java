package leetcode.array;

/**
 * 投资最佳算法2
 * 感觉 网上的这些实现都怪怪的。。。
 *
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
 *
 * @author toonew on 2018/6/21
 */
public class Test2 {

    public static int maxProfit(int[] prices) {
        int count = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                count += prices[i] - prices[i - 1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int i = maxProfit(arr);

        System.out.println(i);

    }
}
