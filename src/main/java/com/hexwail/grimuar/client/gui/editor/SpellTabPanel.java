package com.hexwail.grimuar.client.gui.editor;

import com.hexwail.grimuar.client.data.SpellTab;
import com.hexwail.grimuar.client.data.SpellTabManager;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Widget;

import java.util.ArrayList;
import java.util.List;

public class SpellTabPanel {

    private final List<SpellTab> spellTabs = new ArrayList<>();
    private int selectedTab = 0;
    private final List<Widget> widgets = new ArrayList<>();
    private boolean inEditMode = false;
    private SpellTab editingTab = null;

    public SpellTabPanel() {
        SpellTabManager.load(); // Завантаження вкладок для поточного світу
        spellTabs.addAll(SpellTabManager.getTabs());
    }

    public void render(GuiGraphics graphics, int x, int y, int width, int height) {
        // Відображення заголовків вкладок
        for (int i = 0; i < spellTabs.size(); i++) {
            SpellTab tab = spellTabs.get(i);
            graphics.drawString(graphics.getFont(), tab.getName(), x + i * 60, y, i == selectedTab ? 0xFFFFFF : 0xAAAAAA);
        }

        // TODO: Відображення вмісту поточної вкладки (закляття)
    }

    public void openTabEditor(boolean isNew) {
        inEditMode = true;
        if (isNew) {
            editingTab = new SpellTab("Нова вкладка");
        } else {
            editingTab = spellTabs.get(selectedTab);
        }
        // TODO: GUI для редагування: вибір заклять із вкладки "всі", підсвічування обраних
    }

    public void saveEditingTab() {
        if (editingTab != null) {
            if (!spellTabs.contains(editingTab)) {
                SpellTabManager.addTab(editingTab);
                spellTabs.add(editingTab);
            } else {
                SpellTabManager.updateTab(editingTab);
            }
        }
        inEditMode = false;
    }

    public void deleteCurrentTab() {
        if (selectedTab >= 0 && selectedTab < spellTabs.size()) {
            SpellTab tab = spellTabs.get(selectedTab);
            SpellTabManager.removeTab(tab);
            spellTabs.remove(tab);
            selectedTab = Math.max(0, selectedTab - 1);
        }
    }

    public void tick() {
        // Якщо треба оновлення
    }
}
