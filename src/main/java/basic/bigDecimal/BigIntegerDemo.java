package basic.bigDecimal;

import org.junit.Test;

import java.math.BigInteger;

public class BigIntegerDemo {
  @Test
    public void testRadix(){
      String str = "1011100111";
      int radix = 2;
      //把radix进制的字符串转化为BigInteger
      BigInteger interNum1 = new BigInteger(str,radix);	//二进制的str转换为BigInteger
      System.out.println(interNum1); //743

    //我们通常不写，则是默认成10进制转换
    BigInteger bigInteger = new BigInteger(str);
    System.out.println(bigInteger); //1011100111

  }

  @Test
  public void testBasic(){
    BigInteger a = new BigInteger("13");
    BigInteger b = new BigInteger("4");
    int n = 3;

    //1.加
    BigInteger bigNum1 = a.add(b);			//17
    System.out.println(bigNum1);
    //2.减
    BigInteger bigNum2 = a.subtract(b);		//9
    System.out.println(bigNum2);
    //3.乘
    BigInteger bigNum3 = a.multiply(b);		//52
    System.out.println(bigNum3);
    //4.除
    BigInteger bigNum4 = a.divide(b);		//3
    System.out.println(bigNum4);

    //5.取模(需 b > 0，否则出现异常：ArithmeticException("BigInteger: modulus not positive"))
    BigInteger bigNum5 = a.mod(b);			//1
    System.out.println(bigNum5);

    //6.求余
    BigInteger bigNum6 = a.remainder(b);	//1
    System.out.println(bigNum6);

    //7.平方(需 n >= 0，否则出现异常：ArithmeticException("Negative exponent"))
    BigInteger bigNum7 = a.pow(n);			//2197
    System.out.println(bigNum7);

    //8.取绝对值
    BigInteger bigNum8 = a.abs();			//13
    System.out.println(bigNum8);

    //9.取相反数
    BigInteger bigNum9 = a.negate();		//-13
    System.out.println(bigNum9);
  }

  @Test
  public void testCompare(){
    BigInteger bigNum1 = new BigInteger("52");
    BigInteger bigNum2 = new BigInteger("27");

    //1.compareTo()：返回一个int型数据（1 大于； 0 等于； -1 小于）
    int num = bigNum1.compareTo(bigNum2);			//1

    //2.max()：直接返回大的那个数，类型为BigInteger
    //	原理：return (compareTo(val) > 0 ? this : val);
    BigInteger compareMax = bigNum1.max(bigNum2);	//52

    //3.min()：直接返回小的那个数，类型为BigInteger
    //	原理：return (compareTo(val) < 0 ? this : val);
    BigInteger compareMin = bigNum1.min(bigNum2);	//27

  }
}
