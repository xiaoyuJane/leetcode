package basic.mathDemo;

public class MathDemo {
    public static void main(String[] args) {
        double abs = Math.abs(-2.12);
        int max = Math.max(1, 2);
        int min = Math.min(1, 2);
        double pow = Math.pow(2.0, 3.0);
        long round = Math.round(2.611);
        double sqrt = Math.sqrt(4);

        System.out.println(abs); //绝对值 2.12
        System.out.println(max); //最大值 2
        System.out.println(min); //最小值 1
        System.out.println(pow); //2的3次方 8
        System.out.println(round); //四舍五入 3
        System.out.println(sqrt); //平方根 2
    }
}
