package DayExe.D2;

public class merge {
    public static void main(String[] args) {
        Solution solution = new merge().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //参考数据结构中的说法，数组插入是比较麻烦的，因为要整体后移动。
        // 如何避免往后移动呢？就是从后插入的方法，这里避免了移动，在数组中都可以尝试使用这种方法
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            //1. 定义指针
            int i = nums1.length-1;
            m--;
            n--;
            //2. 目的是将nums2的数字插入到nums1的后面位子中，所以这里的判断是nums2是否遍历完了即可
            while (n>=0){
                //3.考虑什么时候要将nums1放在后面位子，必然是m>=0且nums1的值大于nums2的值的时候
                while (m>=0 && nums1[m] > nums2[n]) {
                    nums1[i] = nums1[m];
                    nums1[m] = 0;
                    //更新指针
                    i--;
                    m--;
                }
                nums1[i--] = nums2[n--];
            }

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
