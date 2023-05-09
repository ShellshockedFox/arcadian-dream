/*
 * Copyright (c) 2023 Maxmani and contributors.
 * Licensed under the EUPL-1.2 or later.
 */

package net.reimaden.arcadiandream.item.custom.misc;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.reimaden.arcadiandream.item.IEquipmentHelper;

public class MagatamaNecklaceItem extends TrinketItem implements IEquipmentHelper {

    public MagatamaNecklaceItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);
        playEquipSound(stack, entity);
    }
}
