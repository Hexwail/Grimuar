package com.hexwail.grimuar.menu;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuProvider;

public class SpellEditorProvider implements MenuProvider {

    @Override
    public Component getDisplayName() {
        return Component.literal("Редактор Заклять");
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, net.minecraft.world.entity.player.Player player) {
        return new SpellEditorMenu(id, inv);
    }
}
