package com.declan.rebuildSomeCollection;

import java.util.HashMap;

public class MyHashSet {

    HashMap map;
    private static final Object PRESENT = new Object();

    public MyHashSet() {
        map = new HashMap();
    }

    public int size() {
        return map.size();
    }

    public void add(Object o) {
        map.put(o, PRESENT);    //Use Map's character to avoid the same input
    }

    public static void main(String[] args) {
        MyHashSet s = new MyHashSet();
        s.add("aaa");
        s.add(new String("aaa"));
        System.out.println(s.size());
    }
}
