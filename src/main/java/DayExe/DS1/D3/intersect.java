package DayExe.DS1.D3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * nums1 = [1,2,2,1], nums2 = [2,2]
 */
public class intersect {
    public static void main(String[] args) {
        Solution solution = new intersect().new Solution();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(solution.intersect(nums1,nums2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> map = new HashMap<>();
            ArrayList<Integer> list = new ArrayList<>();

            for (int num : nums1) {
                if (map.containsKey(num)) map.put(num,map.get(num)+1);
                else map.put(num,1);
            }
            for (int num : nums2) {
                if (map.containsKey(num) && map.get(num)>0){
                    list.add(num);
                    map.put(num,map.get(num)-1);
                }
            }

            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i]=list.get(i);
            }
            return res;


        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
