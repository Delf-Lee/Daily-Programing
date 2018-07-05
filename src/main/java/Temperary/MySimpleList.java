package Temperary;

public class MySimpleList {
    private MySimpleNode head = null;
    private MySimpleNode tail;
    private int size = 0;

    public void initList(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            addTail(new MySimpleNode(arr[i]));
        }
    }

    public MySimpleList(MySimpleNode node) {
        head = node;
    }

    public MySimpleList() {
    }

    public MySimpleNode addTail(MySimpleNode node) {
        if (head == null) {
            head = node;
        } else {
            tail.setNext(node);
        }
        size++;
        tail = node;
        return head;
    }

    public MySimpleNode addHead(MySimpleNode node) {
        MySimpleNode tmp = head;
        head = node;
        node.setNext(tmp);
        size++;
        return tail;
    }

    public MySimpleNode getHead() {
        return head;
    }

    public void showList() {
        if (head == null) {
            return;
        }
        MySimpleNode node = head;
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
}
