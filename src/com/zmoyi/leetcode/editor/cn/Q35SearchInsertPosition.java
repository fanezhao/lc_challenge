/**
 * <p>给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。</p>
 *
 * <p>请必须使用时间复杂度为 <code>O(log n)</code> 的算法。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> nums = [1,3,5,6], target = 5
 * <strong>输出:</strong> 2
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> nums = [1,3,5,6], target = 2
 * <strong>输出:</strong> 1
 * </pre>
 *
 * <p><strong>示例 3:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> nums = [1,3,5,6], target = 7
 * <strong>输出:</strong> 4
 * </pre>
 *
 * <p><strong>示例 4:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> nums = [1,3,5,6], target = 0
 * <strong>输出:</strong> 0
 * </pre>
 *
 * <p><strong>示例 5:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> nums = [1], target = 0
 * <strong>输出:</strong> 0
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ul>
 * <li><code>1 <= nums.length <= 10<sup>4</sup></code></li>
 * <li><code>-10<sup>4</sup> <= nums[i] <= 10<sup>4</sup></code></li>
 * <li><code>nums</code> 为<strong>无重复元素</strong>的<strong>升序</strong>排列数组</li>
 * <li><code>-10<sup>4</sup> <= target <= 10<sup>4</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 1308</li><li>👎 0</li></div>
 */

package com.zmoyi.leetcode.editor.cn;

public class Q35SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new Q35SearchInsertPosition().new Solution();
        int[] nums1 = {1, 3, 5, 6};
        System.out.println(solution.searchInsert(nums1, 5));
        System.out.println(solution.searchInsert(nums1, 2));
        System.out.println(solution.searchInsert(nums1, 7));
        System.out.println(solution.searchInsert(nums1, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 个人思路：
         * 首先，由于数组有序，当target大于数据最大值时，插入的位置肯定就数组的最后一位的后面，也就是nums.length - 1
         * 然后采用二分法。当nums[middle] < target时，start = middle + 1；反之，end = middle。
         * @param nums
         * @param target
         * @return
         */
        public int searchInsert(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while (start < end) {
                int middle = start + end - 1;
                if (nums[middle] < target) {
                    start = middle + 1;
                } else {
                    end = middle;
                }
            }
            return nums[start] < target ? start + 1 : start;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}