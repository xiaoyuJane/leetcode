package leetcode.editor.cn.Stack;

import TestAndTool.tool.MyStack1;

/**
 * 使用自定义的栈库（使用动态数组实现的 ArrayList），学习栈的使用
 * push 入栈
 * top 返回栈顶元素（先要判断栈是否非空）
 * pop 弹出栈顶元素，返回的是true或者false
 * isEmpty方法 判断栈是否非空
 */
public class MystackMain {
    public static void main(String[] args) {
        MyStack1 stack = new MyStack1();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        for (int i=0;i<4;++i){
            if (!stack.isEmpty()){
                System.out.println(stack.top());
            }
            System.out.println(stack.pop());
        }

    }

}
