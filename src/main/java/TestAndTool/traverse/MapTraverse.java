package TestAndTool.traverse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTraverse {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");

        //1.simple traverse
        for (Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }


        //2.before java5
        System.out.println("----1----");
        for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, String> entry = it.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("----2----");
        for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
            String key = it.next();
            System.out.println(key + " = " + map.get(key));
        }
    }
}
