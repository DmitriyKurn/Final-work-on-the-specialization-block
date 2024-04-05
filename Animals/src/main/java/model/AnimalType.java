package model;

import exception.AnimalTypeException;

import java.util.Arrays;
import java.util.Locale;

public enum AnimalType {
    CAT(1, "кошка"),
    DOG(2, "собака"),
    HAMSTER(3, "хомяк"),
    HORSE(4, "лошадь"),
    DONKEY(5, "осел"),
    CAMEL(6, "верблюд");

    int typeIndex;
    String typeText;

    AnimalType(int typeIndex, String typeText) {
        this.typeIndex = typeIndex;
        this.typeText = typeText;
    }

    public int getTypeIndex() {
        return typeIndex;
    }

    public void setTypeIndex(int typeIndex) {
        this.typeIndex = typeIndex;
    }

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }

    public static AnimalType getType(int typeIndex) {
        Object[] result = Arrays.stream(AnimalType.values())
                .filter(type -> type.getTypeIndex() == typeIndex)
                .toArray();
        if (result.length == 0) {
            throw new AnimalTypeException("Не найден тип животного");
        }
        return (AnimalType) result[0];
    }

    public static AnimalType getType(String typeText) {
        Object[] result = Arrays.stream(AnimalType.values())
                .filter(type -> type.getTypeText().equals(typeText.toLowerCase(Locale.ROOT)))
                .toArray();
        if (result.length == 0) {
            throw new AnimalTypeException("Не найден тип животного");
        }
        return (AnimalType) result[0];
    }
}
