package Temperary;

public class MySimpleNode {
    private int value;
    private MySimpleNode next = null;

    public MySimpleNode(int n) {
        value = n;
    }

    public int getValue() {
        return value;
    }

    public MySimpleNode getNext() {
        return next;
    }

    public void setNext(MySimpleNode next) {
        this.next = next;
    }
}
