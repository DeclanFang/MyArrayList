package com.declan.rebuildSomeCollection;

/**
 * Try to rebuild Class LindedList in JDK
 * @author Declan
 */

public class MyLinkedList {
    private Node first;
    private Node last;

    private int size;

    public void add(Object obj) {
        Node n = new Node();
        if(first == null) {
            n.setPrevious(null);
            n.setObj(obj);
            n.setNext(null);

            first = n;
            last = n;
        }
        else {
            //add new node after last (one node contains three elements: previous, obj, next)
            n.setPrevious(last);
            n.setObj(obj);
            n.setNext(null);
            //combine the new node with the present last one
            last.setNext(n);

            last = n;
        }
        size ++;
    }

    public int size() {
        return size;
    }

    public void rangeCheck(int index) {
        if(index < 0 || index > size - 1) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Object get(int index) {
        rangeCheck(index);
        Node temp = node(index);
        if(temp != null) {
            return temp.obj;
        }
        return null;
    }

    public Node node(int index) {
        Node temp = null;
        if(first != null) {
            temp = first;
            for(int i = 0; i < index; i ++) {
                temp = temp.next;
            }
        }
        return temp;
    }

    public void remove(int index) {
        rangeCheck(index);
        Node temp = node(index);
        if(temp != null) {
            Node up = temp.previous;
            Node down = temp.next;
            up.next = down;
            down.previous = up;
        }

        size --;
    }

    public void add(int index, Object obj) {
        rangeCheck(index);
        Node temp = node(index);

        Node newNode = new Node();
        newNode.obj = obj;

        if(temp != null) {
            Node up = temp.previous;

            up.next = newNode;
            newNode.previous = up;

            newNode.next = temp;
            temp.previous = newNode;

            size ++;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add(1, "ddd");
        System.out.println(list.get(0));
    }
}