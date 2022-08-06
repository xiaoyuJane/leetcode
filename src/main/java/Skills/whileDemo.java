package Skills;

public class whileDemo {
    public static void main(String[] args) {
        /**
         * 1.先执行i=0
         * 2.判断i<4
         * 3.1 步骤2为true则执行 System.out.println(i)
         * 4 执行i++，改变循环遍历的值
         * 3.2 步骤2为false 退出循环
         */
        for (int i = 0; i < 4; i++) {
            System.out.println(i);
        }

        /**
         * i=0,打印0，执行++i,i为1
         * i=1 打印1，执行++i,i为2
         * i=2 打印2，执行++i,i为3
         * i=3 打印3，执行++i,i为4
         * i=4 不满足条件i<4,直接退出循环
         */
    }
}
