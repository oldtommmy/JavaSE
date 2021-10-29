package com.tommychan.javaselearning.set_;

public class HashMapStructure {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        Node[] table = new Node[10];

        Node john = new Node("john");
        table[2] = new Node("john");

        Node jack = new Node("jack");
        john.next = jack; //将jack结点挂载到john

        Node mary = new Node("mary");
        jack.next = mary;//将mary结点挂载到jack

        //每个table的索引位置都可以形成一条链表
        //当链表元素大于64时 将以树的形式存放
    }
}

class Node{
    Node next;
    Object item;

    public Node(Object item) {
        this.item = item;
    }
}
