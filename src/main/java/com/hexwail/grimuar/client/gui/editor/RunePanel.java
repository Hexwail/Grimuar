package com.hexwail.grimuar.client.gui.editor;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Widget;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

public class RunePanel extends Widget {

    private static final ResourceLocation TEXTURE = new ResourceLocation("grimuar", "textures/gui/rune_panel.png");
    private final Minecraft mc;
    private final int x, y, width, height;

    private final List<Rune> runes = new ArrayList<>();
    private int scrollOffset = 0;
    private int selectedRuneIndex = -1;

    public RunePanel(int x, int y, int width, int height) {
        super(x, y, width, height, Component.literal("Rune Panel"));
        this.mc = Minecraft.getInstance();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        // TODO: завантажити руни для показу
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        RenderSystem.setShaderTexture(0, TEXTURE);
        graphics.blit(TEXTURE, x, y, 0, 0, width, height);

        int runeSize = 20;
        int padding = 4;
        int startX = x + padding;
        int startY = y + padding;

        int index = 0;
        for (Rune rune : runes) {
            int drawX = startX + (index % 4) * (runeSize + padding);
            int drawY = startY + (index / 4) * (runeSize + padding) - scrollOffset;

            if (drawY + runeSize >= y && drawY <= y + height) {
                graphics.blit(rune.getTexture(), drawX, drawY, 0, 0, runeSize, runeSize);

                // Якщо руна вибрана — намалювати рамку
                if (index == selectedRuneIndex) {
                    graphics.fill(drawX - 1, drawY - 1, drawX + runeSize + 1, drawY + runeSize + 1, 0x80FFFFFF);
                }
            }
            index++;
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int runeSize = 20;
        int padding = 4;
        int startX = x + padding;
        int startY = y + padding;

        for (int i = 0; i < runes.size(); i++) {
            int drawX = startX + (i % 4) * (runeSize + padding);
            int drawY = startY + (i / 4) * (runeSize + padding) - scrollOffset;

            if (mouseX >= drawX && mouseX <= drawX + runeSize &&
                mouseY >= drawY && mouseY <= drawY + runeSize) {
                selectedRuneIndex = i;
                // TODO: повідомити редактор про вибір руни
                return true;
            }
        }
        return false;
    }

    public Rune getSelectedRune() {
        if (selectedRuneIndex >= 0 && selectedRuneIndex < runes.size()) {
            return runes.get(selectedRuneIndex);
        }
        return null;
    }

    public void addRune(Rune rune) {
        runes.add(rune);
    }

    public void removeRune(Rune rune) {
        runes.remove(rune);
        if (selectedRuneIndex >= runes.size()) {
            selectedRuneIndex = -1;
        }
    }

    // Клас Rune — той самий, що і раніше
    public static class Rune {
        private final ResourceLocation texture;
        private final String name;

        public Rune(ResourceLocation texture, String name) {
            this.texture = texture;
            this.name = name;
        }

        public ResourceLocation getTexture() {
            return texture;
        }

        public String getName() {
            return name;
        }
    }
}
