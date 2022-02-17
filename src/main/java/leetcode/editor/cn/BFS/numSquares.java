package leetcode.editor.cn.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class numSquares {
    public static void main(String[] args) {
        Solution solution = new numSquares().new Solution();
        System.out.println(solution.numSquares(12));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 参考BiTreeBFSlevel，将n看成挂载在树上的点，叶子节点为累加的和，返回层数
     */
    class Solution {
        public int numSquares(int n) {
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            int level = 0;
            queue.offer(0);
            visited.add(0);

            while (!queue.isEmpty()){
                int size = queue.size();
                level++;

                for (int i=0;i<size;i++){
                    int digit = queue.poll();
                    for (int j=1;j<=n;j++){
                        int nodeValue = digit +j*j;
                        if (nodeValue == n) return level;
                        if (nodeValue >n) break;
                        if (!visited.contains(nodeValue)){
                            queue.offer(nodeValue);
                            visited.add(nodeValue);
                        }
                    }
                }
            }
            return level;

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
