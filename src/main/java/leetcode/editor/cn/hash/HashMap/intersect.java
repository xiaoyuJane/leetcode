package leetcode.editor.cn.hash.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两个数组的交集 II
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * 相关标签
 * 数组
 * 哈希表
 * 双指针
 * 二分查找
 * 排序
 */

public class intersect {
    public static void main(String[] args) {
        Solution solution = new intersect().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            //次数不一致的时候，取最小值，所以保证nums1 和nums2的顺序
            if (nums1.length > nums2.length) {
                return intersect(nums2, nums1);
            }


            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int num : nums1) { //nums1个数少
                //统计个数的经典思路
                int count = map.getOrDefault(num, 0) + 1;
                map.put(num, count);
            }

            int[] intersection = new int[nums1.length];
            int index = 0;

            for (int num : nums2) {
                int count = map.getOrDefault(num, 0);
                if (count > 0) {//有交集，进行处理存入结果数组
                    intersection[index++] = num;
                    count--;
                    if (count > 0) {
                        map.put(num, count);
                    } else {
                        map.remove(num);
                    }
                }
            }
            return Arrays.copyOfRange(intersection, 0, index);



        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
