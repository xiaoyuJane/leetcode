package basic.operators;

//https://cloud.tencent.com/developer/article/1338265
public class operatorTest {
    public static void main(String[] args) {
        operatorTest.BitAnd();
        System.out.println("=============================");
        operatorTest.logicAnd();
        System.out.println("=============================");
        operatorTest.BitOr();
        System.out.println("=============================");
        operatorTest.xor();
        System.out.println("=============================");
        operatorTest.lshift();
        System.out.println("=============================");
        operatorTest.rshift();
        System.out.println("=============================");
        operatorTest.bit_negative();
        System.out.println("=============================");
        operatorTest.unsigned_rshift();
    }


    /* ^异或运算符顾名思义，异就是不同，相同为0，不同为1
     其运算规则为1^0 = 1 , 1^1 = 0 , 0^1 = 1 , 0^0 = 0  */
    private static void xor(){
        int x = 3;
        int y = 5;
        System.out.println("x:"+Integer.toBinaryString(x));
        System.out.println("y:"+Integer.toBinaryString(y));
        System.out.println("x^y = "+ Integer.toBinaryString(x^y));
        System.out.println(x^y);
    }

    /* &按位与的运算规则是将两边的数转换为二进制位，
     然后运算最终值，运算规则即(两个为真才为真)1&1=1 , 1&0=0 , 0&1=0 , 0&0=0  */
    private static void BitAnd(){
        int x = 3;
        int y = 5;
        System.out.println("x:"+Integer.toBinaryString(x));
        System.out.println("y:"+Integer.toBinaryString(y));
        System.out.println("x&y = "+ (x&y));
    }


    /* &按位或的运算规则是将两边的数转换为二进制位，
     然后运算最终值，运算规则即(两个为真才为真)1|1=1 , 1|0=1 , 0|1=1 , 0|0=0 */
    private static void BitOr(){
        int x = 3;
        int y = 5;
        System.out.println("x:"+Integer.toBinaryString(x));
        System.out.println("y:"+Integer.toBinaryString(y));
        System.out.println("x|y = "+ Integer.toBinaryString(x|y));
        System.out.println(x|y);
    }

    /* 逻辑或||的运算规则是一个为真即为真，后续不再计算，一个为假再计算右边的表达式。*/
    private static void logicOr(){
        if (5>3 ||3>5) System.out.println("true");
    }


    /* &&逻辑与也称为短路逻辑与，
     先运算&&左边的表达式，一旦为假，后续不管多少表达式，均不再计算，一个为真，再计算右边的表达式，两个为真才为真。*/
    private static void logicAnd(){
        String str = null;
        if (str != null && (100/0 ==0)){ //left is false
            System.out.println("&& left is false ,right is not to be calculate");
        }else {
            System.out.println("100/0 if to be calculate then can thrown error");
        }
    }

    /*左移 5 << 3：5的二进制位往左挪:3位，右边补0，
    值等于乘于2的n次方
    * 正数左边第一位补0，负数左边第一位补1  */
    private static void lshift(){
        int x = 3;
        int y = 5;
        System.out.println("3:"+Integer.toBinaryString(x));
        System.out.println("5:"+Integer.toBinaryString(y));
        System.out.println("5 << 3 = "+ Integer.toBinaryString(y<<x)); //  5*2^3=40
        System.out.println(y<<x);
    }

    /*右移 5 << 3：5的二进制位往右挪:3位，
    值等于除于2的n次方，
     * 正数左边第一位补0，负数左边第一位补1  */
    private static void rshift(){
        int x = 3;
        int y = 5;
        System.out.println("3:"+Integer.toBinaryString(x));
        System.out.println("5:"+Integer.toBinaryString(y));
        System.out.println("5 >> 3 = "+ Integer.toBinaryString(y>>x)); //  5/8=0
        System.out.println(y>>x);
    }

   /* 取反就是1为0,0为1,
   5的二进制位是0000 0101，取反后为1111 1010，值为-6*/
    private static void bit_negative(){
        int y = 5;
        System.out.println("5:"+Integer.toBinaryString(y)); //5:101
        System.out.println("~5 = "+ Integer.toBinaryString(~5)); //  ~5 = 11111111111111111111111111111010
        System.out.println(~5); //  -6
    }

   /* 无符号右移运算符和右移运算符的主要区别在于负数的计算，因为无符号右移是高位补0，移多少位补多少个0。
      15的二进制位是0000 1111 ， 右移2位0000 0011，结果为3*/
    private static void unsigned_rshift(){
        int y = 15;
        System.out.println("5:"+Integer.toBinaryString(y)); //5:1111
        System.out.println("15 >>> 2 = "+ Integer.toBinaryString(15 >>> 2)); //11
        System.out.println(15 >>> 2); //3

        System.out.println("-6:"+Integer.toBinaryString(-6));                //11111111111111111111111111111010;
        System.out.println("-6 >>> 3 = "+ Integer.toBinaryString(-6 >>> 3)); //00011111111111111111111111111111
        System.out.println(-6 >>> 3); //536870911 总是得到一个正数


    }

}
