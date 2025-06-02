package com.hexwail.grimuar.magic;

public abstract class Rune {
    private final String name;

    public Rune(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Метод активації руни, який треба реалізувати в конкретних рунах
    public abstract void activate();
}
