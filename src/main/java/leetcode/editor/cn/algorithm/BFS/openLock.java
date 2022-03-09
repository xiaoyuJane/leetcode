package leetcode.editor.cn.algorithm.BFS;

import java.util.*;

public class openLock {
    public static void main(String[] args) {
        Solution solution = new openLock().new Solution();
        String[] deadends = new String[]{"8888"};
        String target = "0009";
        System.out.println(solution.openLock(deadends,target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int openLock(String[] deadends, String target) {

            Set<String> set = new HashSet<>(Arrays.asList(deadends));
            String startStr = "0000";

            if (set.contains(startStr)) return -1;

            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            int level = 0;
            queue.offer(startStr);
            visited.add(startStr);

            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    String str = queue.poll();
                    for (int i = 0; i < 4; i++) {
                        char ch = str.charAt(i);
                        String strAdd = str.substring(0, i) + (ch == '9' ? 0 : ch - '0' + 1) + str.substring(i + 1);
                        String strSub = str.substring(0, i) + (ch == '0' ? 9 : ch - '0' - 1) + str.substring(i + 1);
                        if (str.equals(target)) return level;

                        if (!visited.contains(strAdd) && !set.contains(strAdd)) {
                            queue.offer(strAdd);
                            visited.add(strAdd);
                        }
                        if (!visited.contains(strSub) && !set.contains(strSub)) {
                            queue.offer(strSub);
                            visited.add(strSub);
                        }
                    }
                }
                level++;
            }
            return -1;

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
