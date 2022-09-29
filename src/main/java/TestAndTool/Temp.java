package TestAndTool;

import org.junit.Test;

import java.math.BigInteger;
import java.util.*;

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
        String s = "12342";
        System.out.println(s.substring(s.length()-2)); //从第一位开始截取
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


    @Test
    // 空数组的定义
    public void intTest(){
        int[] ints = new int[0]; //指定元素个数为0，表示空数组
        int[] ints1 = new int[]{1, 2};

        System.out.println(Arrays.toString(ints)); //[]
        System.out.println(Arrays.toString(ints1)); //[1, 2]
    }


    @Test
    //多重List定义
    public void ListTest(){
        List<List<Integer>> res = new ArrayList<>();
        System.out.println(res); // []
        //添加第一个元素
        res.add(new ArrayList<>());
        res.get(0).add(100);

        //添加第二个元素
        res.add(new ArrayList<>());
        res.get(1).add(100);
        System.out.println(res); //[[100], [100]]

        res.get(1).add(0,200);
        System.out.println(res); //[[100], [200, 100]]

        //添加第三个元素
        res.add(Arrays.asList(1,2,3));
        System.out.println(res); //[[100], [200, 100], [1, 2, 3]]

        System.out.println("====================================");
        //第二种定义的方式
        List<List<Integer>>list =new ArrayList<List<Integer>>();
        System.out.println(list);// []
        //添加第一个元素
        list.add(new ArrayList<>());
        list.get(0).add(100);

        //添加第二个元素
        list.add(new ArrayList<>());
        list.get(1).add(100);
        System.out.println(list); //[[100], [100]]

        list.get(1).add(0,200);
        System.out.println(list); //[[100], [200, 100]]

        //添加第三个元素
        list.add(Arrays.asList(1,2,3));
        System.out.println(list); //[[100], [200, 100], [1, 2, 3]]
    }

    @Test
    //for循环的剪枝操作
    public void forTest(){
        int min = 1;
        int[] nums = {2,2,2};
        int res = -1;
        for (int i = 0; i<nums.length &&nums[i] <= min  ; i++) {
            res = 1;
        }
        System.out.println(res);

    }

    @Test
    //顺序数组的去重
    public void sortDistinct(){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = 0;
        for (int i = 0; i < nums.length; i++) { //k=0,i=1  k=0,i=2            k=1,i=3   k=1,i=4  k=1,i=5      k=2,i=6   k=2,i=7       k=3,i=8    k=3,i=9
            if (nums[k]!=nums[i]){              //0,0      0,1                1,1       1,1      1,2          2,2       2,3           3,3        3,4
                k+=1;                           //         k=1                                   k=2                    k=3                      k=4
                nums[k]=nums[i] ;               //         nums[1]=1                             nums[2]=2              nums[3]=3                nums[4]=4
            }                                   // 0,0,..  0,1,...                               0,1,2                  0,1,2,3                  0,1,2,3,4
        }
        System.out.println(Arrays.toString(nums)); //[0, 1, 2, 3, 4, 2, 2, 3, 3, 4]
        System.out.println(k); //4
        int[] res = Arrays.copyOf(nums,k+1); //新数组长度为k+1
        System.out.println(Arrays.toString(res)); //[0, 1, 2, 3, 4]

    }

    @Test
    public void treeSetTest(){
        int[] numsDivide = {2,4,1,5};
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < numsDivide.length; i++) {
            set.add(numsDivide[i]);
        }
        int min = set.first();
        System.out.println(min);

        int i = 174740464% 16;
        System.out.println(i);

    }


    @Test
    //最大公约数
    public void gcd(){
        int val = 0;
        int num = 6;
        BigInteger gcd = BigInteger.valueOf(val).gcd(BigInteger.valueOf(num)); //0和其他的数的最大公约数为其他
        int res = gcd.intValue();  //6

        System.out.println(BigInteger.valueOf(2).gcd(BigInteger.valueOf(3))); //1
        System.out.println(BigInteger.valueOf(6).gcd(BigInteger.valueOf(3))); //3

        System.out.println(gcd.add(BigInteger.valueOf(3)));  //6+3=9

    }

    @Test
    //list的拷贝，即使使用item.clear()方法，
    // 因为是引用，最终的res有两个元素，两个元素都为同样的item
    public void listCopy(){
        List<Integer> item = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        item.add(1);
        res.add(item);
        item.clear();
        item.add(1);
        item.add(2);
        res.add(item);
        System.out.println(res);

    }



}
