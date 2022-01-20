/**
<p>给你一个数组 <code>nums</code><em> </em>和一个值 <code>val</code>，你需要 <strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地</a></strong> 移除所有数值等于 <code>val</code><em> </em>的元素，并返回移除后数组的新长度。</p>

<p>不要使用额外的数组空间，你必须仅使用 <code>O(1)</code> 额外空间并 <strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地 </a>修改输入数组</strong>。</p>

<p>元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。</p>

<p> </p>

<p><strong>说明:</strong></p>

<p>为什么返回数值是整数，但输出的答案是数组呢?</p>

<p>请注意，输入数组是以<strong>「引用」</strong>方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。</p>

<p>你可以想象内部操作如下:</p>

<pre>
// <strong>nums</strong> 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
int len = removeElement(nums, val);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中<strong> 该长度范围内</strong> 的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
</pre>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,2,2,3], val = 3
<strong>输出：</strong>2, nums = [2,2]
<strong>解释：</strong>函数应该返回新的长度 <strong>2</strong>, 并且 nums<em> </em>中的前两个元素均为 <strong>2</strong>。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1,2,2,3,0,4,2], val = 2
<strong>输出：</strong>5, nums = [0,1,4,0,3]
<strong>解释：</strong>函数应该返回新的长度 <strong><code>5</code></strong>, 并且 nums 中的前五个元素为 <strong><code>0</code></strong>, <strong><code>1</code></strong>, <strong><code>3</code></strong>, <strong><code>0</code></strong>, <strong>4</strong>。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= nums.length <= 100</code></li>
	<li><code>0 <= nums[i] <= 50</code></li>
	<li><code>0 <= val <= 100</code></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>双指针</li></div></div><br><div><li>👍 1152</li><li>👎 0</li></div>
*/

package com.zmoyi.leetcode.editor.cn;

public class Q27RemoveElement {
    public static void main(String[] args) {
        Solution solution = new Q27RemoveElement().new Solution();
        int[] arr1 = {3, 2, 2, 3};
        int val1 = 3;
        System.out.println(solution.removeElement(arr1, val1));
        int[] arr2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        System.out.println(solution.removeElement(arr2, val2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 这题自己没思路。说一下官方思路：双指针
         * start 标记下一个需要被替换的值；end遍历数组。
         * 当end的值不等于val的时候，就把end的值赋值给start，赋值完start+1。
         * end遍历完的时候，start位于不等于val最后一个元素的的索引+1，刚好就是不等于val的长度
         * @param nums
         * @param val
         * @return
         */
        public int removeElement(int[] nums, int val) {
            if (nums.length == 0) {
                return 0;
            }
            int start = 0;
            for (int end = 0; end < nums.length; end++) {
                if (nums[end] != val) {
                    nums[start] = nums[end];
                    start++;
                }
            }
            return start;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}