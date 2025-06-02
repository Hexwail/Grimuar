package com.hexwail.grimuar.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModLoader {

    public static void init() {
        // Підписуємо події клавіш на головний івент-бус
        MinecraftForge.EVENT_BUS.register(KeyBindings.class);
        MinecraftForge.EVENT_BUS.register(KeyInputHandler.class);

        // Також можна підписати RegisterKeyMappingsEvent (не обов’язково тут)
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientModLoader::onClientSetup);
    }

    private static void onClientSetup(final FMLClientSetupEvent event) {
        // Якщо треба щось ще на клієнті
    }
}
