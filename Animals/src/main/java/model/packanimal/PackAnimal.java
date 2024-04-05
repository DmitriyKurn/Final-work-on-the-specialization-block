package model.packanimal;

import model.Animal;
import model.AnimalType;

import java.time.LocalDate;

public class PackAnimal extends Animal {
    private boolean load = false;

    public PackAnimal(String name, double weight, AnimalType type) {
        super(name, weight, type);
    }

    public PackAnimal(String name, LocalDate birthday, double weight, AnimalType type) {
        super(name, birthday, weight, type);
    }

    public PackAnimal(String name, String birthday, double weight, AnimalType type) {
        super(name, birthday, weight, type);
    }

    public PackAnimal(String name, int age, double weight, AnimalType type) {
        super(name, age, weight, type);
    }

    public boolean isLoad() {
        return load;
    }

    public void load() {
        load = true;
    }

    public void unload() {
        load = false;
    }

    @Override
    protected void addNewCommand() {

    }
}
