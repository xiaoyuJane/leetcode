package leetcode.editor.cn.hash.HashSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//哈希集是集合的实现之一，它是一种存储不重复值的数据结构。
// 通常，使用哈希集来检查该值是否已经出现过。

public class HashSetMain {
    public static void main(String[] args) {
        // 1. initialize the hash set
        Set<Integer> hashSet = new HashSet<>();
        // 2. add a new key
        hashSet.add(3);
        hashSet.add(2);
        hashSet.add(1);

        System.out.println(hashSet);

        //set获取第一个元素
        System.out.println(hashSet.iterator().next());
        System.out.println(hashSet.toArray()[0]);
        List<Integer> list = new ArrayList<>(hashSet);
        System.out.println(list.get(0));

        // 3. remove the key
        hashSet.remove(2);

        // 4. check if the key is in the hash set
        if (!hashSet.contains(2)) {
            System.out.println("Key 2 is not in the hash set.");
        }
        // 5. get the size of the hash set
        System.out.println("The size of has set is: " + hashSet.size());


        // 6. iterate the hash set
        for (Integer i : hashSet) {
            System.out.print(i + " ");
        }
        System.out.println("are in the hash set.");

        // 7. clear the hash set
        hashSet.clear();

        // 8. check if the hash set is empty
        if (hashSet.isEmpty()) {
            System.out.println("hash set is empty now!");
        }
    }


}
