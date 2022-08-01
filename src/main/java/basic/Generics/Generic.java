package basic.Generics;

/**
 * 泛型类
 * @param <T> 类型参数化
 *           可以操作不同的数据类型，做了代码的复用
 */
public class Generic<T> {
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
