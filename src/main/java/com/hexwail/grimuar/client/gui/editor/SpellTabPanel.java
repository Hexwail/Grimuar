package com.hexwail.grimuar.client.gui.editor;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class SpellTabPanel {

    private static final int TAB_HEIGHT = 24;
    private static final int TAB_WIDTH = 140;
    private static final int ICON_SIZE = 16;
    private static final int ICON_PADDING = 4;

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

    /**
     * Додає вкладку з назвою та іконкою
     */
    public void addTab(String title, ResourceLocation icon) {
        tabs.add(new Tab(Component.literal(title), icon));
    }

    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        // Фон панелі
        graphics.fill(x, y + TAB_HEIGHT, x + width, y + height, 0xFF202020);

        for (int i = 0; i < tabs.size(); i++) {
            int tabX = x + i * TAB_WIDTH;
            int tabY = y;

            int color = (i == activeTabIndex) ? 0xFF404040 : 0xFF303030;
            graphics.fill(tabX, tabY, tabX + TAB_WIDTH, tabY + TAB_HEIGHT, color);

            Tab tab = tabs.get(i);

            // Малюємо іконку, якщо вона є
            if (tab.icon != null) {
                graphics.pose().pushPose();
                graphics.pose().translate(0, 0, 200); // щоб малювалося поверх
                RenderSystem.setShaderTexture(0, tab.icon);
                graphics.blit(tabX + ICON_PADDING, tabY + (TAB_HEIGHT - ICON_SIZE) / 2, 0, 0, ICON_SIZE, ICON_SIZE, ICON_SIZE, ICON_SIZE);
                graphics.pose().popPose();
            }

            // Текст з відступом праворуч від іконки
            int textX = tabX + ICON_PADDING * 2 + ICON_SIZE;
            int textWidth = mc.font.width(tab.title);
            int textY = tabY + (TAB_HEIGHT - 8) / 2;

            graphics.drawString(mc.font, tab.title, textX, textY, 0xFFFFFFFF, false);
        }

        // Вміст активної вкладки
        if (!tabs.isEmpty()) {
            int contentX = x + 5;
            int contentY = y + TAB_HEIGHT + 5;

            graphics.drawString(mc.font,
                Component.literal("Вміст вкладки: " + tabs.get(activeTabIndex).title.getString()),
                contentX, contentY, 0xFFFFFF, false);
        }
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button != 0) return false;

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
        final ResourceLocation icon;

        Tab(Component title, ResourceLocation icon) {
            this.title = title;
            this.icon = icon;
        }
    }
}
