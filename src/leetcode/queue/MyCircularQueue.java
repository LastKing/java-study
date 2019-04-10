package leetcode.queue;

/**
 * 循环队列
 * https://leetcode-cn.com/explore/learn/card/queue-stack/216/queue-first-in-first-out-data-structure/865/
 *
 * @author toonew on 2019-04-10
 */
public class MyCircularQueue {

    int[] dates;
    int maxLength;  // 最大长度
    int count;      // 当前队列长度
    int head;       // 头部index
    int tail;       // 尾部index

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.dates = new int[k];
        maxLength = k;
        count = 0;
        head = 0;
        tail = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        count++;
        dates[tail] = value;
        tail = (tail + 1) % maxLength;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        count--;
        dates[head] = 0;
        head = (head + 1) % maxLength;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty())
            return -1;
        return dates[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty())
            return -1;
        return dates[tail == 0 ? maxLength - 1 : tail - 1];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return count == maxLength;
    }

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        boolean param_1 = obj.enQueue(2);
        int r2 = obj.Rear();
        int r3 = obj.Front();

        System.out.println();
    }


}
