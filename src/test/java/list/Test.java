package list;

public interface Test {
    enum route { START, END }

    long getTime();

    String getRoute();

    @org.junit.Test
    void setUp();

    @org.junit.Test
    void tearDown();

    @org.junit.Test
    void add();

    @org.junit.Test
    void insert();

    @org.junit.Test
    void get();

    @org.junit.Test
    void delete();
}
