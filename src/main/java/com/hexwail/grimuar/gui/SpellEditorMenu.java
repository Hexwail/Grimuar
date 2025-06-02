package com.hexwail.grimuar.gui;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.common.extensions.IForgeMenuType;

public class SpellEditorMenu extends AbstractContainerMenu {

    public SpellEditorMenu(int id, Inventory playerInventory) {
        super(MenuInit.SPELL_EDITOR_MENU.get(), id);
        // тут можна додати слоти або логіку
    }

    public SpellEditorMenu(int id, Inventory playerInventory, FriendlyByteBuf buf) {
        this(id, playerInventory);
        // читання даних з буфера якщо потрібно
    }

    @Override
    public boolean stillValid(net.minecraft.world.entity.player.Player player) {
        return true;
    }
}
