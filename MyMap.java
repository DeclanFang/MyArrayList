package com.declan.rebuildSomeCollection;

/**
 * Build Map Container
 * @author Declan
 */

public class MyMap {
    MyLinkedList[] arr = new MyLinkedList[999];

    public void put(Object key, Object value) {
        MyEntry e = new MyEntry(key, value);

        int hash = key.hashCode();
        hash = hash < 0 ? - hash : hash;
        int a = hash % arr.length;
        if(arr[a] == null) {
            MyLinkedList list = new MyLinkedList();
            arr[a] = list;
            list.add(e);
        }
        else {
            MyLinkedList list = arr[a];
            for(int i = 0; i < list.size(); i ++) {
                MyEntry e2 = (MyEntry) list.get(i);
                if(e2.key.equals(key)) {
                    e2.value = value;
                    return;
                }
            }
            arr[a].add(e);
        }
    }

    public Object get(Object key) {
        int a = key.hashCode() % arr.length;
        if(arr[a] != null) {
            MyLinkedList list = arr[a];
            for(int i = 0; i < list.size(); i ++) {
                MyEntry e = (MyEntry) list.get(i);
                if(e.key.equals(key)) {
                    return e.value;
                }
            }
        }
        return null;
    }

    public boolean containsKey(Object key) {
        int a = key.hashCode() % arr.length;
        if(arr[a] != null) {
            MyLinkedList list = arr[a];
            for(int i = 0; i < list.size(); i ++) {
                MyEntry e = (MyEntry) list.get(i);
                if(e.key.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MyMap m = new MyMap();
        m.put("Declan", "Author");
        m.put("Declan", "Pet");
        System.out.println(m.get("Declan"));
    }
}

class MyEntry {
    Object key;
    Object value;

    public MyEntry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}