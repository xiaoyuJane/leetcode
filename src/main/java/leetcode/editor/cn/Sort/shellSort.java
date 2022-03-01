package leetcode.editor.cn.Sort;

/**
 * 希尔排序(希尔排序本质上是对插入排序的一种优化，它利用了插入排序的简单，又克服了插入排序每次只交换相邻两个元素的缺点)
 * 先对间隔较大的元素进行插入排序，完成宏观调控，通过交换间隔较远的元素，使得一次交换能消除一个以上的逆序对
 * 然后逐步缩小间隔，
 * 最后一轮一定是间隔为 1 的排序，也就是插入排序。
 * 间隔在希尔排序中被称为「增量」，增量序列不同，希尔排序的效率也不同。
 * 希尔增量序列为n/2  除以2依次递减
 * 希尔排序时间复杂度 平均复杂度界于 O(n)到 O(n^2)之间，普遍认为它最好的时间复杂度为 O(n^{1.3})
 * 希尔排序的空间复杂度为 O(1)，只需要常数级的临时变量。
 */
public class shellSort {
    public static void main(String[] args) {
        Solution solution = new shellSort().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public  void shellSort(int[] nums) {
            int n = nums.length;
            //希尔增量序列
            for(int i=n/2;i>0;i/=2){
                //小组数
                for(int j=0;j<i;j++){
                    //在小组内做插入排序
                    for(int k=j+i;k<n;k+=i){
                        int curr = nums[k];
                        int preIndex = k-i;
                        //最下值向前找位置，当不再小于即坐下
                        while(preIndex>=j && nums[preIndex] > curr){
                            nums[preIndex+i] = nums[preIndex];
                            preIndex = preIndex -i;
                        }
                        nums[preIndex+i] = curr;

                    }
                }
            }
        }

        //优化
        public  void shellSort2(int[] arr) {
            // 间隔序列，在希尔排序中我们称之为增量序列
            for (int nums = arr.length / 2; nums > 0; nums /= 2) {

                // 从 gap 开始，按照顺序将每个元素依次向前插入自己所在的组
                for (int i = nums; i < arr.length; i++) {
                    // currentNumber 站起来，开始找位置
                    int cur = arr[i];
                    // 该组前一个数字的索引
                    int preIndex = i - nums;
                    while (preIndex >= 0 &&  arr[preIndex] > cur) {
                        // 向后挪位置
                        arr[preIndex + nums] = arr[preIndex];
                        preIndex -= nums;
                    }
                    // currentNumber 找到了自己的位置，坐下
                    arr[preIndex + nums] = cur;
                }
            }
        }


    }
//leetcode submit region begin(Prohibit modification and deletion)
}
