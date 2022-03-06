package leetcode.editor.cn.Sort;

import java.util.Arrays;

//基数排序
public class radixSort {
    public static void main(String[] args) {
        Solution solution = new radixSort().new Solution();
//        int[] arr = {8,235,20,527,138,156};
        int[] arr = {15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,
                15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,
                22101,32406,21540,31799,3768,26679,21799,23740};
        solution.radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public  void radixSort(int[] arr){
            if (arr == null) return;

            // 1.先找出最大值
            int max = arr[0];
            for (int value :arr){
                if (value>max) max=value;
            }

            // 2.再找最大值的位数
            int n = 0;
            while (max!=0){
                n++;
                max = max/10;
            }

            // 3.遍历位数轮，每轮进行计数排序
            int[] counting = new int[10];
            int[] result = new int[arr.length];
            int dev = 1; //从低位到高位
            for (int i = 0; i < n; i++) {
                //3.1构建couting
                for (int value :arr){
                    int radix = value/dev %10;
                    counting[radix]++;
                }
                //couting[j] 表示排在j之前的数的数量
                for (int j = 1; j < counting.length; j++) {
                    counting[j] +=counting[j-1];
                }
                //3.2 使用倒数排序遍历的方式完成计数排序
                for (int j = arr.length-1; j >=0 ; j--) {
                    int radix = arr[j]/dev %10;  //拿到基数
                    result[--counting[radix]] = arr[j]; //找到arr[j]的真实位置，其真实位置排序为--counting[radix]
                }

                //使用 System.arraycopy() 方法对数组进行拷贝时，需要目标数组的信息，同时需要原始数组、原始数组的拷贝位置，目标数组的拷贝位置和拷贝长度信息；
                //使用 Arrays.copyOf() 方法对数组进行拷贝时，不需要目标数组的信息，只需要源数组和拷贝数据的长度信息，返回的新数组的长度也就是拷贝数据的长度；
                System.arraycopy(result, 0, arr, 0, arr.length);
//                arr = Arrays.copyOf(result,arr.length);
                Arrays.fill(counting,0);
                dev *=10;
            }


        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
