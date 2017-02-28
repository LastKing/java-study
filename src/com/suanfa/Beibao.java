package com.suanfa;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 背包算法
 * Created by toonew on 2017/2/28.
 */
public class Beibao {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<Double>();

        while (!StdIn.isEmpty()) {
            numbers.add(StdIn.readDouble());
        }
        int N = numbers.size();

        double sum = 0.0;

        for (double x : numbers) {
            sum += x;
        }
        double mean = sum / N;
        for (double x : numbers) {
            sum += (x - mean) * (x - mean);
        }
        double std = Math.sqrt(sum / (N - 1));

        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);

    }

}
