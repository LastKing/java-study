package leecode.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/explore/learn/card/queue-stack/216/queue-first-in-first-out-data-structure/863/
 *
 * @author toonew on 2019-02-21
 */
public class MyQueue {

    private List<Integer> data;
    private int p_start;


    public MyQueue(List<Integer> data) {
        this.data = new ArrayList<>();
        p_start = 0;
    }

    public boolean enQueue(int x) {
        data.add(x);
        return true;
    }

    public boolean deQueue() {
        if (this.isEmpty()) {
            return false;
        }
        p_start++;
        return true;
    }

    public int Front() {
        return data.get(p_start);
    }

    private boolean isEmpty() {
        return p_start > data.size();
    }


    public static void main(String[] args) {

    }

}
