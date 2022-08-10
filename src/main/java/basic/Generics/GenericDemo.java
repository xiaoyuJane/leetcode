package basic.Generics;

public class GenericDemo {
    public static void main(String[] args) {
        //泛型类在创建对象时，指定具体的参数类型
        Generic<String> stringGeneric = new Generic<>("aa");
        String key = stringGeneric.getKey();
        System.out.println(key); //aa
        System.out.println(stringGeneric); //Generic{key=aa}


        Generic<Integer> stringGeneric1 = new Generic<>(11);
        Integer k = stringGeneric1.getKey();
        System.out.println(k); //11
        System.out.println(stringGeneric1); //Generic{key=11}

        //未指定类型时，按照Object类型来操作
        Generic stringGeneric2 = new Generic(11);
        Object key1 = stringGeneric2.getKey();
        System.out.println(key1); //11

        print(1,2,3);
        print("a","b");


    }

    public static <E> void print(E ... e){
        for (E el:e) System.out.println(el);
    }
}

/**
 *
 * @param <T> 由外部定义的时候指定
 */
class Generic<T> {
    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Generic{" +
                "key=" + key +
                '}';
    }
}