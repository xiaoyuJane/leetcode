package leetcode.editor.cn.Tree;

//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 1419 👎 0

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal2 {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal2().new Solution();
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

    private Map<Integer,Integer> map; //继续使用全局变量

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //使用hashMap方法，避免重复遍历inorder
        map = new HashMap<>();
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
         int n = preorder.length;
        return buildTreeHelper(preorder,0,n-1,inorder,0,n-1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int i, int length, int[] inorder, int i1, int length1) {
        //递归终止条件
        if (i > length) return null;

        //根据前序遍历，将前序第一个节点放入root中
        TreeNode root = new TreeNode(preorder[i]);
        //获取root节点在map中存储的位置为index
        int index = map.get(preorder[i]);
        //左树的长度
        int left_n = index-i1;

        //向下递，右边；左边向上归
        root.left = buildTreeHelper(preorder,i+1,i+left_n,inorder,i1,index-1);
        root.right = buildTreeHelper(preorder,i+left_n+1,length,inorder,index+1,length1);

        return root;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}