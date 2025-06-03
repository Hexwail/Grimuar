package com.hexwail.grimuar.client.gui.editor;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

public class SpellEditorScreen extends Screen {

    private SpellCameraController camera;

    private RunePanel runePanel;
    private SpellTabPanel spellTabPanel;

    public SpellEditorScreen() {
        super(Component.literal("Grimuar Spell Editor"));
    }

    @Override
    protected void init() {
        this.camera = new SpellCameraController(minecraft);

        // Ініціалізація RunePanel — знизу (ширина 300, висота 100)
        this.runePanel = new RunePanel(this.width / 2 - 150, this.height - 110, 300, 100);

        // Ініціалізація SpellTabPanel — зверху (ширина 400, висота 40)
        this.spellTabPanel = new SpellTabPanel(this.width / 2 - 200, 20, 400, 40);

        // Додаємо тестові вкладки
        this.spellTabPanel.addTab(new SpellTabPanel.SpellTab("Закляття 1", new SpellTabPanel.SpellData()));
        this.spellTabPanel.addTab(new SpellTabPanel.SpellTab("Закляття 2", new SpellTabPanel.SpellData()));
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        renderBackground(graphics);
        camera.renderCameraView(graphics, partialTicks);

        // Рендер панелей
        spellTabPanel.render(graphics, mouseX, mouseY, partialTicks);
        runePanel.render(graphics, mouseX, mouseY, partialTicks);

        super.render(graphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        // Перевіряємо кліки по панелях
        if (spellTabPanel.mouseClicked(mouseX, mouseY, button)) return true;
        if (runePanel.mouseClicked(mouseX, mouseY, button)) return true;

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dx, double dy) {
        return camera.handleMouseDrag(dx, dy);
    }
}
