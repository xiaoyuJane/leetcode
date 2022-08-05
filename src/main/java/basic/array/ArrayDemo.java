package basic.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        int[] arr = {1, 2, 3};
        myArray(arr);
        System.out.println("arr[0] = " + arr[0]);


        if ("" == null) System.out.println(true);
        ArrayDemo arrayDemo = new ArrayDemo();
        Class<? extends ArrayDemo> aClass = arrayDemo.getClass();
        String name = aClass.getName();

        Class<?> aClass1 = Class.forName("ArrayDemo"); //会抛出ClassNotFoundException异常
        String name2 = aClass1.getName();


        Class<Void> voidClass = void.class;
        String name1 = voidClass.getName();
    }
    private static void myArray(int[] a) {
        a[0] = 10;
        System.out.println("a[0] = " + a[0]);
    }



    @Test
    public void mutiArray(){
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.printf("%d\t", arr[row][col]);
            }
            System.out.println("");
        }

    }

    @Test
    //浅拷贝
    public void simpleCopy(){
        int[] arr = {1,2,3,4,5,6};
        int[] newArr = arr;
        newArr[0] = 10;
        System.out.println(arr[0]); //10
    }

    @Test
    //深拷贝
    public void deepCopy(){
        int[] arr = {1,2,3,4,5,6};
        int[]newArr = Arrays.copyOf(arr, arr.length);
        newArr[0] = 10;
        System.out.println(arr[0]); //1


    }


    @Test
    public void define(){
        int[] arr = new int[]{1,5,3,4};
        printArray(arr);

        int[] ints = {5, 4, 1, 2};
        printArray(ints);

        int[] arrs = new int[5]; //[0, 0, 0, 0, 0];
        printArray(arrs);
    }

    @Test
    //遍历长度，使用下标访问
    public void traverse1(){
        int[] arr = new int[]{1, 2, 3, 4, 5};
        for(int i = 0; i < 5; i++){
            System.out.println(arr[i]);
        }
    }

    @Test
    //使用foreach功能
    public void traverse2(){
        int[] arr = new int[]{1, 2, 3, 4, 5};
        for (int x : arr) {
            System.out.println(x);
        }
    }


    private void printArray(int[] nums){
        System.out.println(Arrays.toString(nums));
    }
}
