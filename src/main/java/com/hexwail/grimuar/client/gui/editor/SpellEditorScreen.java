package com.hexwail.grimuar.client.gui.editor;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class SpellEditorScreen extends Screen {

    private SpellCameraController camera;
    private RunePanel runePanel;

    public SpellEditorScreen() {
        super(Component.literal("Grimuar Spell Editor"));
    }

    @Override
    protected void init() {
        this.camera = new SpellCameraController(minecraft);

        int panelWidth = 100;
        int panelHeight = 80;
        int panelX = this.width - panelWidth - 10;  // правий край з відступом 10
        int panelY = this.height - panelHeight - 10; // нижній край з відступом 10

        this.runePanel = new RunePanel(panelX, panelY, panelWidth, panelHeight);

        // Приклад: додамо кілька "рунів"
        runePanel.addRune(new RunePanel.Rune(new net.minecraft.resources.ResourceLocation("grimuar", "textures/runes/rune_fire.png"), "Fire Rune"));
        runePanel.addRune(new RunePanel.Rune(new net.minecraft.resources.ResourceLocation("grimuar", "textures/runes/rune_water.png"), "Water Rune"));
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        renderBackground(graphics);
        camera.renderCameraView(graphics, partialTicks);
        runePanel.render(graphics, mouseX, mouseY, partialTicks);
        super.render(graphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (runePanel.mouseClicked(mouseX, mouseY, button)) {
            return true;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dx, double dy) {
        return camera.handleMouseDrag(dx, dy) || super.mouseDragged(mouseX, mouseY, button, dx, dy);
    }
}
