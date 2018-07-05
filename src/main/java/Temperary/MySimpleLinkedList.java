package Temperary;

import java.util.LinkedList;

public class MySimpleLinkedList {
    private LinkedList<MySimpleNode> list = new LinkedList<MySimpleNode>();
    

    public void initList(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            list.addLast(new MySimpleNode(arr[i]));
        }
    }

    public void addFirst(MySimpleNode node) {
        list.addFirst(node);
    }

    public void addLast(MySimpleNode node) {
        list.addLast(node);
    }

    public MySimpleNode getFirst() {
        return list.getFirst();

    }

    public MySimpleNode remove(int index) {
        return list.remove(index);
    }

    public MySimpleNode get(int index) {
        return list.get(index);
    }
}
