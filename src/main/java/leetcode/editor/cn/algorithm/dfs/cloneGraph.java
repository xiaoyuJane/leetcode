package leetcode.editor.cn.algorithm.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 克隆图，其实就是图的遍历，遍历的过程中将节点和节点关系记录
 */
public class cloneGraph {
    public static void main(String[] args) {
        Solution solution = new cloneGraph().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    class Solution {
        //使用一个hashmap来存储访问过的节点
        HashMap<Integer,Node> visited = new HashMap<Integer,Node>();

        public Node cloneGraph(Node node) {
            if (node == null) return null;

            //递归终止条件，遍历到访问过的点，返回，即出栈
            if (visited.containsKey(node.val)) return visited.get(node.val);

            //向下归的过程
            //1.新建节点，并做好访问记录，key为节点的值，因为节点值=index，能保证唯一，值为节点node
            Node newNode = new Node(node.val,new ArrayList<>());
            visited.put(newNode.val,newNode);

            //2,遍历临近节点，递归调用克隆方法
            for (Node neighbor: node.neighbors) {
                //递归使用的是系统自身的调用栈
                newNode.neighbors.add(cloneGraph(neighbor));
            }
            return newNode;

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
