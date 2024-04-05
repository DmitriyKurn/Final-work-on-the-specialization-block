package model.pet;

import model.AnimalType;

import java.time.LocalDate;

public class Dog extends Pet{
    public Dog(String name, double weight, AnimalType type) {
        super(name, weight, type);
    }

    public Dog(String name, LocalDate birthday, double weight, AnimalType type) {
        super(name, birthday, weight, type);
    }

    public Dog(String name, String birthday, double weight, AnimalType type) {
        super(name, birthday, weight, type);
    }

    public Dog(String name, int age, double weight, AnimalType type) {
        super(name, age, weight, type);
    }

    @Override
    protected void addNewCommand(){
        commands.add("Лаять");
        commands.add("Сидеть");
        commands.add("Лежать");
    }
}
