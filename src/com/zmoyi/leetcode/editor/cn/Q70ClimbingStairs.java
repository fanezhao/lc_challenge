/**
 * <p>假设你正在爬楼梯。需要 <code>n</code>&nbsp;阶你才能到达楼顶。</p>
 *
 * <p>每次你可以爬 <code>1</code> 或 <code>2</code> 个台阶。你有多少种不同的方法可以爬到楼顶呢？</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 2
 * <strong>输出：</strong>2
 * <strong>解释：</strong>有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 3
 * <strong>输出：</strong>3
 * <strong>解释：</strong>有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= n &lt;= 45</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>记忆化搜索</li><li>数学</li><li>动态规划</li></div></div><br><div><li>👍 2430</li><li>👎 0</li></div>
 */

package com.zmoyi.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q70ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new Q70ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(4));
        System.out.println(solution.climbStairs2(4));
        System.out.println(solution.climbStairs2(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 动态规划
         * @param n
         * @return
         */
        public int climbStairs(int n) {
            Map<Integer, Integer> memo = new HashMap<>();
            memo.put(0, 1); // 当有0阶楼梯的时候，有一种方式，就是不用爬
            memo.put(1, 1); // 当有1阶楼梯的时候，也只有一种方式，就是每次爬1阶楼梯，就怕一次
            for (int i = 2; i <= n; i++) {
                memo.put(i, memo.get(i - 1) + memo.get(i - 2));
            }
            return memo.get(n);
        }

        /**
         * 记忆化搜索
         * @param n
         * @return
         */
        public int climbStairs2(int n) {
            Map<Integer, Integer> memo = new HashMap<>();
            if (n == 0 || n == 1) {
                return 1;
            }
            if (!memo.containsKey(n)) {
                memo.put(n, climbStairs2(n - 1) + climbStairs2(n - 2));
            }
            return memo.get(n);
        }

        /**
         * 纯递归
         * @param n
         * @return
         */
        public int climbStairs3(int n) {
            if (n == 0 || n == 1) {
                return 1;
            }
            return climbStairs3(n - 1) + climbStairs3(n - 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}