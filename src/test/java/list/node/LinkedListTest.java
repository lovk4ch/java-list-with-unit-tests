package list.node;

import list.Test;
import org.junit.After;
import org.junit.Before;

public class LinkedListTest implements Test {
    int ELEMENT_COUNT = 20000;

    LinkedList<Integer> list;
    long time;
    route ROUTE;

    @Override
    public long getTime() {
        long result = System.currentTimeMillis() - time;
        time = System.currentTimeMillis();
        return result;
    }

    @Override
    public String getRoute() {
        return ROUTE + ": " + getTime();
    }

    @Override
    @Before
    public void setUp() {
        ROUTE = route.START;
        list = new LinkedList<>(0);

        for (int i = 1; i < ELEMENT_COUNT; i++) {
            list.add(i);
        }
        time = System.currentTimeMillis();
    }

    @Override
    @After
    public void tearDown() {
        list = null;
    }

    @Override
    @org.junit.Test
    public void add() {
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            list.add(i);
        }
        System.out.println("ADD: " + getTime());
    }

    @Override
    @org.junit.Test
    public void insert() {
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            list.insert(ROUTE == route.START ?
                    0 : list.getCount() - 1, 0);
        }
        System.out.println("INSERT TO " + getRoute());
    }

    @Override
    @org.junit.Test
    public void get() {
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            list.get(ROUTE == route.START ?
                    0 : i);
        }
        System.out.println("GET FROM: " + getRoute());
    }

    @Override
    @org.junit.Test
    public void delete() {
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            list.delete(ROUTE == route.START ?
                    i : ELEMENT_COUNT - i - 1);
        }
        System.out.println("DELETE FROM " + getRoute());
    }
}