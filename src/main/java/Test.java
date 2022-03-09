import java.util.*;

public class Test {
    public static void main(String[] args) {
       // [[],[0,2],[]] true
        //[[],[0,2],[1]] false
        //[[],[0,2,3,4],[3],[1,2],[],[1,4]]
        int[][] nums = new int[][]{{},{0,2,3,4},{3},{1,2},{},{1,4}};
        Solution solution = new Test().new Solution();
        System.out.println(solution.getAllValue(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean getAllValue(int[][] nums){
            Map<Integer,List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i].length == 0){
                    map.put(i,new ArrayList<>());
                }else{
                    List<Integer> values = new ArrayList<>();
                    for (int index: nums[i]){
                        //1.map中没有index对应表达式的值，继续把index放上去
                        if (!map.containsKey(index)) values.add(index);
                        //2.map中有index值，不为空，那就把index对应的value全部添加进去
                        else if (!map.get(index).isEmpty()) values.addAll(map.get(index));
                        //3.判断是否成环
                        if (values.contains(i)) return false;
                    }
                    map.put(i,values);
                }
            }
            return true;
        }

        }




    //leetcode submit region begin(Prohibit modification and deletion)
}
