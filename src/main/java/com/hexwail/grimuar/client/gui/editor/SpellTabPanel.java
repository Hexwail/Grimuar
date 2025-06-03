package com.hexwail.grimuar.client.gui.editor;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.List;

public class SpellTabPanel {

    private static final int TAB_HEIGHT = 20;
    private static final int TAB_WIDTH = 100;

    private final Minecraft mc;
    private final int x, y, width, height;

    private final List<Tab> tabs = new ArrayList<>();
    private int activeTabIndex = 0;

    public SpellTabPanel(Minecraft mc, int x, int y, int width, int height) {
        this.mc = mc;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void addTab(String title) {
        tabs.add(new Tab(Component.literal(title)));
    }

    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        // Фон панелі
        graphics.fill(x, y + TAB_HEIGHT, x + width, y + height, 0xFF202020);

        // Відмалювати вкладки зверху
        for (int i = 0; i < tabs.size(); i++) {
            int tabX = x + i * TAB_WIDTH;
            int tabY = y;

            // Колір вкладки: активна - світліша, неактивна - темніша
            int color = (i == activeTabIndex) ? 0xFF404040 : 0xFF303030;

            graphics.fill(tabX, tabY, tabX + TAB_WIDTH, tabY + TAB_HEIGHT, color);

            // Назва вкладки (по центру)
            int textWidth = mc.font.width(tabs.get(i).title);
            int textX = tabX + (TAB_WIDTH - textWidth) / 2;
            int textY = tabY + (TAB_HEIGHT - 8) / 2; // 8 - висота тексту приблизно

            graphics.drawString(mc.font, tabs.get(i).title, textX, textY, 0xFFFFFFFF, false);
        }

        // Вміст активної вкладки (зараз просто текст)
        if (!tabs.isEmpty()) {
            int contentX = x + 5;
            int contentY = y + TAB_HEIGHT + 5;

            graphics.drawString(mc.font, Component.literal("Вміст вкладки: " + tabs.get(activeTabIndex).title.getString()),
                contentX, contentY, 0xFFFFFF, false);
        }
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button != 0) return false; // Реагуємо лише на ліву кнопку

        if (mouseY >= y && mouseY < y + TAB_HEIGHT && mouseX >= x && mouseX < x + width) {
            int tabIndex = (int) ((mouseX - x) / TAB_WIDTH);
            if (tabIndex >= 0 && tabIndex < tabs.size()) {
                activeTabIndex = tabIndex;
                return true;
            }
        }

        return false;
    }

    private static class Tab {
        final Component title;

        Tab(Component title) {
            this.title = title;
        }
    }

}
