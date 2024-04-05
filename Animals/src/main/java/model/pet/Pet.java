package model.pet;

import model.Animal;
import model.AnimalType;

import java.time.LocalDate;

public class Pet extends Animal {
    public Pet(String name, double weight, AnimalType type) {
        super(name, weight, type);
    }

    public Pet(String name, LocalDate birthday, double weight, AnimalType type) {
        super(name, birthday, weight, type);
    }

    public Pet(String name, String birthday, double weight, AnimalType type) {
        super(name, birthday, weight, type);
    }

    public Pet(String name, int age, double weight, AnimalType type) {
        super(name, age, weight, type);
    }

    public void stroke(){
        System.out.println("Погладить...");
    }

    @Override
    protected void addNewCommand() {

    }
}
