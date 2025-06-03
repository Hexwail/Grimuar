package com.hexwail.grimuar.client.gui.editor;

import java.util.ArrayList;
import java.util.List;

public class SpellTab {
    private String name;
    private List<String> spells;

    public SpellTab(String name) {
        this.name = name;
        this.spells = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getSpells() {
        return spells;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpells(List<String> spells) {
        this.spells = spells;
    }

    public void addSpell(String spellId) {
        if (!spells.contains(spellId)) {
            spells.add(spellId);
        }
    }

    public void removeSpell(String spellId) {
        spells.remove(spellId);
    }

    public boolean contains(String spellId) {
        return spells.contains(spellId);
    }
}
