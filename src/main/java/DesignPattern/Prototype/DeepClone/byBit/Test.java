package DesignPattern.Prototype.DeepClone.byBit;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) throws Exception{
        HashMap<String,String> map = new HashMap<>(2);
        map.put("key","value");

        RealizeType realizeType = new RealizeType();
        realizeType.setI(10);
        realizeType.setName("prototype class");
        realizeType.setMap(map);
        System.out.println("i am the prototyoe:"+realizeType);  //{i=10, name='prototype class', map={key=value}}


        byte[] bytes;
        try (ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(byteOut)) {
                out.writeObject(realizeType);
                bytes = byteOut.toByteArray();
            }
        try (ByteArrayInputStream byteIn = new ByteArrayInputStream(bytes);
             ObjectInputStream in = new ObjectInputStream(byteIn)){
            RealizeType clone = (RealizeType) in.readObject();

            clone.setI(20);
            clone.setName("clone class");
            HashMap<String,String> cloneMap = clone.getMap();
            cloneMap.put("key","value1");
            cloneMap.put("key1","update");
            clone.setMap(cloneMap);

            System.out.println("i am the prototype after clone modify:" +realizeType); //{i=10, name='prototype class', map={key=value}}
            System.out.println("i am the clone class:" +clone); //{i=20, name='clone class', map={key1=update, key=value1}}


        }
    }

}
