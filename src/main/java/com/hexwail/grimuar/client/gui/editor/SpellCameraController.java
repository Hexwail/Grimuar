package com.hexwail.grimuar.client.gui.editor;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Camera;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

public class SpellCameraController {

    private final Minecraft mc;
    private float yaw = 0;
    private float pitch = 20;
    private float distance = 4;

    public SpellCameraController(Minecraft mc) {
        this.mc = mc;
    }

    public void renderCameraView(GuiGraphics graphics, float partialTicks) {
        if (mc.player == null || mc.level == null) return;

        Vec3 playerPos = mc.player.getEyePosition(partialTicks);
        double yawRad = Math.toRadians(yaw);
        double pitchRad = Math.toRadians(pitch);

        double dx = -distance * Math.cos(pitchRad) * Math.sin(yawRad);
        double dy = -distance * Math.sin(pitchRad);
        double dz = distance * Math.cos(pitchRad) * Math.cos(yawRad);

        Vec3 camPos = playerPos.add(dx, dy, dz);

        // TODO: додати перевірку проходження крізь блоки

        mc.gameRenderer.setRenderHand(false);
        Camera camera = mc.gameRenderer.getMainCamera();
        camera.setPosition(camPos.x, camPos.y, camPos.z);
        camera.setRotation((float) pitch, (float) yaw);
    }

    public boolean handleMouseDrag(double dx, double dy) {
        yaw -= dx * 0.3f;
        pitch = Mth.clamp(pitch - (float) dy * 0.3f, -80f, 80f);
        return true;
    }
}
