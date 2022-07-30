package basic.FunctionInterface;

import java.util.Map;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        boolean b = checkString("张三", s -> s.equals("张三"));
        System.out.println(b);  //true

        boolean b1 = checkStringN("张三", s -> s.equals("张三"));
        System.out.println(b1);  //false

        boolean hello = checkString("hello", s -> s.length() > 4, s -> s.length() < 6);
        System.out.println(hello); //true
    }

    public static boolean checkString(String s, Predicate<String> pre){
        return pre.test(s);
    }

    public static boolean checkStringN(String s, Predicate<String> pre){
        return pre.negate().test(s);
        /**
         * pre.negate() : return (t) -> !test(t)
         */
    }
    public static boolean checkString(String s, Predicate<String> pre, Predicate<String> pre1){
        return pre.and(pre1).test(s);
    }

}
