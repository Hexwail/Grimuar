package com.hexwail.grimuar.client;

import com.hexwail.grimuar.GrimuarMod;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = GrimuarMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class KeyBindings {
    public static final KeyMapping OPEN_SPELL_EDITOR = new KeyMapping(
            "key.grimuar.open_spell_editor",
            GLFW.GLFW_KEY_O,
            "key.categories.inventory"
    );

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(OPEN_SPELL_EDITOR);
    }
}
