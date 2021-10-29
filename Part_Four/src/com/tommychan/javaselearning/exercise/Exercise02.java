package com.tommychan.javaselearning.exercise;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Exercise02 {
    public static void main(String[] args) {

        HashMap m = new HashMap();
        m.put("jack",650);
        m.put("tom",1200);
        m.put("smith",2900);
        System.out.println(m);

        m.put("jack",2600); //m.replace("jack",2600);

        Set entrySet = m.entrySet();
        for (Object o:entrySet){
            Map.Entry entry = (Map.Entry) o;
            m.put(entry.getKey(),(Integer)entry.getValue()+100);
        }

        System.out.println(m);
    }


}

