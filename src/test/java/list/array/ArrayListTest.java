package list.array;

import list.Test;
import org.junit.After;
import org.junit.Before;

public class ArrayListTest implements Test {
    int ELEMENT_COUNT = 100000;

    ArrayList<Integer> list;
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
        list = new ArrayList<>(100);

        for (int i = 0; i < ELEMENT_COUNT; i++) {
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
            list.get(i);
        }
        System.out.println("GET: " + getTime());
    }

    @Override
    @org.junit.Test
    public void delete() {
        for (int i = ELEMENT_COUNT - 1; i > 0; i--) {
            list.delete(ROUTE == route.START ?
                    0 : i);
        }
        System.out.println("DELETE FROM " + getRoute());
    }
}