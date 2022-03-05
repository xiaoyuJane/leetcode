package leetcode.editor.cn.Sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class countingSort {
    public static void main(String[] args) {
        Solution solution = new countingSort().new Solution();
        int[] arr ={8,7,1,2,8,6,2};
        solution.countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //通过计数数组（存放的是比它大的那些数字），拿到这个数该存放的位置
        public void countingSort(int[] arr) {
            int[] counting = new int[9]; //计数数组

            //arr中的元素作为计数数组的index （index覆盖到最小值到最大值）
            for (int element : arr) {
                counting[element - 1]++;
            }

            //构建couting数值，保存的是比该值大的数目，累加的范式
            int preCounts = 0;
            for (int i = 0; i < counting.length; i++) {
                int temp = counting[i];
                counting[i] = preCounts;  //counting[i] 记录的是比自己小的数字的总数
                preCounts += temp;
            }

            int[] result = new int[arr.length];
            for (int element :arr) {
                int index = counting[element-1];
                result[index] = element;
                counting[element-1]++;
            }

            for (int i = 0; i < arr.length; i++) {
                arr[i] = result[i];
            }
        }


        public void countingSort1(int[] arr) {
            int[] counting = new int[9]; //计数数组
            //arr中的元素作为计数数组的index （index覆盖到最小值到最大值）
            for (int element : arr) {
                counting[element - 1]++;
            }
            int index = 0;
            //依次遍历计数数组，把计数数组中的值输出
            for (int i = 0; i < 9; i++) {
                while (counting[i] != 0) {
                    arr[index++] = i + 1; //重新赋值
                    counting[i]--;  //更新变量
                }
            }
        }

        /*// 改进版
        // 在统计元素出现的次数时，同时把真实的元素保存到列表中，
        // 输出时，从列表中取真实的元素*/
        public void countingSort2(int[] arr) {
            int[] counting = new int[9]; //计数数组
            HashMap<Integer, Queue<Integer>> records = new HashMap<>();

            for (int element : arr) {
                counting[element - 1]++;
                if (!records.containsKey(element - 1)) {
                    records.put(element - 1, new LinkedList<>());
                }
                records.get(element - 1).add(element);
            }
            int index = 0;
            //依次遍历计数数组，把计数数组中的值输出
            for (int i = 0; i < 9; i++) {
                while (counting[i] != 0) {
                    arr[index++] = records.get(i).remove();
                    counting[i]--;
                }
            }
        }


    }
//leetcode submit region begin(Prohibit modification and deletion)
}
