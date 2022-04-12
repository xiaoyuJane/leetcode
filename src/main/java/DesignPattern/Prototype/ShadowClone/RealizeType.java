package DesignPattern.Prototype.ShadowClone;

import java.util.Map;

//实现类实现Cloneable接口，就可以在对象中调用clone方法实现浅克隆
public class RealizeType implements Cloneable{
    private int i;
    private String name;
    private Map<String,String> map;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "RealizeType{" +
                "i=" + i +
                ", name='" + name + '\'' +
                ", map=" + map +
                '}';
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
