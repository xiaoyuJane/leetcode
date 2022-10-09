package DayExe.DS2.D2;

import java.util.Arrays;

//使用数组实现
public class MyHashMap {

    int[] arr = new int[1000001];


    //MyHashMap() 用空映射初始化对象
    public MyHashMap() {
        Arrays.fill(arr,-1);

    }

    //void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value
    public void put(int key, int value) {
        arr[key] = value;
    }

    //int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1
    public int get(int key) {
        return arr[key];

    }

    //void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value
    public void remove(int key) {
        arr[key]=-1;

    }

}
