package leetcode.editor.cn;

public class TestCase {
    public static void main(String[] args) {
        int n=1;
        /*while (n-->0){
            System.out.println("a");
        }*/

        int a=0;
        while (n-->0){
            a++;
        }

        int head =2;
        int step = 1;
        while (--step >0){
            head = head-1;
        }

        System.out.println(head);
    }
}
