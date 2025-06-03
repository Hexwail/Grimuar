package com.hexwail.grimuar.client.gui.editor;

import java.util.ArrayList;
import java.util.List;

public class RuneTab {
    private String name;
    private List<String> runes;

    public RuneTab(String name) {
        this.name = name;
        this.runes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getRunes() {
        return runes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRunes(List<String> runes) {
        this.runes = runes;
    }

    public void addRune(String runeId) {
        if (!runes.contains(runeId)) {
            runes.add(runeId);
        }
    }

    public void removeRune(String runeId) {
        runes.remove(runeId);
    }

    public boolean contains(String runeId) {
        return runes.contains(runeId);
    }
}
