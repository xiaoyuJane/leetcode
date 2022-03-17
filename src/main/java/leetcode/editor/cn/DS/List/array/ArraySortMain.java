package leetcode.editor.cn.DS.List.array;

import java.util.Arrays;

/**
 * Arrays.sort的进阶用法
 *
 */
public class ArraySortMain {
    public static void main(String[] args) {

        //Arrays.sort
        int[] array1 = {2,3,1,5,4};
        Arrays.sort(array1); //默认情况下是从小到大排列
        System.out.println(Arrays.toString(array1)); //[1, 2, 3, 4, 5]

        int[] array2 = {9,8,7,2,3,4,1,0,6,5};
        Arrays.sort(array2,0,3); //对数组部分排序，也就是对数组a的下标从fromIndex到toIndex-1的元素排序
        System.out.println(Arrays.toString(array2)); //[7, 8, 9, 2, 3, 4, 1, 0, 6, 5]

        //想要更改默认的排列顺序，需要自定义Comparator类型的参数，并且不能使用基本类型，而要使用它们的包装类
        Integer[] array3 = {9,8,7,2,3,4,1,0,6,5};
        Arrays.sort(array3,(a1,a2)->a2-a1); //实现降序排列
        for (Integer item:array3
             ) {
            System.out.println(item);

        }










    }


//leetcode submit region begin(Prohibit modification and deletion)
}
