package leetcode.editor.cn;

import java.util.*;

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
//        String s = "a good example";
//        String[] arr = s.split(" ");
////        String[] arr = s.split("\\s+");
//        System.out.println(arr.length);
//        for (String a: arr
//             ) {
//            System.out.println("1:"+a);
//
//        }

        //java 解决字符串转码问题，查询sql时有效
        //https://blog.csdn.net/weixin_43828846/article/details/117602462?spm=1001.2101.3001.6650.8&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-8.pc_relevant_default&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-8.pc_relevant_default&utm_relevant_index=12
//        String str = "\\";
//        if (str !=null && !"".equals(str) ){
//            str = str.replaceAll("\\\\","\\\\\\\\")
//                    .replace("_","\\_").replace("\'","\\'")
//                    .replace("%","\\%").replace("*","\\*");
//        }
//        System.out.println(str);


//        // 测试i++ 与i的关系
//        int[] temp = {1,2};
//        int i=0;
//        System.out.println(temp[i++]);  //打印temp[0]
//        System.out.println(i); //i=1

/*
        //o1.compareTo(o2) 当o1<o2 返回-1
        Integer o1 = 1;
        Integer o2 = 3;
        int res = o1.compareTo(o2);  //-1
        System.out.println(res);
        System.out.println(o1.compareTo(o2) == o1-o2);

        Integer[] a = {9,8,7,2,3,4,1,0,6,5};
        Arrays.sort(a,new Comparator<Integer>(){ //升序实现1
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (o1>o2) return 1;  //o1-o2>0
                    else if (o1<o2) return -1;
                    else return 0;
//                  return o1.compareTo(o2); // 上述三行等价于
                }
            });
        Arrays.sort(a,(a1,a2)->a1-a2);  //升序是按照o1.compareTo(o2)来的，即(a1,a2)->a1-a2；
        Arrays.sort(a,(a1,a2)->a2-a1); //降序就要取反
        System.out.println(Arrays.toString(a));
*/

/*
        int[] score = {10,3,8,9,4};
        int[][] arr = new int[score.length][2];
        for (int i = 0; i < score.length ; i++) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr,(a,b)->b[0]-a[0]); //按照第一维度降序排列
        for (int[] num : arr) {
            System.out.println(Arrays.toString(num));
        }*/

//        //int数组转化为String数组
//        int[] score = {9,8,7,3};
//        String[]res = Arrays.stream(score).mapToObj(String::valueOf).toArray(String[]::new);
//        System.out.println(Arrays.toString(res)); //[9, 8, 7, 3]
//        System.out.println(score.toString()); //[I@2e817b38


       /* //int转String，使用String.valueOf
        int a = 1;
        int b = 2;
        String ab = String.valueOf(a) + String.valueOf(b); //字符串12
        String ba = String.valueOf(b) + String.valueOf(a); //字符串21
        //String 转int ，使用Integer.parseInt
        int c = Integer.parseInt(ab);
        int d = Integer.parseInt(ba);
        System.out.println(c);
        System.out.println(d);
        boolean res = Integer.parseInt(ab) < Integer.parseInt(ba);
        System.out.println(res);*/

/*       //正则
        int[] score = {9,8,7,3};
        String res = Arrays.toString(score);
        System.out.println(res);
//        res.replaceAll("\\[|]|,|\\s","");
        System.out.println(res.replaceAll("\\[|]|,|\\s",""));*/

        // hashMap 输出是无序的，并不是按照输入的顺序
        Map<Character, Integer> hashmap = new HashMap<>();
        hashmap.put('l',0);
        hashmap.put('e',0);
        hashmap.put('t',0);
        hashmap.put('v',0);
        for (Map.Entry<Character, Integer> entry:hashmap.entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
       /* 输出：
        t = 0
        e = 0
        v = 0
        l = 0*/



    }
}
