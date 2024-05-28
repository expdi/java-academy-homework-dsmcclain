package dev.dylan.adoption.domain;

public enum AnimalType {
    CAT,
    DOG,
    TURTLE;

    public String toString() {
        String str = name();
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
