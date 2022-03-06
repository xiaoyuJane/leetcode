package leetcode.editor.cn.hash.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * 进阶：
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。

 */
public class majorityElement {
    public static void main(String[] args) {
        Solution solution = new majorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //使用HashMap来存储每个元素以及出现的次数。
        //循环遍历数组，并将数组中的每个元素加入hashMap，遍历hashMap，返回值最大的键
        public int majorityElement(int[] nums){
            Map<Integer,Integer> counts = new HashMap<>();
            for (int num : nums){
                if (!counts.containsKey(num)) counts.put(num,1);
                else counts.put(num,counts.get(num)+1); //修改value值
            }

            Map.Entry<Integer,Integer> majorityEntry = null;
            for (Map.Entry<Integer,Integer> entry: counts.entrySet()){
                if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) majorityEntry=entry;
            }

            return majorityEntry.getKey();

        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
