package TestAndTool.thread;

/**
 * 创建多线程的方法2
 * 1.新建Thread类，将实现了Runnable接口的类作为Thread类的参数，调用Thread.start
 * 2.在实现了Runnable接口的类中override run方法，写明线程要做的操作
 */
public class RunnableTest {
    public static void main(String[] args) {
        Solution solution = new RunnableTest().new Solution();
        RunnableA runnableA = new RunnableTest().new RunnableA();
        RunnableB runnableB = new RunnableTest().new RunnableB();
//        runnableA.run();
//        System.out.println("main");
//        runnableB.run();

        new Thread(runnableA).start();
        System.out.println("main");
        new Thread(runnableB).start();


    }


    class RunnableA implements Runnable{
        @Override
        public void run(){
            System.out.println("task starts:A");
            for (int i = 0; i <100 ; i++) {
                System.out.println("A"+i);
            }
        }
    }

    class RunnableB implements Runnable{
        @Override
        public void run(){
            System.out.println("task starts:B");
            for (int i = 0; i <100 ; i++) {
                System.out.println("B"+i);
            }
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
