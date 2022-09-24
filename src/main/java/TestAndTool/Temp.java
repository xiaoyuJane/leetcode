package TestAndTool;

import org.junit.Test;

public class Temp {

    @Test
    //求和的经典操作：
    // 1. 定义基本sum = 0
    // 2. 先取低位值相加，即sum = sum + num%10
    // 3. num右移动，即 num = num/10
    public void getSum (){
        int num = 1234;
        int sum = 0;
        while (num !=0){
            sum += num%10;
            num /=10;
        }
        System.out.println(sum);

    }
}
