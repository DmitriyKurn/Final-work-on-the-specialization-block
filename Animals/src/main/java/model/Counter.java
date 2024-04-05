package model;

public class Counter implements AutoCloseable{
    public static int counter = 0;

    public Counter() {
    }

    public void add() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public void close() throws Exception {
        System.out.println("Конец счётчика");
    }
}
