package model.pet;

import model.AnimalType;

import java.time.LocalDate;

public class Cat extends Pet{
    public Cat(String name, double weight, AnimalType type) {
        super(name, weight, type);
    }

    public Cat(String name, LocalDate birthday, double weight, AnimalType type) {
        super(name, birthday, weight, type);
    }

    public Cat(String name, String birthday, double weight, AnimalType type) {
        super(name, birthday, weight, type);
    }

    public Cat(String name, int age, double weight, AnimalType type) {
        super(name, age, weight, type);
    }

    @Override
    protected void addNewCommand(){
        commands.add("Мурчать");
        commands.add("Мяукать");
    }
}
