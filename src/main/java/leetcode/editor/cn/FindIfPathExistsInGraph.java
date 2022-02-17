package leetcode.editor.cn;
// 1971
//有一个具有 n个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。图中的边用一个二维整数数组 edges 表示，其中 e
//dges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。 每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。 
//
// 请你确定是否存在从顶点 start 开始，到顶点 end 结束的 有效路径 。 
//
// 给你数组 edges 和整数 n、start和end，如果从 start 到 end 存在 有效路径 ，则返回 true，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, edges = [[0,1],[1,2],[2,0]], start = 0, end = 2
//输出：true
//解释：存在由顶点 0 到顶点 2 的路径:
//- 0 → 1 → 2 
//- 0 → 2
// 
//
// 示例 2： 
//
// 
//输入：n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], start = 0, end = 5
//输出：false
//解释：不存在由顶点 0 到顶点 5 的路径.
// 
//
// 
//
// 提示:
//
// 
// 1 <= n <= 2 * 105 
// 0 <= edges.length <= 2 * 105 
// edges[i].length == 2 
// 0 <= ui, vi <= n - 1 
// ui != vi 
// 0 <= start, end <= n - 1 
// 不存在双向边 
// 不存在指向顶点自身的边 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 
// 👍 22 👎 0


import java.util.*;

public class FindIfPathExistsInGraph{
    public static void main(String[] args) {
        Solution solution = new FindIfPathExistsInGraph().new Solution();
        int[][] edges = {
                {0,1},
                {1,2},
                {2,0}
        };
        System.out.println(solution.validPath(3,edges,0,2));

    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //包含所有节点的邻接节点
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> start = map.getOrDefault(edge[0], new ArrayList<Integer>());
            List<Integer> end = map.getOrDefault(edge[1], new ArrayList<Integer>());
            start.add(edge[1]);
            end.add(edge[0]);

            map.put(edge[0], start); //节点的邻接节点
            map.put(edge[1], end);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(source); //入队
        Map<Integer, Integer> status = new HashMap<>();
        while (!queue.isEmpty()) {
            Integer tmp = queue.poll(); //出队
            if (tmp == destination) return true;
            System.out.println(tmp);

            if (!status.containsKey(tmp) && map.containsKey(tmp)) {
                List<Integer> list = map.get(tmp); //tmp的邻接节点
                for (int i = 0; i < list.size(); i++) {
                    Integer m = list.get(i);
                    if (m == destination) return true;
                    if (!status.containsKey(m)) queue.offer(m); //入队
                }
                status.put(tmp, 0);
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}