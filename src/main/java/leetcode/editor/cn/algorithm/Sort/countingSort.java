package leetcode.editor.cn.algorithm.Sort;

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

        //倒插法，性能会好点
        public void countingSort3(int[] arr){
            int max = arr[0];
            int min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) max = arr[i];
                else if (arr[i] < min) min = arr[i];
            }
            // 确定计数范围
            int range = max - min + 1;
            // 建立长度为 range 的数组，下标 0~range-1 对应数字 min~max
            int[] counting = new int[range];
            for (int element : arr) {
                // 将每个整数出现的次数统计到计数数组中对应下标的位置，这里需要将每个元素减去 min，才能映射到 0～range-1 范围内
                counting[element - min]++;
            }
            // 每个元素在结果数组中的最后一个下标位置 = 前面比自己小的数字的总数 + 自己的数量 - 1。我们将 counting[0] 先减去 1，后续 counting 直接累加即可
            counting[0]--;
            for (int i = 1; i < range; i++) {
                // 将 counting 计算成当前数字在结果中的最后一个下标位置。位置 = 前面比自己小的数字的总数 + 自己的数量 - 1
                // 由于 counting[0] 已经减了 1，所以后续的减 1 可以省略。
                counting[i] += counting[i - 1];
            }
            int[] result = new int[arr.length];
            // 从后往前遍历数组，通过 counting 中记录的下标位置，将 arr 中的元素放到 result 数组中
            for (int i = arr.length - 1; i >= 0; i--) {
                // counting[arr[i] - min] 表示此元素在结果数组中的下标
                result[counting[arr[i] - min]] = arr[i];
                // 更新 counting[arr[i] - min]，指向此元素的前一个下标
                counting[arr[i] - min]--;
            }
            // 将结果赋值回 arr
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
