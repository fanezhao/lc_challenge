/**
 * <p>给定一个数组 <code>nums</code>，编写一个函数将所有 <code>0</code> 移动到数组的末尾，同时保持非零元素的相对顺序。</p>
 *
 * <p><strong>请注意</strong>&nbsp;，必须在不复制数组的情况下原地对数组进行操作。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> nums = <code>[0,1,0,3,12]</code>
 * <strong>输出:</strong> <code>[1,3,12,0,0]</code>
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> nums = <code>[0]</code>
 * <strong>输出:</strong> <code>[0]</code></pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示</strong>:</p>
 * <meta charset="UTF-8" />
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>-2<sup>31</sup>&nbsp;&lt;= nums[i] &lt;= 2<sup>31</sup>&nbsp;- 1</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><b>进阶：</b>你能尽量减少完成的操作次数吗？</p>
 * <div><div>Related Topics</div><div><li>数组</li><li>双指针</li></div></div><br><div><li>👍 1607</li><li>👎 0</li></div>
 */

package com.zmoyi.leetcode.editor.cn;

import java.util.ArrayList;

public class Q283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new Q283MoveZeroes().new Solution();

        int[] nums = {0, 1, 0, 3, 12};

        // solution.moveZeroes(nums);
        solution.moveZeroes4(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 暴力解法
         * 时间复杂度：O(n)
         * 空间复杂度：O(n)
         * @param nums
         */
        public void moveZeroes(int[] nums) {
            ArrayList<Integer> nonZeroArr = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nonZeroArr.add(nums[i]);
                }
            }

            for (int i = 0; i < nonZeroArr.size(); i++) {
                nums[i] = nonZeroArr.get(i);
            }

            for (int i = nonZeroArr.size(); i < nums.length; i++) {
                nums[i] = 0;
            }
        }

        /**
         * 原地操作，不消耗额外空间
         * 时间复杂度：O(n)
         * 空间复杂度：O(1)
         * @param nums
         */
        public void moveZeroes2(int[] nums) {
            int k = 0;  // nums中， [0...k)的元素均为非0元素

            // 遍历到第i个元素后，保证[0...i]中所有非0元素都按照顺序排列在[0....k)中
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[k++] = nums[i];
                }
            }

            // 将nums中剩余元素均置为0
            for (int i = k; i < nums.length; i++) {
                nums[i] = 0;
            }
        }

        /**
         *
         * @param nums
         */
        public void moveZeroes3(int[] nums) {
            int k = 0;  // nums中， [0...k)的元素均为非0元素

            // 遍历到第i个元素后，保证[0...i]中所有非0元素都按照顺序排列在[0....k)中，同时交换nums[i]和nums[k]的位置
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int temp = nums[k];
                    nums[k++] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        /**
         *
         * @param nums
         */
        public void moveZeroes4(int[] nums) {
            int k = 0;  // nums中， [0...k)的元素均为非0元素

            // 遍历到第i个元素后，保证[0...i]中所有非0元素都按照顺序排列在[0....k)中，同时交换nums[i]和nums[k]的位置
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    if (k != i) {   // 当一个不含0数组每次都要进行交换，所以在k不等于i的时候才进行交换
                        int temp = nums[k];
                        nums[k++] = nums[i];
                        nums[i] = temp;
                    } else {
                        k++;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}