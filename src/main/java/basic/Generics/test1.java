package basic.Generics;

import java.util.ArrayList;

public class test1 {
    public static void main(String[] args) {
        //泛型类在创建对象时，指定具体的参数类型
        Generic<String> stringGeneric = new Generic<>("aa");
        String key = stringGeneric.getKey();  //stringGeneric.getKey().var
        System.out.println(stringGeneric);


    }
}
