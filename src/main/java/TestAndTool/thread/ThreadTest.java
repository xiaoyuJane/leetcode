package TestAndTool.thread;

/**
 * 多线程，
 * 1.首先定义threadA 继承于Thread
 * 2.重写thread中的run方法.start()
 * 3.在main方法中new threadA，并调用thread
 */
public class ThreadTest {
    public static void main(String[] args) {
        Solution solution = new ThreadTest().new Solution();
        ThreadA threadA = new ThreadTest().new ThreadA();
        ThreadB threadB = new ThreadTest().new ThreadB();
        threadA.start();
        System.out.println(Thread.currentThread().getName());
        threadB.start();
    }


    /**
     * 创建一个 Thread 类的实例，即为创建了一个处于初始状态的线程。
     * 对一个处于初始状态的线程调用方法 start，该线程被启动，进入运行状态。
     * 调用方法 start 之后，方法 run 会自动执行。
     */
    class ThreadA extends Thread{
        @Override
        public void run(){
            currentThread().setName("threadA");
            System.out.println(currentThread().getName() + "...");
            for (int i = 0; i < 100 ; i++) {
                System.out.println(currentThread().getName() + i);
            }
        }
    }

    class ThreadB extends Thread{
        @Override
        public void run(){
            currentThread().setName("threadB");
            System.out.println(currentThread().getName() + "...");
            for (int i = 0; i < 100 ; i++) {
                System.out.println(currentThread().getName() +i);
            }
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

    }
//leetcode submit region begin(Prohibit modification and deletion)
}
