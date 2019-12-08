package list.node;

import list.List;

import java.util.Arrays;

public class LinkedList<E> implements List<E> {

    Node<E> head;
    int count;

    public LinkedList(E element) {
        head = new Node<>(element);
    }

    @Override
    public Node<E> get(int index) {
        if (index > getCount()) {
            throw new IndexOutOfBoundsException(String.format(LENGTH_EXCEPTION, getCount(), index));
        }

        Node<E> node = head;
        while (index-- > 0) {
            node = node.getNext();
        }
        return node;
    }

    @Override
    public void add(E element) {
        Node<E> node = head;
        while (node.hasNext()) {
            node = node.getNext();
        }
        node.setNext(new Node<>(node, element, null));
        count++;
    }

    @Override
    public void insert(int index, E element) {
        if (index == 0) {
            head.setPrev(new Node<>(null, element, head));
            head = head.getPrev();
            count++;
        }
        else if (index <= getCount()) {
            Node<E> node = head;
            while (--index > 0) {
                node = node.getNext();
            }
            node.setNext(new Node<>(node, element, node.getNext()));
            count++;
        }
        else {
            throw new IndexOutOfBoundsException(String.format(LENGTH_EXCEPTION, getCount()));
        }
    }

    public void delete(E element) {
        Node<E> node = head;
        if (node.getItem().equals(element)) {
            if (head.hasNext()) {
                head = head.getNext();
                head.setPrev(null);
                count--;
            }
        }
        else {
            while (node.hasNext()) {
                node = node.getNext();
                if (node.getItem().equals(element)) {
                    node.getPrev().setNext(node.getNext());
                    if (node.hasNext()) {
                        node.getNext().setPrev(node.getPrev());
                    }
                    count--;
                }
            }
        }
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        int[] result = new int[getCount()];
        int index = 0;
        Node<E> node = head;

        while (node != null) {
            result[index++] = (Integer) node.getItem();
            node = node.getNext();
        }
        return Arrays.toString(result);
    }
}