/**
<p>编写一个函数来查找字符串数组中的最长公共前缀。</p>

<p>如果不存在公共前缀，返回空字符串&nbsp;<code>""</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>strs = ["flower","flow","flight"]
<strong>输出：</strong>"fl"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>strs = ["dog","racecar","car"]
<strong>输出：</strong>""
<strong>解释：</strong>输入不存在公共前缀。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= strs.length &lt;= 200</code></li>
	<li><code>0 &lt;= strs[i].length &lt;= 200</code></li>
	<li><code>strs[i]</code> 仅由小写英文字母组成</li>
</ul>
<div><div>Related Topics</div><div><li>字符串</li></div></div><br><div><li>👍 1955</li><li>👎 0</li></div>
*/

package com.zmoyi.leetcode.editor.cn;

public class Q14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Q14LongestCommonPrefix().new Solution();
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix(strs));
        String[] strs1 = new String[]{"dog","racecar","car"};
        System.out.println(solution.longestCommonPrefix(strs1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }

            // 先找出最短的字符串
            String shortest = strs[0];
            for (String str : strs) {
                if (str.length() < shortest.length()) {
                    shortest = str;
                }
            }

            // 拿最短的字符串进行逐个匹配
            while (shortest.length() > 0) {
                boolean isCommon = true;
                for (String str : strs) {
                    if (!str.startsWith(shortest)) {
                        isCommon = false;
                        break;
                    }
                }
                if (isCommon) {
                    return shortest;
                }
                shortest = shortest.substring(0, shortest.length() - 1);
            }

            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}