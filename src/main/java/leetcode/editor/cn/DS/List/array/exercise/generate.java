package leetcode.editor.cn.DS.List.array.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *  
 *
 * 提示:
 *
 * 1 <= numRows <= 30
 * 相关标签
 * 数组
 * 动态规划
 *
 */
public class generate {
    public static void main(String[] args) {
        Solution solution = new generate().new Solution();
        System.out.println(solution.generate(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            for (int i=1;i<=numRows;i++){
                res.add(generateRow(i));
            }
            return res;


        }

        //递归，自己调用自己
        private List<Integer> generateRow(int numRows){
            if (numRows == 1) return Arrays.asList(1);
            if (numRows == 2) return Arrays.asList(1,1);

            List<Integer> res1 = generateRow(numRows-1);

            int size = res1.size();
            List<Integer> res = new ArrayList<Integer>();
            res.add(1);
            for (int i=0;i<size-1;i++){
                res.add(res1.get(i)+res1.get(i+1));
            }
            res.add(1);
            return res;
        }


        //不用自己调用自己的方式
        private List<Integer> generateRow3(int numRows){
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int i = 1; i <= numRows; ++i) {
                row.add(0);
                for (int j = i; j > 0; --j) {
                    row.set(j, row.get(j) + row.get(j - 1));
                }
            }
            return row;
        }




    }
//leetcode submit region begin(Prohibit modification and deletion)
}
