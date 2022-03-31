package DesignPattern.State;

/**
 * 状态模式
 * 根据控制事务的状态来帮助对象改变自己的行为
 * 对象在内部状态改变时改变自己的行为
 * 将状态封装成独立的类
 * 将动作为多到代表当前状态的对象
 * 状态模式解决了行为依赖于自己的属性，且行为随着属性的改变而改变
 *
 *
 * 优点： 允许状态转换和行为逻辑合并，且使用不是条件代码块
 * 缺点： 新增状态或者删除状态时可能会破坏开闭原则
 */


//循环输出状态
public class test {
    public static void main(String[] args) {
        Context context = new Context();
        context.say();
        context.say();
        context.say();
        context.say();
        context.say();
        context.say();
    }

}

/*      i am the default state
        i am the hello state
        i am the hi state
        i am the default state
        i am the hello state
        i am the hi state
        */
