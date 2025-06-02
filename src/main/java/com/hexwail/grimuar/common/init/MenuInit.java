package com.hexwail.grimuar.common.init;

import com.hexwail.grimuar.GrimuarMod;
import com.hexwail.grimuar.common.menu.SpellEditorMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod.EventBusSubscriber(modid = GrimuarMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MenuInit {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, GrimuarMod.MODID);

    public static final RegistryObject<MenuType<SpellEditorMenu>> SPELL_EDITOR_MENU =
            MENUS.register("spell_editor_menu", () -> new MenuType<>(SpellEditorMenu::new));

    public static void register() {
        MENUS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
