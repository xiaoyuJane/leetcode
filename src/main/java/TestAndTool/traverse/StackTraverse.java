package TestAndTool.traverse;

import java.util.Stack;

public class StackTraverse {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        //initial
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        //集合遍历方式
        for (Integer x : stack) {
            System.out.println(x);
        }
        System.out.println("------1-----");
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
