/**
<p>给你一个整数 <code>x</code> ，如果 <code>x</code> 是一个回文整数，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p>回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，<code>121</code> 是回文，而 <code>123</code> 不是。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>x = 121
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>x = -121
<strong>输出：</strong>false
<strong>解释：</strong>从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>x = 10
<strong>输出：</strong>false
<strong>解释：</strong>从右向左读, 为 01 。因此它不是一个回文数。
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>x = -101
<strong>输出：</strong>false
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>-2<sup>31</sup> <= x <= 2<sup>31</sup> - 1</code></li>
</ul>

<p> </p>

<p><strong>进阶：</strong>你能不将整数转为字符串来解决这个问题吗？</p>
<div><div>Related Topics</div><div><li>数学</li></div></div><br><div><li>👍 1734</li><li>👎 0</li></div>
*/

package com.zmoyi.leetcode.editor.cn;

public class Q9PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new Q9PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(1221));
        System.out.println(solution.isPalindrome(10));
        System.out.println(solution.isPalindrome(-121));
        System.out.println(solution.isPalindrome(-10));
        System.out.println(solution.isPalindrome(-101));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路：
         * 1、如果是负数，肯定不是；
         * 2、如果是个位数，肯定是；
         * 3、数字转成字符串，使用双指针，从头和尾一起进行比对。
         * 只要有头指针和尾指针对应的元素不同，肯定不是。一起比对到两个指针相同或相差1。
         * @param x
         * @return
         */
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            if (x <= 9) {
                return true;
            }
            char[] chars = String.valueOf(x).toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int tempIdx = chars.length - 1 - i;
                if (chars[i] != chars[tempIdx]) {
                    return false;
                }
                if (i == tempIdx || i + 1 == tempIdx) {
                    return true;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}