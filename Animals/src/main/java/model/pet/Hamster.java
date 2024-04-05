package model.pet;

import model.AnimalType;

import java.time.LocalDate;

public class Hamster extends Pet {
    public Hamster(String name, double weight, AnimalType type) {
        super(name, weight, type);
    }

    public Hamster(String name, LocalDate birthday, double weight, AnimalType type) {
        super(name, birthday, weight, type);
    }

    public Hamster(String name, String birthday, double weight, AnimalType type) {
        super(name, birthday, weight, type);
    }

    public Hamster(String name, int age, double weight, AnimalType type) {
        super(name, age, weight, type);
    }

}
