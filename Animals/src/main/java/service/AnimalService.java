package service;

import exception.AnimalTypeException;
import model.Animal;
import model.AnimalType;
import model.Counter;
import model.packanimal.Camel;
import model.packanimal.Donkey;
import model.packanimal.Horse;
import model.pet.Cat;
import model.pet.Dog;
import model.pet.Hamster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalService {

    private Map<String, Animal> animals = new HashMap<>();
    private Counter counter = new Counter();

    public void addAnimal(Animal animal) {
        if (animals.containsKey(animal.getName())) {
            System.out.println("Животное с именем '" +
                    animal.getName() +
                    "' уже существует.");
            return;
        }
        animals.put(animal.getName(), animal);
        counter.add();
        System.out.println("Добавлено животное:");
        System.out.println(animal);
    }

    public void printCommands(String name) {
        Animal animal = getAnimal(name);
        if (animal != null) {
            System.out.println("Список команд");
            animal.getCommands().forEach(s -> {
                System.out.println("\t" + s);
            });
        }
    }

    private Animal getAnimal(String name) {
        Animal animal = animals.get(name);
        if (animal != null) {
            return animal;
        } else {
            System.out.println("Животного с именем '" +
                    name +
                    "' не существует.");
            return null;
        }
    }

    public Animal getAnimal(String name, String birthday, double weight, AnimalType type) {
        boolean isAge = !birthday.contains(".");
        switch (type) {
            case CAT:
                return isAge ?
                        new Cat(name, Integer.parseInt(birthday), weight, type) :
                        new Cat(name, birthday, weight, type);
            case DOG:
                return isAge ?
                        new Dog(name, Integer.parseInt(birthday), weight, type) :
                        new Dog(name, birthday, weight, type);
            case HAMSTER:
                return isAge ?
                        new Hamster(name, Integer.parseInt(birthday), weight, type) :
                        new Hamster(name, birthday, weight, type);
            case HORSE:
                return isAge ?
                        new Horse(name, Integer.parseInt(birthday), weight, type) :
                        new Horse(name, birthday, weight, type);
            case DONKEY:
                return isAge ?
                        new Donkey(name, Integer.parseInt(birthday), weight, type) :
                        new Donkey(name, birthday, weight, type);
            case CAMEL:
                return isAge ?
                        new Camel(name, Integer.parseInt(birthday), weight, type) :
                        new Camel(name, birthday, weight, type);
            default:
                throw new AnimalTypeException("Не может быть создан тип животного. Его не существует :" + type);
        }
    }

    public void learningCommands(String name, String command) {
        Animal animal = getAnimal(name);
        if (animal != null) {
            animal.learningCommand(command);
        }
    }

    public void printAnimals() {
        System.out.println("Список всех животных");
        animals.forEach((s, animal) -> {
            System.out.println(animal + "\n");
        });
    }
}
