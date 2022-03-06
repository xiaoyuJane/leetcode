package leetcode.editor.cn.Sort.exercise;

/**
 * 1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。
 *
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 示例 1：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * 示例  2:
 *
 * 输入：arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
 * 输出：[22,28,8,6,17,44]
 *
 * 提示：
 *
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i]  各不相同 
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * 相关标签
 * 数组
 * 哈希表
 * 计数排序
 * 排序
 */

public class relativeSortArray {
    public static void main(String[] args) {
        Solution solution = new relativeSortArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //计数排序的变种
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int n = arr1.length;
            int min = arr1[0], max=arr1[0];
            for(int i=0;i<n;i++){
                min = Math.min(min,arr1[i]);
                max = Math.max(max,arr1[i]);
            }

            int c_length = max-min +1;
            int[] couting = new int[c_length];
            for(int arr:arr1){
                couting[arr-min]++;
            }

            int i = 0;
            for(int num:arr2){
                while(couting[num-min]!=0){
                    arr1[i++] = num;
                    couting[num-min]--;
                }
            }

            for(int j=0;j<c_length;j++){
                while(couting[j]!=0){
                    arr1[i++] = j+min;
                    couting[j]--;
                }
            }

            return arr1;
        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
