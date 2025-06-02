package com.hexwail.grimuar.menu;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.common.extensions.IForgeMenuType;

public class SpellEditorMenu extends AbstractContainerMenu {

    public static final MenuType<SpellEditorMenu> TYPE = IForgeMenuType.create(SpellEditorMenu::new);

    public SpellEditorMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        this(id, inv);
    }

    public SpellEditorMenu(int id, Inventory inv) {
        super(TYPE, id);
        // Тут можна додати слоти, якщо потрібно (поки залишимо порожнім)
    }

    @Override
    public boolean stillValid(Player player) {
        return true; // можна зробити перевірку відстані чи інші умови
    }
}
