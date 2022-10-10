package DayExe.DS2.D2;

import java.util.Arrays;
import java.util.HashMap;

public class sortColors {
    public static void main(String[] args) {
        Solution solution = new sortColors().new Solution();
        int[] nums = {2,1,0,2,1,1,0};
        solution.sortColors1(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //hashmap
        public void sortColors(int[] nums) {
            //计数
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num,map.getOrDefault(num,0)+1);
            }
            int c0= map.getOrDefault(0,0);
            int c1 = map.getOrDefault(1,0);
            //重写数组
            for (int i = 0; i <c0; i++) {
                nums[i]=0;
            }
            for (int i = c0; i < c0+c1; i++) {
                nums[i]=1;
            }
            for (int i = c0+c1; i < nums.length; i++) {
                nums[i]=2;
            }


        }

        //双指针
        public void sortColors1(int[] nums){
            //p是0位置对指针，q是2位置的指针
            int p = 0, q = nums.length-1;
            //i是遍历指针
            for (int i = p; i <= q;) {
                //遇到了0，交换nums[i]与nums[p]，由于nums[i]==0 所以不需要中间变量
                if (nums[i]==0 )  {
                    nums[i]=nums[p];
                    nums[p]=0;
                    //i前移，p找到了一个位置，p也前移
                    i++;
                    p++;
                }
                //遇到了2，交换i和q位置的值，由于i的值为2，省去中间变量，q移动，i位置继续比较，不移动
                else if (nums[i]==2 )
                {
                    nums[i]=nums[q];
                    nums[q]=2;
                    q--;

                }
                //遇到了1，不用管，只用移动i，只要放置好了0和2，1自然就归位
                else i++;
            }
        }

        //单指针
        public void sortColors2(int[] nums){
            int p=0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]==0){
                    nums[i]=nums[p]; //将i位置的非0元素都置换到了p位置，i继续往后走
                    nums[p]=0;
                    p++;
                }
            }

            for (int i = p; i < nums.length; i++) {
                if (nums[i]==1){
                    nums[i]=nums[p]; //p之前已经相对有序，都是0了，将i位置的1元素都置换到了p位置，i往后走
                    nums[p]=1;
                    p++;
                }
            }


        }



    }
//leetcode submit region begin(Prohibit modification and deletion)
}
