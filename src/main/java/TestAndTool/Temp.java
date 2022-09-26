package TestAndTool;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Temp {

    @Test
    //求和的经典操作：
    // 1. 定义基本sum = 0
    // 2. 先取低位值相加，即sum = sum + num%10
    // 3. num右移动，即 num = num/10
    public void getSum (){
        int num = 1234;

        int sum = 0;
        while (num !=0){
            sum += num%10;
            num /=10;
        }
        System.out.println(sum);

    }


    @Test
    public void radixSort(){
        int[] arr = {21,56,88,195,354,1,35,12,6,7,3};
        int[] bucket = new int[arr.length]; //作为基数的桶
        int[] count = new int[arr.length]; //临时存储有序的数组
        int n = 3;
        int[] a = {1,10,100};

        for (int i = 0; i < n; i++) {
            //1.初始清空count数组
            for (int k = 0; k < arr.length; k++) {
                count[k]=0;
            }
            //2.计算arr数据对应的基数个数，填充count数组
            for (int j = 0; j < arr.length; j++) {
                count[(arr[j]/a[i])%10]++;
            }
            //3.更新count数组，值表明对应的基数桶右边界的位置（右闭）
            //开始计算位置，从0开始往后摞盘子，所以只顾看自己和前一个的位置即可
            for (int k = 1; k < arr.length; k++) {
                count[k] = count[k]+count[k-1];
            }

            //4. 把arr数据落入各个桶中，这里需要从后往前装
            for (int k = arr.length-1; k >= 0; k--) {
                int j = (arr[k]/a[i])%10;
                bucket[count[j]-1] = arr[k];
                count[j]--;
            }

            //5. 将桶中的数据取出来，赋值给arr
            for (int k = 0; k < arr.length; k++) {
                arr[k]=bucket[k];
            }
        }


        for (int num : arr) {
            System.out.println(num);
        }
        



    }

    @Test
    //字符串的截取测试
    public void subStrings(){
        String s = "abcd";
        System.out.println(s.substring(3)); //从第一位开始截取
        //bc
    }

    @Test
    //比较函数中可以参考外面的比较数组
    public void conpareTest(){
        String[] nums = {"102","473","251","814"};

        //1.下标数组
        Integer index[] = new Integer[nums.length];
        for (int j = 0; j < nums.length; j++) {
            index[j] = j;
        }
        System.out.println(Arrays.toString(index));
        //[0, 1, 2, 3]

        //2.通过辅助数组，来实现下标数组的排序
        Arrays.sort(index, Comparator.comparing(o -> nums[o].substring(1)));
        System.out.println(Arrays.toString(index));
        //[0, 3, 2, 1]

    }


}
