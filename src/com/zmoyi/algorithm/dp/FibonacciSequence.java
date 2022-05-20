package com.zmoyi.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author niou.zhao@tuya.com
 * @description 斐波那契数列讲动态规划
 * @date 2022-05-20 22:44
 */
public class FibonacciSequence {

    /**
     * 纯递归
     *
     * @param n
     * @return
     */
    static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    private static Map<Integer, Integer> memo = new HashMap<>();

    /**
     * 记忆化搜索：递归树中重复计算的地方只计算一次，自上而下的解决问题
     *
     * @param n
     * @return
     */
    static int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (!memo.containsKey(n)) {
            memo.put(n, fib2(n - 1) + fib2(n - 2));
        }
        return memo.get(n);
    }

    /**
     * 动态规划：自下而上的解决问题（先解决小数据量，然后层层递推，解决大数据量）
     * @param n
     * @return
     */
    static int fib3(int n) {
        memo = new HashMap<>();
        memo.put(0, 0);
        memo.put(1, 1);
        for (int i = 2; i <= n; i++) {
            memo.put(i, memo.get(i - 1) + memo.get(i - 2));
        }
        return memo.get(n);
    }

    public static void main(String[] args) {

        int n = 46;

        long start1 = System.currentTimeMillis();
        System.out.println(fib(n));
        System.out.println("fib: " + (System.currentTimeMillis() - start1));

        long start2 = System.currentTimeMillis();
        System.out.println(fib2(n));
        System.out.println("fib2: " + (System.currentTimeMillis() - start2));

        long start3 = System.currentTimeMillis();
        System.out.println(fib3(n));
        System.out.println("fib3: " + (System.currentTimeMillis() - start3));
    }
}
