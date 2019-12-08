package list;

public interface List<E> {
    String LENGTH_EXCEPTION = "List length (%s) is less than the specified index: %s";
    String CAPACITY_EXCEPTION = "Illegal capacity: %s";

    Object get(int index);

    void add(E element);

    void insert(int index, E element);

    int getCount();

    String toString();
}