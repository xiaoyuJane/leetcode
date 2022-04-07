package DesignPattern.Prototype.DeepClone.byShadow;

import java.util.HashMap;

public class RealizeType implements Cloneable{
   private int i;
   private String name;
   private HashMap<String,String> map;


   //modify clone to be deep clone
    @Override
    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
        RealizeType clone = (RealizeType)super.clone();
        clone.map = (HashMap<String,String>) this.map.clone();
        return clone;
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

    public HashMap<String, String> getMap() {
        return map;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }
}
