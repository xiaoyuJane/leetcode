package leetcode.editor.cn.DS.List.array;

import java.util.Arrays;

//数组的拷贝方法在
// Java 中实现数组复制分别有以下 4 种方法：
//   Arrays 类的 copyOf() 方法
//   Arrays 类的 copyOfRange() 方法
//   System 类的 arraycopy() 方法
//   Object 类的 clone() 方法
//
// 浅拷贝只是复制了对象的引用地址，两个对象指向同一个内存地址，所以修改其中任意的值，另一个值都会随之变化。
// 深拷贝是将对象及值复制过来，两个对象修改其中任意的值另一个值不会改变。

public class ArrayCopy {
    public static void main(String[] args) {

        // 数组的定义方法1：直接定义
        int[] nums = {2,5,4,3,1,8};
        // 数组的定义方法2：new int[]
        int scores[] = new int[]{57,81,68,75,91};

        //1. copyOf() 方法是复制数组至指定长度到一个新数组中。
        int[] newScores = Arrays.copyOf(scores,8);//会采用默认值填充剩余 3 个元素的内容
        System.out.println(Arrays.toString(newScores)); //[57, 81, 68, 75, 91, 0, 0, 0]

        int[] newScoress = Arrays.copyOf(scores,5);
        System.out.println(scores == newScoress); //false
        System.out.println(Arrays.equals(scores,newScoress) ); //true
        newScoress[0] = 0;
        System.out.println(scores[0]);//57 互不相等。说明是深拷贝


        //2. copyOfRange() 方法则将指定数组的指定长度复制到一个新数组中。
        int[] newScores2 =  Arrays.copyOfRange(scores, 0, 4); //包含0位置，不包含4位置
        System.out.println(Arrays.toString(newScores2)); //[57, 81, 68, 75]
        int[] newScores3 =  Arrays.copyOfRange(scores, 0, 8); //终止位置可以超过原数组长度，超过部分使用默认值填充
        System.out.println(Arrays.toString(newScores3)); //[57, 81, 68, 75, 91, 0, 0, 0]

        //3. System 类的 arraycopy() 方法。目标数组必须已经存在，且不会被重构，相当于替换目标数组中的部分元素。
        // length + srcIndex 必须小于等于 srcArray.length，
        // 同时 length + destIndex 必须小于等于 destArray.length。
        System.arraycopy(nums, 0, scores, 2, 3); // 约束0+3<6, 2+3<=5
        System.out.println(Arrays.toString(scores)); //[57, 81, 2, 5, 4]


        //4. clone() 方法是类 Object 中的方法，可以创建一个有单独内存空间的对象。
        // 因为数组也是一个 Object 类，因此也可以使用数组对象的 clone() 方法来复制数组。数组中的元素全部复制到新数组中
        int[] newScores4 = nums.clone();
        System.out.println(Arrays.toString(newScores4)); //[2, 5, 4, 3, 1, 8]
        System.out.println(newScores4 == nums); //false

    }
}
