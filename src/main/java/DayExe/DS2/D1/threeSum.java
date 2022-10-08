package DayExe.DS2.D1;

import java.util.*;

public class threeSum {
    public static void main(String[] args) {
        Solution solution = new threeSum().new Solution();
//        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {0,0,0,0};
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>>res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        HashSet<Integer> temp= new HashSet<>();

        public List<List<Integer>> threeSum(int[] nums) {

            Arrays.sort(nums);
            if (nums[0]==0 && nums[nums.length-1]==0){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    list.add(0);
                }
                res.add(new ArrayList<>(list));
                return res;
            }
            for (int i=0;i<nums.length;i++){
              temp.add(nums[i]);
            }
            dfs(nums,0,3,0);
            return res;
        }
        private void dfs(int[]nums,int i,int cnt,int target){

            if (cnt==1){
                if(target>=nums[i]&&temp.contains(target)){
                    //最后一个数直接用哈希表查找,要查找的数必须大于当前的左边界，不然会出错
                    path.push(target);
                    res.add(new ArrayList<>(path));
                    path.pop();
                }
                return ;
            }

            for (int j=i;j<=nums.length-cnt&&target>=nums[j]*cnt;++j){
                // 剪枝优化: nums[j]*cnt 剪枝
                if(j>i&&nums[j]==nums[j-1]|| nums[j] + (cnt - 1) * nums[nums.length - 1] < target ){
                    continue;
                }
                path.push(nums[j]);
                dfs(nums,j+1,cnt-1,target-nums[j]);
                path.pop();
            }
        }


//        回溯+剪枝操作
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        List<Integer> path = new ArrayList<>();
//        public List<List<Integer>> threeSum(int[] nums) {
//            Arrays.sort(nums);
//            int sum = 0;
//            backtracking(nums,0,sum);
//            return res;
//        }
//
//        private void backtracking(int[] nums,int startIdx,int sum){
//            //1.回溯终止条件
//            if (path.size()==3){
//                if (sum==0){
//                    res.add(new ArrayList<>(path));
//                }
//                return;
//            }
//
//            //2.单层遍历
//            for (int i = startIdx; i < nums.length; i++) {
//                //剪枝
//                path.size()
//                if (i>startIdx && nums[i]==nums[i-1]) continue;
//                path.add(nums[i]);
//                sum+=nums[i];
//                backtracking(nums,i+1,sum);
//                path.remove(path.size()-1);
//                sum-=nums[i];
//            }
//        }


    }
//leetcode submit region begin(Prohibit modification and deletion)
}
