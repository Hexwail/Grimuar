package com.hexwail.grimuar.client;

import com.hexwail.grimuar.menu.SpellEditorMenu;
import com.hexwail.grimuar.init.ModMenuTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.hexwail.grimuar.GrimuarMod;
import net.minecraftforge.network.NetworkHooks;

@Mod.EventBusSubscriber(modid = GrimuarMod.MODID)
public class KeyInputHandler {

    @SubscribeEvent
    public static void onKeyPress(InputEvent.Key event) {
        if (KeyBindings.OPEN_SPELL_EDITOR.isDown()) {
            Minecraft mc = Minecraft.getInstance();
            if (mc.player != null && mc.level != null) {
                NetworkHooks.openScreen(
                    (net.minecraft.server.level.ServerPlayer) mc.player,
                    new SpellEditorProvider(),
                    buf -> {}
                );
            }
        }
    }
}
