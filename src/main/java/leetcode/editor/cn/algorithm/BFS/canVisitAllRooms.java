package leetcode.editor.cn.algorithm.BFS;

//有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。
//
//        当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。
//
//        给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。如果能进入 所有 房间返回 true，否则返回 false。
//
//         
//
//        示例 1：
//
//        输入：rooms = [[1],[2],[3],[]]
//        输出：true
//        解释：
//        我们从 0 号房间开始，拿到钥匙 1。
//        之后我们去 1 号房间，拿到钥匙 2。
//        然后我们去 2 号房间，拿到钥匙 3。
//        最后我们去了 3 号房间。
//        由于我们能够进入每个房间，我们返回 true。
//        示例 2：
//
//        输入：rooms = [[1,3],[3,0,1],[2],[0]]
//        输出：false
//        解释：我们不能进入 2 号房间。
//         
//
//        提示：
//
//        n == rooms.length
//        2 <= n <= 1000
//        0 <= rooms[i].length <= 1000
//        1 <= sum(rooms[i].length) <= 3000
//        0 <= rooms[i][j] < n
//所有 rooms[i] 的值 互不相同
//        相关标签
//        深度优先搜索
//        广度优先搜索
//        图

import java.util.*;

public class canVisitAllRooms {
    public static void main(String[] args) {
        Solution solution = new canVisitAllRooms().new Solution();
        List<List<Integer>> rooms = new ArrayList<List<Integer>>(){{
            add(Arrays.asList(1,3));
            add(Arrays.asList(3,0,1));
            add(Arrays.asList(2));
            add(Arrays.asList(0));
        }
        };

        System.out.println(solution.canVisitAllRooms(rooms));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int n = rooms.size();
            int[] visited = new int[n];  //初始为0，表示都未访问过
            Queue<List<Integer>> queue= new LinkedList<List<Integer>>();

            queue.offer(rooms.get(0));
            visited[0] = 1; //1表示访问了

            while (!queue.isEmpty()){
                List<Integer> current = queue.poll();
                for (Integer key : current) {
                    if (visited[key] == 0 ) {
                        visited[key] = 1;
                        queue.offer(rooms.get(key));
                    }
                }
            }

            for (int i=0;i<visited.length;i++){
                if (visited[i] == 0) return false;
            }

            return true;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
