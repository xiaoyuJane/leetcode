package Skills;

public class AddDemo {
    public static void main(String[] args) {
        int i = 900;
        i = i+100;
        System.out.println(i);
    }
}

/*
字节码分析：
int i = 900;
int i = i + 100;
System.out.println(i);

等号是赋值语句
 */