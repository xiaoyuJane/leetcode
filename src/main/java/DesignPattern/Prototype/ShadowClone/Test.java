package DesignPattern.Prototype.ShadowClone;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException{
        Map<String,String> map = new HashMap<>(2);
        map.put("key","value");

        RealizeType realizeType = new RealizeType();
        realizeType.setI(10);
        realizeType.setName("prototype class");
        realizeType.setMap(map);
        System.out.println("i am the prototyoe:"+realizeType);  //i am the prototyoe:RealizeType{i=10, name='prototype class', map={key=value}}

        //java的Object类提供类clone()克隆方法，可以让我们非常快速的去实现原型模式
        RealizeType clone = (RealizeType) realizeType.clone();
        clone.setI(20);
        clone.setName("clone class");
        Map<String,String> cloneMap = clone.getMap();
        cloneMap.put("key","value1");
        cloneMap.put("key1","update");
        clone.setMap(cloneMap);

        System.out.println("i am the prototype after clone modify:" +realizeType); //i am the prototype after clone modify:RealizeType{i=10, name='prototype class', map={key1=update, key=value1}}
        System.out.println("i am the clone class:" +clone); //i am the clone class:RealizeType{i=20, name='clone class', map={key1=update, key=value1}}
    }

}
