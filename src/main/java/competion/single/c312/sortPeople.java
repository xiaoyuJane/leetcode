package competion.single.c312;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/**
 * 给你一个字符串数组 names ，和一个由 互不相同 的正整数组成的数组 heights 。两个数组的长度均为 n 。
 *
 * 对于每个下标 i，names[i] 和 heights[i] 表示第 i 个人的名字和身高。
 *
 * 请按身高 降序 顺序返回对应的名字数组 names 。
 示例 1：

 输入：names = ["Mary","John","Emma"], heights = [180,165,170]
 输出：["Mary","Emma","John"]
 解释：Mary 最高，接着是 Emma 和 John 。
 示例 2：

 输入：names = ["Alice","Bob","Bob"], heights = [155,185,150]
 输出：["Bob","Alice","Bob"]
 解释：第一个 Bob 最高，然后是 Alice 和第二个 Bob 。
  

 提示：

 n == names.length == heights.length
 1 <= n <= 103
 1 <= names[i].length <= 20
 1 <= heights[i] <= 10^5
 names[i] 由大小写英文字母组成
 heights 中的所有值互不相同

 */
public class sortPeople {
    public static void main(String[] args) {
        Solution solution = new sortPeople().new Solution();
        String[] names = {"Mary","John","Emma"};
        int[] heights={180,165,170};
        System.out.println(Arrays.toString(solution.sortPeople(names,heights)));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //大佬的方法，使用了Map.Entry这种数据结构，然后对该数据结构就可以使用Comparator.comparing进行降序排序
        //key为有序的index，value为height

        public String[] sortPeople(String[] names, int[] heights) {
            Map.Entry<String, Integer>[] entry = new Map.Entry[names.length];
            for (int i = 0; i < names.length; i++) {
                entry[i] = Map.entry(names[i], heights[i]);
            }
            Arrays.sort(entry, (o, p) -> p.getValue() - o.getValue());

            for (int i = 0; i < names.length; i++) {
                names[i] = entry[i].getKey();
            }
            return names;
        }

        public String[] sortPeople2(String[] names, int[] heights) {
            int n = names.length;
            Integer[] index = new Integer[n];
            Integer[] height = new Integer[n];
            for (int i = 0; i < n; i++) {
                index[i]=i;
                height[i]=heights[i];
            }

            Arrays.sort(index,((o1, o2) -> height[o2]-height[o1]));
            String[] res = new String[names.length];

            for (int i = 0; i < index.length; i++) {
                res[i] = names[index[i]];
            }
            return res;


        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
