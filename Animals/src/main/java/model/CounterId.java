package model;

public class CounterId {
    private static int counterId = 0;

    public static int getId() {
        return ++counterId;
    }
}
