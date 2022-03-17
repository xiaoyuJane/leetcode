package leetcode.editor.cn.DS.List.array;

import java.util.Arrays;

public class ArraySortDefine {
    public static void main(String[] args) {
        Solution solution = new ArraySortDefine().new Solution();
        solution.sort1();
        solution.sort2();
        solution.sort3();
        solution.compSort();
    }

    /**
     * sort(T[] a, Comparator<? supre T> c): 根据指定比较器产生的顺序对指定对象数组进行排序。
     * sort(T[] a, int formIndex, int toIndex, Comparator<? supre T> c): 根据指定比较器产生的顺序对指定对象数组的指定对象数组进行排序。
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        // 如果a1<a2,返回正值，a1>a2，返回负值，相等返回0
        public void sort1(){
            int[] a={2,5,4,3,1,8};
            //默认从小到大排序
            Arrays.sort(a); //1.sort(T[] a)：对指定T型数组按数字升序排序。
            System.out.println(Arrays.toString(a));
        }



        public void sort2(){
            int[] a={2,5,4,3,1,8};
            Arrays.sort(a,2,5); //2.sort(T[] a,int formIndex, int toIndex)：对指定T型数组的指定范围按数字升序排序
            System.out.println(Arrays.toString(a));
        }

        public void compSort(){
            Integer[] a = {9,8,7,2,3,4,1,0,6,5};

//            Arrays.sort(a,(a1,a2)->a1-a2);  //升序是按照o1.compareTo(o2)来的，即(a1,a2)->a1-a2；
            Arrays.sort(a,(a1,a2)->a2-a1); //降序就要取反

//            Arrays.sort(a,new Comparator<Integer>(){
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    if (o1>o2) return 1;  //o1-o2>0
//                    else if (o1<o2) return -1;
//                    else return 0;
////                    return o1.compareTo(o2);
//                }
//            });
            System.out.println(Arrays.toString(a));
        }




        public void sort3(){
            int[][] nums=new int[][]{{1,3},{1,2},{4,5},{3,7}};

            //写法1
   /*         Arrays.sort(nums,new Comparator<int[]>(){
                @Override
                public int compare(int[] a,int[] b){
                    if(a[0]==b[0]){
                        return a[1]-b[1];
                    }else{
                        return a[0]-b[0];  //升序排列，即若a[0]-b[0]<0
                    }
                }
            });*/

            //写法2
            // 升序排序的逻辑：如果a1<a2,返回正值，a1>a2，返回负值，相等返回0
//            Arrays.sort(nums,(a,b)->a[0]-b[0]);
            //降序逻辑，如果
            Arrays.sort(nums,(a,b)->b[0]-a[0]);

            for (int[] num : nums) {
                System.out.println(Arrays.toString(num));
            }
        }



    }
//leetcode submit region begin(Prohibit modification and deletion)
}
