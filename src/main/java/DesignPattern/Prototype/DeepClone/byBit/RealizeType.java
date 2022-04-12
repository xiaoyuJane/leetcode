package DesignPattern.Prototype.DeepClone.byBit;

import java.io.Serializable;
import java.util.HashMap;

public class RealizeType implements Serializable {
    private int i;
    private String name;
    private HashMap<String,String> map;

    @Override
    public String toString() {
        return "RealizeType{" +
                "i=" + i +
                ", name='" + name + '\'' +
                ", map=" + map +
                '}';
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, String> getMap() {
        return map;
    }

    public int getI() {
        return i;
    }

    public String getName() {
        return name;
    }
}
