package com.hexwail.grimuar.init;

import com.hexwail.grimuar.gui.SpellEditorMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuInit {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, "grimuar");

    public static final RegistryObject<MenuType<SpellEditorMenu>> SPELL_EDITOR_MENU =
        MENUS.register("spell_editor_menu", () -> IForgeMenuType.create(SpellEditorMenu::new));

    public static void register() {
        MENUS.register();
    }
}
