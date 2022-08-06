package basic.random;

import org.junit.Test;

import java.util.Random;

public class RandomDemo {

    @Test
    public  void test1(){
        Random random = new Random(); //以当前时间毫秒值作为种子，创建Random对象
        for (int j = 0; j < 3; j++) {
            int i = random.nextInt();  //生成1个int类型范围的随机数
            System.out.println(i);
            /**
             * 1125754168
             * -2023672089
             * -254734720
             */
        }
    }

    @Test
    public  void test2(){
        Random random = new Random(1); //以指定种子创建Random对象
        for (int j = 0; j < 3; j++) {
//            int i = random.nextInt(10);  //产生1个[0,n-1]范围内的随机数
            double i = Math.random() * 10; //生成0~n之间的数
            System.out.println(i);
            /**
             0.9020555464951507
             9.348556046964383
             4.990992202334558
             */
        }
    }

    @Test
    public void test3(){
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int i1 = 1 + (int) (Math.random() * (10)); //生成1到10之间的随机数
            int i2 = random.nextInt(10) + 1; //生成1到10之间的随机数
            System.out.println("i1:"+i1);
            System.out.println("i2:--"+i2);

        }
    }
}
