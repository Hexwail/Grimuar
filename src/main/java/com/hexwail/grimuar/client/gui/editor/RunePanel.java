package com.hexwail.grimuar.client.gui.editor;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

public class RunePanel {

    private List<RuneTab> tabs = new ArrayList<>();
    private RuneTab currentTab;

    public RunePanel() {
        initTabs();
    }

    private void initTabs() {
        // Створюємо вкладку "Всі", яка містить усі відомі руни
        RuneTab allRunesTab = new RuneTab("Всі");
        // Тут треба додати всі руни до allRunesTab
        allRunesTab.addRunes(loadAllKnownRunes());

        tabs.add(allRunesTab);
        currentTab = allRunesTab;
    }

    private List<Rune> loadAllKnownRunes() {
        // Псевдо-код: заміни на свій метод завантаження всіх рун
        List<Rune> allRunes = new ArrayList<>();
        // allRunes.add(...);
        // ...
        return allRunes;
    }

    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        // Відмалювати вкладки
        for (RuneTab tab : tabs) {
            tab.renderTabButton(graphics);
        }

        // Відмалювати вміст поточної вкладки
        if (currentTab != null) {
            currentTab.renderContent(graphics);
        }
    }

    public void selectTab(RuneTab tab) {
        currentTab = tab;
    }

    // Методи для додавання нових вкладок, видалення (окрім "Всі") і т.д.
}
