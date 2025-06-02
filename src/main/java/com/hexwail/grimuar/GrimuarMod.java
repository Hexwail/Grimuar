package com.hexwail.grimuar;

import com.hexwail.grimuar.init.MenuInit;
import com.hexwail.grimuar.init.GrimuarScreens;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod("grimuar")
public class GrimuarMod {

    public GrimuarMod() {
        MenuInit.MENUS.register(FMLJavaModLoadingContext.get().getModEventBus());

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        GrimuarScreens.registerScreens(event);
    }
}
