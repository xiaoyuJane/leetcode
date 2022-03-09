package leetcode.editor.cn.algorithm.BFS;

import java.util.*;

public class cloneGraphBfs {
    public static void main(String[] args) {
        Solution solution = new cloneGraphBfs().new Solution();
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
        public Node cloneGraph(Node node){
            if (node == null) return null;

            Queue<Node> queue = new LinkedList<>();
            Map<Node, Node> visited = new HashMap<>();

            queue.offer(node);
            Node startNode = new Node(node.val,new ArrayList<>());
            visited.put(node,startNode); // key为旧node，value为新node

            //bfs就是对队列的遍历过程
            while (!queue.isEmpty()){
                Node cur = queue.poll();
                for (Node neighbor : cur.neighbors){
                    if (visited.containsKey(neighbor)) {
                        visited.get(cur).neighbors.add(visited.get(neighbor));
                    }else {
                        Node neighborCopy = new Node(neighbor.val,new ArrayList<>());
                        visited.put(neighbor,neighborCopy);
                        visited.get(cur).neighbors.add(neighborCopy);
                        queue.offer(neighbor);
                    }
                }
            }
        return startNode;
        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
