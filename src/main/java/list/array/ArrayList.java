package list.array;

import list.List;

import java.util.Arrays;

public class ArrayList<E> implements List {

    private final int DEFAULT_CAPACITY = 1;

    Object[] array;
    int volume;
    int CURRENT_CAPACITY;

    public ArrayList() {
        this.array = new Object[DEFAULT_CAPACITY];
        CURRENT_CAPACITY = DEFAULT_CAPACITY;
    }

    public ArrayList(int capacity) {
        if (capacity > 0) {
            this.array = new Object[capacity];
            CURRENT_CAPACITY = capacity;
        } else if (capacity == 0) {
            this.array = new Object[DEFAULT_CAPACITY];
            CURRENT_CAPACITY = DEFAULT_CAPACITY;
        } else {
            throw new IllegalArgumentException(String.format(CAPACITY_EXCEPTION, capacity));
        }
    }

    private void increase() {
        CURRENT_CAPACITY *= 2;
        array = Arrays.copyOf(array, CURRENT_CAPACITY);
    }

    private void decrease() {
        CURRENT_CAPACITY /= 2;
        array = Arrays.copyOf(array, CURRENT_CAPACITY);
    }

    private void checkIndex(int index) {
        if (index > volume - 1) {
            throw new IndexOutOfBoundsException(String.format(LENGTH_EXCEPTION, getCount(), index));
        }
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void add(Object element) {
        if (volume == CURRENT_CAPACITY) {
            increase();
        }
        array[volume++] = element;
    }

    @Override
    public void insert(int index, Object element) {
        checkIndex(index);
        if (volume == CURRENT_CAPACITY) {
            increase();
        }
        for (int i = volume; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
    }

    public void delete(int index) {
        checkIndex(index);

        for (int i = index; i < volume - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--volume] = null;
        if (volume <= CURRENT_CAPACITY / 2) {
            decrease();
        }
    }

    @Override
    public int getCount() {
        return volume;
    }

    public int getCapacity() {
        return CURRENT_CAPACITY;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, CURRENT_CAPACITY));
    }
}