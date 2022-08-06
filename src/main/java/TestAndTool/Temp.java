package TestAndTool;

public class Temp {
    public static void main(String[] args) {
        Solution solution = new Temp().new Solution();
        String start ="_L__R__R_";
        String target ="L______RR";
        System.out.println(solution.canChange(start, target));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canChange(String start, String target) {
            if(start.equals(target)) return true;
            boolean res = false;
            int n = start.length();
            for(int i=0;i<n-1;i++){
                StringBuilder sb = new StringBuilder(start);
                if(sb.charAt(i) == '_' && start.charAt(i+1) == 'L') {
                    sb.replace(i,i+2,"L_");
                    if (canChange(sb.toString(),target)){
                        res = true;
                        break;
                    }
                }
                if(sb.charAt(i) == 'R' && start.charAt(i+1) == '_'){
                    sb.replace(i,i+2,"_R");
                    if (canChange(sb.toString(),target)){
                        res = true;
                        break;
                    }
                }
            }
            return res;
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)
}
