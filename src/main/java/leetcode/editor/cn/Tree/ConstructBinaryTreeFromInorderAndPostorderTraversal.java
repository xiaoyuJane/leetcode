package leetcode.editor.cn.Tree;

//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
//
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 673 👎 0

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        //翻转postOrder
        for (int i=0,k=postorder.length-1;i<k;i++,k--){
            int tmp = postorder[i];
            postorder[i] = postorder[k];
            postorder[k] = tmp;
        }
        //存储inorder进map
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        int len = inorder.length;
        //使用递归调用
        return dfs(postorder,0,len-1,inorder,0,len-1);

    }

    private TreeNode dfs(int[] postorder, int i, int len, int[] inorder, int i1, int len1) {
        //递归终止条件
        if (i1>len1) return null;

        int index = map.get(postorder[i]);
        int left_len = len1-index;
        TreeNode root = new TreeNode(postorder[i]);
        root.left = dfs(postorder,i+left_len+1,len,inorder,i1,index-1);
        root.right = dfs(postorder,i+1,i+left_len,inorder,index+1,len1);

        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
}