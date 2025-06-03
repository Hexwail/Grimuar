package com.hexwail.grimuar.client.gui.editor;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.Button;

import java.util.ArrayList;
import java.util.List;

public class SpellTabPanel {

    private final int x, y, width, height;
    private final List<SpellTab> tabs = new ArrayList<>();
    private int selectedIndex = -1;

    public SpellTabPanel(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void addTab(SpellTab tab) {
        tabs.add(tab);
        if (selectedIndex == -1) {
            selectedIndex = 0;
        }
    }

    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        // фон панелі
        graphics.fill(x, y, x + width, y + height, 0x90000000);

        int tabWidth = width / Math.max(tabs.size(), 1);
        for (int i = 0; i < tabs.size(); i++) {
            SpellTab tab = tabs.get(i);
            int tabX = x + i * tabWidth;
            boolean hovered = mouseX >= tabX && mouseX < tabX + tabWidth && mouseY >= y && mouseY < y + 20;

            int bgColor = (i == selectedIndex) ? 0xAAFFFF00 : (hovered ? 0x55FFFFFF : 0x44000000);
            graphics.fill(tabX, y, tabX + tabWidth, y + 20, bgColor);

            graphics.drawString(Minecraft.getInstance().font, Component.literal(tab.name), tabX + 5, y + 6, 0xFFFFFF);
        }
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button != 0) return false; // ліва кнопка миші

        int tabWidth = width / Math.max(tabs.size(), 1);
        for (int i = 0; i < tabs.size(); i++) {
            int tabX = x + i * tabWidth;
            if (mouseX >= tabX && mouseX < tabX + tabWidth && mouseY >= y && mouseY < y + 20) {
                selectedIndex = i;
                return true;
            }
        }
        return false;
    }

    public SpellTab getSelectedTab() {
        if (selectedIndex < 0 || selectedIndex >= tabs.size()) return null;
        return tabs.get(selectedIndex);
    }

    public static class SpellTab {
        public final String name;
        public final SpellData spellData; // твої дані заклять, можна реалізувати окремо

        public SpellTab(String name, SpellData spellData) {
            this.name = name;
            this.spellData = spellData;
        }
    }

    public static class SpellData {
        // Тут буде структура для збереження заклять,
        // поки що пусто або базові поля
    }
}
