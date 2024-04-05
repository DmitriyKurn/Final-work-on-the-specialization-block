package model;

import exception.AgeFormatException;
import exception.BirthdayFormatException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Animal {

    private final int id;
    private String name;
    private LocalDate birthday;
    private int age;
    private double weight;
    private AnimalType animalType;
    protected List<String> commands;

    public Animal(String name, double weight, AnimalType type) {
        this.id = CounterId.getId();
        this.name = name;
        this.weight = weight;
        this.animalType = type;
        generateStandardCommand();
        addNewCommand();
    }

    public Animal(String name, LocalDate birthday, double weight, AnimalType type) {
        this(name, weight, type);
        this.birthday = birthday;
        this.age = getAge(birthday);
    }

    public Animal(String name, String birthday, double weight, AnimalType type) {
        this(name, weight, type);
        this.birthday = getBirthday(birthday);
        this.age = getAge(this.birthday);
    }

    public Animal(String name, int age, double weight, AnimalType type) {
        this(name, weight, type);
        this.birthday = getBirthday(age);
        this.age = age;
    }


    private LocalDate getBirthday(String birthday) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            return LocalDate.parse(birthday, dateTimeFormatter);
        } catch (Exception e) {
            throw new BirthdayFormatException("Неверный формат дня рождения. Необходимо ввести dd.MM.yyyy");
        }
    }

    private int getAge(LocalDate birthday) {
        LocalDate now = LocalDate.now();
        if (now.isBefore(birthday)) {
            throw new BirthdayFormatException("Неверный формат дня рождения. День рождения не может быть позже текущего.");
        }
        return Period.between(birthday, now).getYears();
    }

    private LocalDate getBirthday(int age) {
        if (age < 0) {
            throw new AgeFormatException("Возраст должен быть положительным");
        }
        return LocalDate.now().minusYears(age);
    }

    private void generateStandardCommand() {
        this.commands = new ArrayList<>(Arrays.asList("Бежать", "Прыгать", "Есть", "Пить"));
    }

    public void learningCommand(String command) {
        this.commands.add(command);
        System.out.println("Изучена команда: " + command);
    }

    protected abstract void addNewCommand();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        String result = "Animal {\n" +
                "\tid = " + id + ",\n" +
                "\tname = '" + name + "',\n" +
                "\tbirthday = " + birthday + ",\n" +
                "\tage = " + age + ",\n" +
                "\tweight = " + weight + ",\n" +
                "\tanimalType = " + animalType + ",\n" +
                "\tcommands = [" + System.lineSeparator();
        for (String command : commands) {
            result += "\t\t" + command + "," + System.lineSeparator();
        }
        result += "\t]\n}";
        return result;
    }
}
