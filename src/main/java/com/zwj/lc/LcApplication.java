package com.zwj.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class LcApplication {

    public static void main(String[] args) {
        SpringApplication.run(LcApplication.class, args);
//        System.out.println(12/10);
//        System.out.println(19/10);
//        System.out.println(12%10);
//        System.out.println(19%10);

        HashMap<Character,Integer> map = new HashMap<>();
        map.put('a',1);
        map.put('a',2);
        System.out.println(map.get('a'));
        System.out.println(map.getOrDefault('b',0));


    }

}
