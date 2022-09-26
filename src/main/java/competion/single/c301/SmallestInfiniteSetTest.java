package competion.single.c301;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallestInfiniteSetTest {
    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSetTest().new SmallestInfiniteSet();

        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        smallestInfiniteSet.addBack(3);    // 2 已经在集合中，所以不做任何变更。
        System.out.println(smallestInfiniteSet.popSmallest());
        smallestInfiniteSet.addBack(2);    // 将 1 添加到该集合中。
        System.out.println(smallestInfiniteSet.popSmallest());
        // 且 1 是最小的整数，并将其从集合中移除。
        System.out.println(smallestInfiniteSet.popSmallest());
//        System.out.println(smallestInfiniteSet.popSmallest());


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

    }

    class SmallestInfiniteSet {
        private List<Integer> exludes;
        private int min;

        //SmallestInfiniteSet() 初始化 SmallestInfiniteSet 对象以包含 所有 正整数。
        public SmallestInfiniteSet() {
            exludes = new ArrayList<>();
            min =1;

        }
        //int popSmallest() 移除 并返回该无限集中的最小整数。
        public int popSmallest() {
            int res = min;
            //更新min
            if (exludes.isEmpty()){
                exludes.add(res);
                min = min+1;
            }else {
                exludes.add(res);
                //Collections.sort(exludes);
                //int high = exludes.get(exludes.size()-1);
                // boolean flag = false;
                for (int i = 1; i <Integer.MAX_VALUE; i++) {
                    if (!exludes.contains(i)) {
                        min = i;
                        // flag = true;
                    }
                }
                // if (!false) min = high+1;

            }
            return res;

        }
        //如果正整数 num 不 存在于无限集中，则将一个 num 添加 到该无限集中。
        public void addBack(int num) {
            if (exludes.contains(num)) {
                exludes.remove((Integer)num);
            }
            min = Math.min(min, num);
        }
    }

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
    //leetcode submit region begin(Prohibit modification and deletion)
}
