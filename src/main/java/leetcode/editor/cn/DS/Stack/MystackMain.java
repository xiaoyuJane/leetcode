package leetcode.editor.cn.DS.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用自定义的栈库（使用动态数组实现的 ArrayList），学习栈的使用
 * 1.push 入栈
 * 2.top 返回栈顶元素（先要判断栈是否非空）
 * 3.pop 弹出栈顶元素，返回的是true或者false
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
            System.out.println(stack.pop()); //栈空返回false
        }

    }

}

class MyStack1 {

    //栈的实现比队列容易。动态数组足以实现堆栈结构
    public List<Integer> data;               // store elements

    public MyStack1() {
        data = new ArrayList<>();
    }

    /** 添加元素. */
    public void push(int x) {
        data.add(x);
    }

    /** 判空 */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /** 栈顶在数组的最后一个元素位置 */
    public int top() {
        return data.get(data.size() - 1);
    }

    /** 弹出栈中的元素
     * 如果栈为空，返回为false
     * 否则弹出元素，返回为true
     * */
    public boolean pop() {
        if (isEmpty()) {
            return false;
        }
        data.remove(data.size() - 1);
        return true;
    }
};

