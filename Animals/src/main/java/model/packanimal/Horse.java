package model.packanimal;

import model.AnimalType;

import java.time.LocalDate;

public class Horse extends PackAnimal {
    public Horse(String name, double weight, AnimalType type) {
        super(name, weight, type);
    }

    public Horse(String name, LocalDate birthday, double weight, AnimalType type) {
        super(name, birthday, weight, type);
    }

    public Horse(String name, String birthday, double weight, AnimalType type) {
        super(name, birthday, weight, type);
    }

    public Horse(String name, int age, double weight, AnimalType type) {
        super(name, age, weight, type);
    }

    @Override
    protected void addNewCommand() {
        commands.add("Оседлать");
    }
}
