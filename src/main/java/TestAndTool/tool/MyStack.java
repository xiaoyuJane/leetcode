package TestAndTool.tool;

import java.util.ArrayList;
import java.util.List;

// "static void main" must be defined in a public class.

public class MyStack {

    //栈的实现比队列容易。动态数组足以实现堆栈结构
    public List<Integer> data;               // store elements

    public MyStack() {
        data = new ArrayList<>();
    }

    /** Insert an element into the stack. */
    public void push(int x) {
        data.add(x);
    }

    /** Checks whether the queue is empty or not. */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /** Get the top item from the queue. */
    public int top() {
        return data.get(data.size() - 1);
    }

    /** Delete an element from the queue. Return true if the operation is successful. */
    public boolean pop() {
        if (isEmpty()) {
            return false;
        }
        data.remove(data.size() - 1);
        return true;
    }
};

