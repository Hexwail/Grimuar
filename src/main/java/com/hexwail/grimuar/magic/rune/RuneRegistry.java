package com.hexwail.grimuar.magic.rune;

import java.util.ArrayList;
import java.util.List;

public class RuneRegistry {

    public static final List<RuneDefinition> RUNES = new ArrayList<>();

    public static final RuneDefinition SPLIT = register(new RuneDefinition("split", "Розділення на складові"));
    public static final RuneDefinition STABILIZE = register(new RuneDefinition("stabilize", "Стабілізація речовини"));
    public static final RuneDefinition TRAJECTORY = register(new RuneDefinition("trajectory", "Задання траєкторії"));
    public static final RuneDefinition MIX = register(new RuneDefinition("mix", "Змішування речовин"));
    public static final RuneDefinition MANIPULATE = register(new RuneDefinition("manipulate", "Маніпуляція речовинами"));

    public static final RuneDefinition HEAT = register(new RuneDefinition("heat", "Нагрів"));
    public static final RuneDefinition COOL = register(new RuneDefinition("cool", "Охолодження"));

    public static final RuneDefinition IGNITE = register(new RuneDefinition("ignite", "Іскра / Підпал"));
    public static final RuneDefinition REACT = register(new RuneDefinition("react", "Хімічна реакція"));

    private static RuneDefinition register(RuneDefinition rune) {
        RUNES.add(rune);
        return rune;
    }

    public static void init() {
        // Ініціалізація, якщо потрібно викликати десь при запуску мода
    }
}
