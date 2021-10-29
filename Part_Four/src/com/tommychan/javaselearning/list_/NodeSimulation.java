package com.tommychan.javaselearning.list_;

public class NodeSimulation {
    public static void main(String[] args) {

        Node tommy = new Node("Tommy");
        Node jack = new Node("Jack");
        Node qian = new Node("Qian");

        tommy.next = jack;
        jack.next = qian;
        qian.pre = jack;
        jack.pre = tommy;

        Node first = tommy;
        Node last = qian;

        while (true){
            if (first==null){
                break;
            }
            System.out.println(first);
            first = first.next;
        }

        while (true){
            if (last==null){
                break;
            }
            System.out.println(last);
            last = last.pre;
        }
    }
}

class Node{

    public Object item;
    public Node next;
    public Node pre;

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Name:"+item;
    }
}
