package leetcode.editor.cn.Stack;

import java.util.Stack;

/**
 * 使用内置的栈库，学习栈的使用
 */
public class StackMain {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(13);
        stack.push(8);
        stack.push(6);

        if (stack.empty()){
            System.out.println("Stack is empty!");
            return;
        }

        stack.pop();
        System.out.println("The top element is:" + stack.peek());
        System.out.println("The size is :" + stack.size());
    }


}
