package com.hexwail.grimuar;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GrimuarMod.MODID)
public class GrimuarMod {
    public static final String MODID = "grimuar";

    public GrimuarMod() {
        // Реєстрація подій та ініціалізація тут
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent event) {
        // Початкова ініціалізація (блоки, предмети, магія тощо)
    }
}
