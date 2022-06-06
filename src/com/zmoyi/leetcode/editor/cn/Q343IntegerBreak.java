/**
 * <p>给定一个正整数&nbsp;<code>n</code>&nbsp;，将其拆分为 <code>k</code> 个 <strong>正整数</strong> 的和（&nbsp;<code>k &gt;= 2</code>&nbsp;），并使这些整数的乘积最大化。</p>
 *
 * <p>返回 <em>你可以获得的最大乘积</em>&nbsp;。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入: </strong>n = 2
 * <strong>输出: </strong>1
 * <strong>解释: </strong>2 = 1 + 1, 1 × 1 = 1。</pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre>
 * <strong>输入: </strong>n = 10
 * <strong>输出: </strong>36
 * <strong>解释: </strong>10 = 3 + 3 + 4, 3 ×&nbsp;3 ×&nbsp;4 = 36。</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ul>
 * <li><code>2 &lt;= n &lt;= 58</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数学</li><li>动态规划</li></div></div><br><div><li>👍 827</li><li>👎 0</li></div>
 */

package com.zmoyi.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q343IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new Q343IntegerBreak().new Solution();
        System.out.println(solution.integerBreak(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int integerBreak(int n) {
            return breakInteger3(n);
        }

        /**
         * 递归：将n进行分割，至少分割成两部分，可以获得的最大乘积
         * @param n
         * @return
         */
        private int breakInteger(int n) {
            if (n == 1) {
                return 1;
            }
            int res = -1;
            for (int i = 1; i <= n; i++) {
                // i + (n - i)
                // 当n只被分割成i 和 n - i两部分的时候，其乘积有可能比按步分割的乘积更大，所以要比较
                // i * (n - i)和 i * breakInteger(n - i)的大小，比较完了之后再当当前的最大值比较
                res = max3(res, i * (n - i), i * breakInteger(n - i));
            }
            return res;
        }

        /**
         * 记忆化搜索
         * @param n
         * @return
         */
        private int breakInteger2(int n) {
            if (n == 1) {
                return 1;
            }
            int[] memo = new int[n + 1];
            if (memo[n] != 0) {
                return memo[n];
            }
            int res = -1;
            for (int i = 1; i <= n; i++) {
                // i + (n - i)
                res = max3(res, i * (n - i), i * breakInteger2(n - i));
            }
            memo[n] = res;
            return res;
        }

        /**
         * 动态规划
         * @param n
         * @return
         */
        private int breakInteger3(int n) {
            // memo[i] 表示将i分割（至少分割成两部分）后得到的最大乘积
            int[] memo = new int[n + 1];
            memo[1] = 1;
            for (int i = 2; i <= n; i++) {
                // 求解memo[i]
                for (int j = 1; j <= i - 1; j++) {
                    // j + (i - j)
                    memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
                }
            }
            return memo[n];
        }

        private int max3(int a, int b, int c) {
            return Math.max(a, Math.max(b, c));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}