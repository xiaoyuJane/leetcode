package leetcode.editor.cn.algorithm.backtracking;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//2-abc
//3-def
//4-ghi
//5-jkl
//6-mno
//7-pqrs
//8-tuv
//9-wxyz
//示例:
//        输入："23"
//        输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

import java.util.ArrayList;
import java.util.List;

/**
 * for循环无限的时候就是回溯法登场的时候了
 * - 数字和字母如何映射 ，通过map或者数组下标
 * - 两个字母就两个for循环，三个字符我就三个for循环，以此类推，然后发现代码根本写不出来
 * - 输入1 * #按键等等异常情况
 */


public class Monagram {
    public static void main(String[] args) {
        Solution solution = new Monagram().new Solution();
        System.out.println(solution.Monagram("23"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> res = new ArrayList<>();
        StringBuffer path = new StringBuffer();

        String[] keys = new String[]{
                "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };

        public  List<String> Monagram(String digits){
            backtracking(digits,0);
            return res;
        }

        /**
         *
         * @param digits --传入的字符串，如23
         * @param index  --遍历到digits的位置
         */
        private void backtracking(String digits, int index){
            //边界条件
            if (index == digits.length()) {
                res.add(path.toString());
                return;
            }

            int i = digits.charAt(index) - '0'; //字符转换为数字
            String letters = keys[i];

            for (int j = 0; j < letters.length(); j++) {
                //处理
                path.append(letters.charAt(j));
                //递归
                backtracking(digits,index+1);
                //回溯
                path.deleteCharAt(path.length()-1);


            }



        }

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
