package model.packanimal;

import model.AnimalType;

import java.time.LocalDate;

public class Camel extends PackAnimal{
    public Camel(String name, double weight, AnimalType type) {
        super(name, weight, type);
    }

    public Camel(String name, LocalDate birthday, double weight, AnimalType type) {
        super(name, birthday, weight, type);
    }

    public Camel(String name, String birthday, double weight, AnimalType type) {
        super(name, birthday, weight, type);
    }

    public Camel(String name, int age, double weight, AnimalType type) {
        super(name, age, weight, type);
    }
}
