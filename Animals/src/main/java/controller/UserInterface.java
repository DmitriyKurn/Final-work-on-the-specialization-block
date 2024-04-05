package controller;

import model.Animal;
import model.AnimalType;
import service.AnimalService;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);
    private AnimalService animalService = new AnimalService();
    private boolean doing = true;

    public void process() {
        while (doing) {
            printHelp();
            try {
                int command = Integer.parseInt(scanner.nextLine());
                switch (command) {
                    case 1:
                        addAnimal();
                        break;
                    case 2:
                        getAnimalCommands();
                        break;
                    case 3:
                        learningCommand();
                        break;
                    case 4:
                        printAnimals();
                        break;
                    case 5:
                        exit();
                        break;
                    default:
                        System.out.println("Указаны неверные параметры\n");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printHelp() {
        System.out.println("\t\tВыберите действие:");
        System.out.println("1 - Добавить новое животное");
        System.out.println("2 - Просмотреть список доступных команд для животных");
        System.out.println("3 - Обучить животное новым командам");
        System.out.println("4 - Просмотреть список всех животных в питомнике");
        System.out.println("5 - Выйти");
    }

    private void printType() {
        System.out.println("Введите род животного:");
        System.out.println("\t1-Кошка");
        System.out.println("\t2-Собака");
        System.out.println("\t3-Хомяк");
        System.out.println("\t4-Лошадь");
        System.out.println("\t5-Осёл");
        System.out.println("\t6-Верблюд");
    }

    private void addAnimal() throws Exception {
        System.out.println("Необходимо ввести:");
        System.out.println("\t- имя животного,");
        System.out.println("\t- дату его рождения (в формате 01.01.2024) или возраст");
        System.out.println("\t- вес животного,");
        System.out.println("\t- род животного (Кошка, Собака, Хомяк, Лошадь, Верблюд, Осёл).");
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения животного в формате 01.01.2024 или возраст: ");
        String birthday = scanner.nextLine();
        System.out.println("Введите вес животного:");
        double weight = Double.parseDouble(scanner.nextLine());
        printType();
        AnimalType type = scanner.hasNextInt() ?
                AnimalType.getType(Integer.parseInt(scanner.nextLine())) :
                AnimalType.getType(scanner.nextLine());
        Animal animal = animalService.getAnimal(name, birthday, weight, type);
        animalService.addAnimal(animal);
    }

    private void getAnimalCommands() {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();
        animalService.printCommands(name);
    }

    private void learningCommand() {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();
        System.out.println("Введите команду, которой нужно обучить");
        String command = scanner.nextLine();
        animalService.learningCommands(name, command);
    }

    private void printAnimals() {
        animalService.printAnimals();
    }

    private void exit() {
        System.out.println("Пока...");
        doing = false;
    }

}
