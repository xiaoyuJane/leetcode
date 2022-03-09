package leetcode.editor.cn;

//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
//
// 示例 1：
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
//
// 提示： 
// 1 <= numCourses <= 105
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 1156 👎 0

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule{
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        int[] flags = new int[numCourses];
        for(int[] cp : prerequisites)
            adjacency.get(cp[1]).add(cp[0]);
        for(int i = 0; i < numCourses; i++)
            if(!dfs(adjacency, flags, i)) return false;
        return true;
    }
    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if(flags[i] == 1) return false;//在同一条访问链上
        if(flags[i] == -1) return true;
        flags[i] = 1; //正在访问
        for(Integer j : adjacency.get(i))
            if(!dfs(adjacency, flags, j)) return false;
        flags[i] = -1; //访问结束
        return true;
    }


    /**
     * 官方解答
     */
    List<List<Integer>> edges;
        int[] visited; //状态数组，0为未搜索，1为搜索中，2 为搜索完成
        boolean valid = true;

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        //1.1 边集合的初始化
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        //1.2 状态数组的初始化
        visited = new int[numCourses]; //初始化都为0

        // 2.边表存入
        // prerequisites[i] = [ai, bi] 表示bi -> ai
        for (int[] info : prerequisites){
            edges.get(info[1]).add(info[0]); //edges存放的是(bi->ai) (bi->ci)
        }

        //从0号开始深度优先遍历
        for (int i = 0; i < numCourses && valid; i++) {
            //i未被搜索
            if (visited[i] == 0) dfs1(i);
        }
        return  valid;
    }

    /**
     * 某个节点的深度优先遍历
     * @param u
     */
    private void dfs1(int u){
        // 1.正在搜索
        visited[u] = 1;
        for (int v : edges.get(u)){ //u的每条出边
            if (visited[v] == 0){
                // 深度遍历
                dfs1(v);
            }//2.关键点在这里，dfs过程中，不会出现dfs到同一访问链状上的点，如果访问到了则证明有环，直接退出，所以状态1 很有必要出现
            else if (visited[v] == 1){
                valid = false;
                return;
            }
        }
        // 3.终止条件，没有出边或者是出边不为未访问0 也不为正在访问1
        visited[u] = 2;

    }



}
//leetcode submit region end(Prohibit modification and deletion)

}