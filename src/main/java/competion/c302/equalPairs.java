package competion.c302;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class equalPairs {
    public static void main(String[] args) {
        Solution solution = new equalPairs().new Solution();
//        int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
//        System.out.println(solution.equalPairs(grid));
  /*      String s1="abc";
        String s2="abcd";
        System.out.println("s1.compareTo(s2)："+s1.compareTo(s2));//前缀相同则比较长度，长度差-1
        System.out.println("s1.compareTo(s2)："+s1.compareTo("abcdefgh"));//长度差-5  */

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int equalPairs(int[][] grid) {
            int count = 0;
            int n = grid.length;
            boolean flag= true;
            //对行对遍历 gird[i][k]
            for (int i = 0; i < n; i++) {
                //对列对遍历 grid[j][k]
                for (int j = 0; j < n; j++) {
                    //逐个比较元素
                    for (int k = 0; k < n; k++) {
                        if (grid[i][k]!=grid[k][j]) {
                            flag =false;
                            break;
                        }
                    }

                    if (flag) count++;
                    flag = true;
                }
            }
            return count;
        }


    }


    //leetcode submit region begin(Prohibit modification and deletion)
}
