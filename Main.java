package org.example;


import org.example.models.AnimalRegistryService;
import org.example.presenter.AnimalPresenter;
import org.example.viewer.AnimalNurseryView;

import java.util.Scanner;

public class Main {
    public Main(){
    }

    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Реестр домашних животных");
        AnimalRegistryService animalRegistryService = new AnimalRegistryService();
        AnimalNurseryView animalNurseryView = new AnimalNurseryView();
        new AnimalPresenter(animalRegistryService,animalNurseryView);
        boolean obs = true;
        while (obs){
            System.out.println("""
                    Что хотите
                    1 - Завести новое животное
                    2 - Определить животное в правильный класс
                    3 - Увидеть список команд, которое выполняет животное
                    4 - Обучить животное новым командам
                    5 - Выйти
                    """);
            String choice = console.nextLine();
            String name_animal = null;
            String birthday = null;
            double weight = 0;
            String type_animal = null;
            String new_skill = null;
            switch (choice){
                case "1" -> {
                    System.out.println("Для этого вам необоходимо ввести " +
                            "имя животного дату его рождения " +
                            "вес животного в также а также род животного ");
                    System.out.println("Введите имя животного: ");
                    name_animal = console.nextLine();
                    try {
                        System.out.println("Введите дату рождения животного в формате (2024-01-01): ");
                        if(console.nextLine().length() == 10){
                            birthday = console.nextLine();
                            System.out.println("Введите вес животного: ");
                            weight = Double.parseDouble(console.nextLine());
                            System.out.println("Введите вид животного (Собака Кошка Хомяк Лошадь Верблюд Осёл): ");
                            type_animal = console.nextLine();
                        }
                        else {
                            System.out.println("Вы ввели не коректные данные повторите ввод");
                        }


                    }
                    catch (Exception e){
                        System.out.println("Данные введеные не верно");
                    }
                    finally {
                        System.out.println("Повторите ввод");
                    }


                    animalNurseryView.getanimla(name_animal,birthday,weight,type_animal);


                }
                case "2" -> {

                    System.out.println("Введите имя животного чьи способности Вас интересуют");
                    name_animal = console.nextLine();
                    try {
                        animalRegistryService.get_command_animal(name_animal);
                    }
                    finally {
                        System.out.println("К сожалению в нашем питомнике нет токого животного");
                    }


                }
                case "3" -> {
                    System.out.println("Введите имя животного кого хотите обучить");
                    name_animal = console.nextLine();
                    System.out.println("Введите команду которой нужну обучить животное");
                    new_skill = console.nextLine();
                    try {
                        animalRegistryService.learn_command_animal(name_animal,new_skill);
                    }
                    finally {
                        System.out.println("К сожалению в нашем питомнике нет токого животного");
                    }

                }
                case "4" -> {
                        animalNurseryView.loadAnimals();
                }
                case "5" -> {
                    String by = "До свидания";
                    System.out.println("\n" + by.toUpperCase());
                    obs = false;
                }



            }

        }

    }


}




public class Animal {

    private String name;

    private int age;



    public Animal(String name, int age) {

        this.name = name;

        this.age = age;

    }



    public void learnCommand(String command) {

        System.out.println(this.name + " learned command: " + command);

    }



    public void showCommands() {

        System.out.println(this.name + " can perform the following commands: ");

        // вывод списка команд

    }

}



public class DomesticAnimal extends Animal {

    public DomesticAnimal(String name, int age) {

        super(name, age);

    }

    // дополнительные поля и методы для домашних животных

}



public class LivestockAnimal extends Animal {

    public LivestockAnimal(String name, int age) {

        super(name, age);

    }

    // дополнительные поля и методы для вьючных животных

}



import java.util.ArrayList;

import java.util.List;



public class PetRegistry {

    private List<Animal> animals;



    public PetRegistry() {

        this.animals = new ArrayList<>();

    }



    public void addAnimal(Animal animal) {

        this.animals.add(animal);

        System.out.println("Added new animal: " + animal.getName());

    }



    public void classifyAnimal(Animal animal) {

        if (animal instanceof DomesticAnimal) {

            System.out.println(animal.getName() + " is a domestic animal.");

        } else if (animal instanceof LivestockAnimal) {

            System.out.println(animal.getName() + " is a livestock animal.");

        }

    }



    public void teachCommand(Animal animal, String command) {

        animal.learnCommand(command);

    }



    public void displayMenu() {

        System.out.println("Menu:");

        System.out.println("1. Add new animal");

        System.out.println("2. Classify animal");

        System.out.println("3. Show list of commands for animal");

        System.out.println("4. Teach new command to animal");

        // Добавить другие пункты меню

    }

}



public class Main {

    public static void main(String[] args) {

        PetRegistry registry = new PetRegistry();

        

        DomesticAnimal dog = new DomesticAnimal("Dog", 5);

        registry.addAnimal(dog);

        

        registry.classifyAnimal(dog);

        

        registry.teachCommand(dog, "Sit");

        dog.showCommands();

        

        registry.displayMenu();

    }

}