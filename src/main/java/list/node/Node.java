package list.node;

public class Node<E> {
    private E item;
    private Node<E> prev;
    private Node<E> next;

    public Node() {
        this.item = null;
        this.prev = null;
        this.next = null;
    }

    public Node(E element) {
        this.item = element;
        this.prev = null;
        this.next = null;
    }

    public Node(Node<E> prev, E element, Node<E> next) {
        this.item = element;
        this.prev = prev;
        this.next = next;
    }

    public boolean hasPrev() {
        return prev != null;
    }

    public boolean hasNext() {
        return next != null;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}