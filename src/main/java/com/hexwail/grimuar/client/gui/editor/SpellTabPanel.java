package com.hexwail.grimuar.client.gui.editor;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

public class SpellTabPanel {

    private List<SpellTab> tabs = new ArrayList<>();
    private SpellTab currentTab;

    public SpellTabPanel() {
        initTabs();
    }

    private void initTabs() {
        // Створюємо вкладку "Всі", яка містить усі збережені закляття
        SpellTab allSpellsTab = new SpellTab("Всі");
        // Додаємо всі закляття в вкладку "Всі"
        allSpellsTab.addSpells(loadAllSavedSpells());

        tabs.add(allSpellsTab);
        currentTab = allSpellsTab;
    }

    private List<Spell> loadAllSavedSpells() {
        // Псевдо-код: заміни на свій метод завантаження всіх заклять
        List<Spell> allSpells = new ArrayList<>();
        // allSpells.add(...);
        // ...
        return allSpells;
    }

    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        // Відмалювати вкладки
        for (SpellTab tab : tabs) {
            tab.renderTabButton(graphics);
        }

        // Відмалювати вміст поточної вкладки
        if (currentTab != null) {
            currentTab.renderContent(graphics);
        }
    }

    public void selectTab(SpellTab tab) {
        currentTab = tab;
    }

    // Методи для додавання нових вкладок, редагування, видалення (крім "Всі") і т.д.
}
