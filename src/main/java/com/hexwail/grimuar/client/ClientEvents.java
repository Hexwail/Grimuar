package com.hexwail.grimuar.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

import com.hexwail.grimuar.client.gui.editor.SpellEditorScreen;

@Mod.EventBusSubscriber(modid = "grimuar", value = net.minecraftforge.api.distmarker.Dist.CLIENT)
public class ClientEvents {

    public static final KeyMapping OPEN_EDITOR_KEY = new KeyMapping(
            "key.grimuar.open_editor",  // локалізована назва
            GLFW.GLFW_KEY_R,            // клавіша R
            "key.categories.grimuar"    // категорія клавіш
    );

    public static void registerKeybinds() {
        ClientRegistry.registerKeyBinding(OPEN_EDITOR_KEY);
    }

    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        if (OPEN_EDITOR_KEY.isDown()) {
            Minecraft.getInstance().setScreen(new SpellEditorScreen());
        }
    }
}
