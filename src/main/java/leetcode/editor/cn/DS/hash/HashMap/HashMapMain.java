package leetcode.editor.cn.DS.hash.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapMain {
    public static void main(String[] args) {
        // 1. initialize a hash map
        Map<Integer, Integer> hashmap = new HashMap<>();

        // 2. insert a new (key, value) pair
        hashmap.putIfAbsent(0, 0);
        hashmap.putIfAbsent(2, 3);
        System.out.println( "The value of key 3 is: " + hashmap.get(3));


        // 3. insert a new (key, value) pair or update the value of existed key
        System.out.println(hashmap.put(1, 1)); //新插入返回null，如果存在旧值，返回上一次的value
        System.out.println(hashmap.put(1, 2));

        // 4. get the value of specific key
        System.out.println("The value of key 1 is: " + hashmap.get(1));

        for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
            System.out.print("(" + entry.getKey() + "," + entry.getValue() + ") ");
        }
        System.out.println("are in the hash map.");
        // 5. delete a key
        System.out.println("remove 2 return is: " + hashmap.remove(2));

        // 6. check if a key is in the hash map
        if (!hashmap.containsKey(2)) {
            System.out.println("Key 2 is not in the hash map.");
        }

        // 7. get the size of the hash map
        System.out.println("The size of hash map is: " + hashmap.size());

        // 8. iterate the hash map
        for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
            System.out.print("(" + entry.getKey() + "," + entry.getValue() + ") ");
        }
        System.out.println("are in the hash map.");
        // 9. clear the hash map
        hashmap.clear();
        // 10. check if the hash map is empty
        if (hashmap.isEmpty()) {
            System.out.println("hash map is empty now!");
        }


        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> values = new ArrayList<>();
        map.put(1,values);
        System.out.println(map.get(1).isEmpty());  //true
        System.out.println(map.containsKey(2));  //false

        Map<String, String[]> map1 = new HashMap<>();
        System.out.println(map1.remove(1)); //null


        // hashMap 输出是无序的，并不是按照输入的顺序
//        Map<Character, Integer> hashmap = new HashMap<>();
//        hashmap.put('l',0);
//        hashmap.put('e',0);
//        hashmap.put('t',0);
//        hashmap.put('v',0);
//        for (Map.Entry<Character, Integer> entry:hashmap.entrySet()){
//            System.out.println(entry.getKey() + " = " + entry.getValue());
        // }
       /* 输出：
        t = 0
        e = 0
        v = 0
        l = 0*/
    }


}
