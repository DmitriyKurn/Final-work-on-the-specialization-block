package model.packanimal;

import model.AnimalType;

import java.time.LocalDate;

public class Donkey extends PackAnimal{
    public Donkey(String name, double weight, AnimalType type) {
        super(name, weight, type);
    }

    public Donkey(String name, LocalDate birthday, double weight, AnimalType type) {
        super(name, birthday, weight, type);
    }

    public Donkey(String name, String birthday, double weight, AnimalType type) {
        super(name, birthday, weight, type);
    }

    public Donkey(String name, int age, double weight, AnimalType type) {
        super(name, age, weight, type);
    }
}
