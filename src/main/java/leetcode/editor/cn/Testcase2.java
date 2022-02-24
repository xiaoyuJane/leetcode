package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Testcase2 {
    public static void main(String[] args) {
//        int[] pre = new int[]{1,2,3,4,5};
//        int[] left = Arrays.copyOfRange(pre,0,2);//左闭右开，表示拷贝index 0到index2之间，包含index 0，不包含index2
//        for (int item:left ){
//            System.out.println(item);
//        }
//
//        System.out.println("=============");
//        int[] postorder = new int[]{9,6};
//        for (int i=0,k=postorder.length-1;i<k;i++,k--){
//            int tmp = postorder[i];
//            postorder[i] = postorder[k];
//            postorder[k] = tmp;
//        }
//        for (int item:postorder ){
//            System.out.println(item);
//        }
//
//        System.out.println("=============");
//        int[] k1 = new int[]{1,2,3,4,5};
//        int[] k2 = new int[]{1,2,3,4,5};
//        if (Arrays.equals(k1, k2)) System.out.println("true");
//        else System.out.println("false");
//
//        System.out.println("=============");
//        List<Integer> data = new ArrayList<Integer>(3);
//        System.out.println(data.size());
//        int mm = -1%1;
//        System.out.println(mm);

        //除法取最小值
//        System.out.println("=============");
//        double ave = 11/2;
//        int ave_i = 11/2;
//        System.out.println(ave_i);  //5
//        System.out.println(ave);  //5.0

        //String 转Integer
//        String s1 = "1";
//        String s2 = "2";
//        String op = "+";
//        System.out.println(Integer.parseInt(s1) + Integer.parseInt(s2));


//
        //int数组的默认值
//        int[] visited = new int[3];
//        for (int i : visited
//             ) {
//            System.out.println(i);
//        }

        //if中的或，如果前面为true，就不会再计算后面的true或者false了
       //或的情况下，如果第一个值为true，则不会去计算第二个值
//        int i=-1;
//        int[] a = {1,2};
//        if (i ==-1||a[i] ==1) System.out.println("yes");


        //split 分隔空格的情况
        String s = "a good example";
        String[] arr = s.split(" ");
//        String[] arr = s.split("\\s+");
        System.out.println(arr.length);
        for (String a: arr
             ) {
            System.out.println("1:"+a);

        }



    }
}
