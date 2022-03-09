package leetcode.editor.cn.algorithm.BFS;

public class BFS {

//    https://www.cnblogs.com/cs-whut/p/11147348.html
//    广度优先搜索算法的搜索步骤一般是：
//      （1）从队列头取出一个结点，检查它按照扩展规则是否能够扩展，如果能则产生一个新结点。
//      （2）检查新生成的结点，看它是否已在队列中存在，如果新结点已经在队列中出现过，就放弃这个结点，然后回到第（1）步。否则，如果新结点未曾在队列中出现过，则将它加入到队列尾。
//      （3）检查新结点是否目标结点。如果新结点是目标结点，则搜索成功，程序结束；若新结点不是目标结点，则回到第（1）步，再从队列头取出结点进行扩展。
//    最终可能产生两种结果：找到目标结点，或扩展完所有结点而没有找到目标结点。
//    如果目标结点存在于解答树的有限层上，广度优先搜索算法一定能保证找到一条通向它的最佳路径，
//    因此广度优先搜索算法特别适用于只需求出最优解的问题。当问题需要给出解的路径，则要保存每个结点的来源，也就是它是从哪一个节点扩展来的。
//void  BFS（）
//    {
//        队列初始化；
//        初始结点入队；
//        while （队列非空）
//        {
//            队头元素出队，赋给current；
//            while  （current 还可以扩展）
//            {
//                由结点current扩展出新结点new；
//                if  （new 重复于已有的结点状态） continue;
//                new结点入队；
//                if  (new结点是目标状态)
//                {
//                    置flag= true;    break;
//                }
//            }
//        }
//    }


    /**
     *
     * Return the length of the shortest path between root and target node.
     * 完全确定没有循环，例如，在树遍历中
     */
//    int BFS(Node root, Node target) {
//        Queue<Node> queue;  // store all nodes which are waiting to be processed
//        int step = 0;       // number of steps neeeded from root to current node
//        // initialize
//        add root to queue;
//        // BFS
//        while (queue is not empty) {
//            step = step + 1;
//            // iterate the nodes which are already in the queue
//            int size = queue.size();
//            for (int i = 0; i < size; ++i) {
//                Node cur = the first node in queue;
//                return step if cur is target;
//                for (Node next : the neighbors of cur) {
//                    add next to queue;
//                }
//                remove the first node from queue;
//            }
//        }
//        return -1;          // there is no path from root to target
//    }


    /**
     * Return the length of the shortest path between root and target node.
     * 不能确保是否有环，则要加入哈希表来去重跳过
     */
//    int BFS(Node root, Node target) {
//        Queue<Node> queue;  // store all nodes which are waiting to be processed
//        Set<Node> used;     // store all the used nodes
//        int step = 0;       // number of steps neeeded from root to current node
//        // initialize
//        add root to queue;
//        add root to used;
//        // BFS
//        while (queue is not empty) {
//            step = step + 1;
//            // iterate the nodes which are already in the queue
//            int size = queue.size();
//            for (int i = 0; i < size; ++i) {
//                Node cur = the first node in queue;
//                return step if cur is target;
//                for (Node next : the neighbors of cur) {
//                    if (next is not in used) {
//                        add next to queue;
//                        add next to used;
//                    }
//                }
//                remove the first node from queue;
//            }
//        }
//        return -1;          // there is no path from root to target
//    }
}
