package basic.bigDecimal;

import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalDemo {
@Test
 public void test(){
    BigDecimal bigDecimal = new BigDecimal("1.23234");

    //加
    BigDecimal res1 = bigDecimal.add(new BigDecimal("0.11")); //1.34234
   //减
    BigDecimal res2 = bigDecimal.subtract(new BigDecimal("0.11")); //1.12234
   //乘
    BigDecimal res3 = bigDecimal.multiply(new BigDecimal("0.11")); //0.1355574
   //除
    BigDecimal res4 = bigDecimal.divide(new BigDecimal("2")); //0.61617

    System.out.println(res1);
    System.out.println(res2);
    System.out.println(res3);
    System.out.println(res4);
}
}
