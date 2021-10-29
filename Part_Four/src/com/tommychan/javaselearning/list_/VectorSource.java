package com.tommychan.javaselearning.list_;

import java.util.Iterator;
import java.util.Vector;

public class VectorSource {
    public static void main(String[] args) {

        Vector vector = new Vector();
        for (int i = 0; i < 10; i++) {
            vector.add("hello"+i);
        }

        Iterator iterator = vector.iterator();
        for (Object obj:vector) {
            System.out.println(obj);
        }
    }
}
