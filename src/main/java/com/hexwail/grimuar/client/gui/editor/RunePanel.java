package com.hexwail.grimuar.client.gui.editor;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

public class RunePanel implements GuiEventListener {

    private final int x, y, width, height;
    private final List<Rune> runes = new ArrayList<>();
    private int selectedIndex = -1;

    private static final int RUNE_SIZE = 16;
    private static final int RUNE_PADDING = 4;

    public RunePanel(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void addRune(Rune rune) {
        runes.add(rune);
    }

    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        // фон панелі
        graphics.fill(x, y, x + width, y + height, 0x90000000);

        // малюємо руни по рядках (горизонтально)
        int currentX = x + RUNE_PADDING;
        int currentY = y + RUNE_PADDING;

        for (int i = 0; i < runes.size(); i++) {
            Rune rune = runes.get(i);
            boolean hovered = mouseX >= currentX && mouseX < currentX + RUNE_SIZE && mouseY >= currentY && mouseY < currentY + RUNE_SIZE;
            if (i == selectedIndex) {
                // рамка вибраної руни
                graphics.fill(currentX - 2, currentY - 2, currentX + RUNE_SIZE + 2, currentY + RUNE_SIZE + 2, 0xAAFFFF00);
            } else if (hovered) {
                graphics.fill(currentX - 2, currentY - 2, currentX + RUNE_SIZE + 2, currentY + RUNE_SIZE + 2, 0x55FFFFFF);
            }

            g
