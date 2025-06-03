package com.hexwail.grimuar.client.gui.editor;

import com.hexwail.grimuar.client.data.RuneTabManager;
import com.hexwail.grimuar.client.data.RuneTab;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Widget;

import java.util.ArrayList;
import java.util.List;

public class RunePanel {

    private final List<RuneTab> runeTabs = new ArrayList<>();
    private int selectedTab = 0;
    private final List<Widget> widgets = new ArrayList<>();
    private boolean inEditMode = false;
    private RuneTab editingTab = null;

    public RunePanel() {
        RuneTabManager.load();
        runeTabs.addAll(RuneTabManager.getTabs());
    }

    public void render(GuiGraphics graphics, int x, int y, int width, int height) {
        // Рендер заголовків вкладок
        for (int i = 0; i < runeTabs.size(); i++) {
            RuneTab tab = runeTabs.get(i);
            graphics.drawString(graphics.getFont(), tab.getName(), x + i * 60, y, i == selectedTab ? 0xFFFFFF : 0xAAAAAA);
        }

        // TODO: Рендер рун у вибраній вкладці
    }

    public void openTabEditor(boolean isNew) {
        inEditMode = true;
        if (isNew) {
            editingTab = new RuneTab("Нова вкладка");
        } else {
            editingTab = runeTabs.get(selectedTab);
        }
        // TODO: GUI для редагування
    }

    public void saveEditingTab() {
        if (editingTab != null) {
            if (!runeTabs.contains(editingTab)) {
                RuneTabManager.addTab(editingTab);
                runeTabs.add(editingTab);
            } else {
                RuneTabManager.updateTab(editingTab);
            }
        }
        inEditMode = false;
    }

    public void deleteCurrentTab() {
        if (selectedTab >= 0 && selectedTab < runeTabs.size()) {
            RuneTab tab = runeTabs.get(selectedTab);
            RuneTabManager.removeTab(tab);
            runeTabs.remove(tab);
            selectedTab = Math.max(0, selectedTab - 1);
        }
    }

    public void tick() {
        // Якщо потрібен оновлюваний інтерфейс
    }
}
