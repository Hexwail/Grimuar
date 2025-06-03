package com.hexwail.grimuar.client.gui.editor;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class SpellEditorScreen extends Screen {

    private SpellCameraController camera;

    public SpellEditorScreen() {
        super(Component.literal("Grimuar Spell Editor"));
    }

    @Override
    protected void init() {
        this.camera = new SpellCameraController(minecraft);
        // TODO: ініціалізація вкладок, рун, збережених заклять
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        renderBackground(graphics);
        camera.renderCameraView(graphics, partialTicks);
        // TODO: відображення панелей
        super.render(graphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dx, double dy) {
        return camera.handleMouseDrag(dx, dy);
    }
}
