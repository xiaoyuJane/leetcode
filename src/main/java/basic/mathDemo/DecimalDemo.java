package basic.mathDemo;

import java.text.DecimalFormat;

public class DecimalDemo {
    public static void main(String[] args) {
        double d = 10/ 3.0;
        System.out.println(d); //3.3333333333333335

        DecimalFormat decimalFormat = new DecimalFormat(".00");
        DecimalFormat decimalFormat1 = new DecimalFormat(".###");
        String format = decimalFormat.format(d);
        System.out.println(format); //3.33
        System.out.println(decimalFormat1.format(d)); //3.333
    }
}
