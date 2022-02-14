package leetcode.editor.cn;

public class TestCase {
    public static void main(String[] args) {
      int n =2;
      int m = 1;
      while (n-- >0){ //n等于自减，但是n--对应的则为自减之前的值
          System.out.println(n);
//          m++;
//          System.out.println(m);
      }
        System.out.println("===========");


      int k=2;
      int j=1;
      while (--k>0){  //k等于自减
          System.out.println(k);
          j++;
          System.out.println(j);
      }


        System.out.println("===========");
      int a=3;
      int b=a--;
      System.out.println(b); //输出3
       System.out.println(a); //输出2

        int c= --a;
        System.out.println(c);
        System.out.println(a);

    }
}
