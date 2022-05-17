/**
<p>实现 <a href="https://baike.baidu.com/item/strstr/811469" target="_blank">strStr()</a> 函数。</p>

<p>给你两个字符串 <code>haystack</code> 和 <code>needle</code> ，请你在 <code>haystack</code> 字符串中找出 <code>needle</code> 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  <code>-1</code><strong> </strong>。</p>

<p> </p>

<p><strong>说明：</strong></p>

<p>当 <code>needle</code> 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。</p>

<p>对于本题而言，当 <code>needle</code> 是空字符串时我们应当返回 0 。这与 C 语言的 <a href="https://baike.baidu.com/item/strstr/811469" target="_blank">strstr()</a> 以及 Java 的 <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#indexOf(java.lang.String)" target="_blank">indexOf()</a> 定义相符。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>haystack = "hello", needle = "ll"
<strong>输出：</strong>2
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>haystack = "aaaaa", needle = "bba"
<strong>输出：</strong>-1
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>haystack = "", needle = ""
<strong>输出：</strong>0
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= haystack.length, needle.length <= 5 * 10<sup>4</sup></code></li>
	<li><code>haystack</code> 和 <code>needle</code> 仅由小写英文字符组成</li>
</ul>
<div><div>Related Topics</div><div><li>双指针</li><li>字符串</li><li>字符串匹配</li></div></div><br><div><li>👍 1215</li><li>👎 0</li></div>
*/

package com.zmoyi.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q28ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new Q28ImplementStrstr().new Solution();
        // String haystack = "hello";
        // String needle = "ll";
        // System.out.println(solution.strStr(haystack, needle));
        // String haystack1 = "aaaaa";
        // String needle1 = "bba";
        // System.out.println(solution.strStr(haystack1, needle1));
        String haystack2 = "checithisout";
        String needle2 = "this";
        System.out.println(solution.strStr(haystack2, needle2));
        System.out.println(solution.strStr2(haystack2, needle2));
        System.out.println(solution.strStr3(haystack2, needle2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 个人思路：
         * 双指针start和end，start定位haystack，end定位needle，当haystack的某个元素等于needle头元素的时候，
         * 暂存start，然后将指针同步往前推移，直到needle的结尾。
         * @param haystack
         * @param needle
         * @return
         */
        public int strStr(String haystack, String needle) {
            if ("".equals(needle)) {
                return 0;
            }
            if (haystack.length() < needle.length()) {
                return -1;
            }
            for (int start = 0; start < haystack.length(); start++) {
                int index = start;
                for (int end = 0; end < needle.length(); end++) {
                    if (haystack.charAt(index) == needle.charAt(end)) {
                        if (end == needle.length() - 1) {
                            return start;
                        }
                        index++;
                        if (index == haystack.length()) {
                            return -1;
                        }
                    } else {
                        break;
                    }
                }
            }
            return -1;
        }

        public int strStr2(String haystack, String needle) {
            int n = haystack.length();
            int m = needle.length();

            char[] hl = haystack.toCharArray();
            char[] nl = needle.toCharArray();

            // 枚举原串的「发起点」，最多循环两个字符串长度差的次数
            for (int i = 0; i <= n - m; i++) {
                // 从原串的「发起点」和匹配串的「首位」开始，尝试匹配
                int a = i, b = 0;
                // 如果匹配串没到头就继续匹配
                while (b < m && hl[a] == nl[b]) {
                    a++;
                    b++;
                }
                // 如果匹配串匹配到头就说明完全匹配了，返回原串的发起点的下标即可
                if (b == m) {
                    return i;
                }
            }
            return -1;
        }

        /**
         * Sunday Algorithm
         * @return
         */
        public int strStr3(String haystack, String needle) {

            int hl = haystack.length();
            int nl = needle.length();

            if (nl == 0) {
                return 0;
            }

            if (hl < nl) {
                return -1;
            }

            // 构建偏移量
            Map<Character, Integer> offset = new HashMap<>();
            for (int i = 0; i < nl; i++) {
                offset.put(needle.charAt(i), nl - i);
            }

            int idx = 0;
            while (idx <= hl - nl) {
                if (haystack.substring(idx, idx + nl).equals(needle)) {
                    return idx;
                } else {
                    // 不匹配情况下，根据下一个字符的偏移，移动idx
                    idx += offset.getOrDefault(haystack.charAt(idx + nl), nl + 1);
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}