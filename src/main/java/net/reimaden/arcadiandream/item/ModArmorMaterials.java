/*
 * Copyright (c) 2022-2023 Maxmani and contributors.
 * Licensed under the EUPL-1.2 or later.
 */

package net.reimaden.arcadiandream.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.Util;
import net.reimaden.arcadiandream.sound.ModSounds;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial, StringIdentifiable {

    /* Vanilla Armor Materials
     * LEATHER("leather", 5, Util.make(new EnumMap<ArmorItem.Type, V>(ArmorItem.Type.class), map -> {
     *     map.put(ArmorItem.Type.BOOTS, 1);
     *     map.put(ArmorItem.Type.LEGGINGS, 2);
     *     map.put(ArmorItem.Type.CHESTPLATE, 3);
     *     map.put(ArmorItem.Type.HELMET, 1);
     * }), 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.LEATHER)),
     * CHAIN("chainmail", 15, Util.make(new EnumMap<ArmorItem.Type, V>(ArmorItem.Type.class), map -> {
     *     map.put(ArmorItem.Type.BOOTS, 1);
     *     map.put(ArmorItem.Type.LEGGINGS, 4);
     *     map.put(ArmorItem.Type.CHESTPLATE, 5);
     *     map.put(ArmorItem.Type.HELMET, 2);
     * }), 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.IRON_INGOT)),
     * IRON("iron", 15, Util.make(new EnumMap<ArmorItem.Type, V>(ArmorItem.Type.class), map -> {
     *     map.put(ArmorItem.Type.BOOTS, 2);
     *     map.put(ArmorItem.Type.LEGGINGS, 5);
     *     map.put(ArmorItem.Type.CHESTPLATE, 6);
     *     map.put(ArmorItem.Type.HELMET, 2);
     * }), 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.IRON_INGOT)),
     * GOLD("gold", 7, Util.make(new EnumMap<ArmorItem.Type, V>(ArmorItem.Type.class), map -> {
     *     map.put(ArmorItem.Type.BOOTS, 1);
     *     map.put(ArmorItem.Type.LEGGINGS, 3);
     *     map.put(ArmorItem.Type.CHESTPLATE, 5);
     *     map.put(ArmorItem.Type.HELMET, 2);
     * }), 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
     * DIAMOND("diamond", 33, Util.make(new EnumMap<ArmorItem.Type, V>(ArmorItem.Type.class), map -> {
     *     map.put(ArmorItem.Type.BOOTS, 3);
     *     map.put(ArmorItem.Type.LEGGINGS, 6);
     *     map.put(ArmorItem.Type.CHESTPLATE, 8);
     *     map.put(ArmorItem.Type.HELMET, 3);
     * }), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f, 0.0f, () -> Ingredient.ofItems(Items.DIAMOND)),
     * TURTLE("turtle", 25, Util.make(new EnumMap<ArmorItem.Type, V>(ArmorItem.Type.class), map -> {
     *     map.put(ArmorItem.Type.BOOTS, 2);
     *     map.put(ArmorItem.Type.LEGGINGS, 5);
     *     map.put(ArmorItem.Type.CHESTPLATE, 6);
     *     map.put(ArmorItem.Type.HELMET, 2);
     * }), 9, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.SCUTE)),
     * NETHERITE("netherite", 37, Util.make(new EnumMap<ArmorItem.Type, V>(ArmorItem.Type.class), map -> {
     *     map.put(ArmorItem.Type.BOOTS, 3);
     *     map.put(ArmorItem.Type.LEGGINGS, 6);
     *     map.put(ArmorItem.Type.CHESTPLATE, 8);
     *     map.put(ArmorItem.Type.HELMET, 3);
     * }), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0f, 0.1f, () -> Ingredient.ofItems(Items.NETHERITE_INGOT));
     */

    ORDINARY("ordinary", 4, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 1);
        map.put(ArmorItem.Type.LEGGINGS, 2);
        map.put(ArmorItem.Type.CHESTPLATE, 3);
        map.put(ArmorItem.Type.HELMET, 1);
    }), 20, ModSounds.ITEM_ARMOR_EQUIP_ORDINARY, 0.0f, 0.0f, () -> Ingredient.fromTag(ItemTags.WOOL)),
    MAKAITE("makaite", 24, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 2);
        map.put(ArmorItem.Type.LEGGINGS, 5);
        map.put(ArmorItem.Type.CHESTPLATE, 6);
        map.put(ArmorItem.Type.HELMET, 2);
    }), 10, ModSounds.ITEM_ARMOR_EQUIP_MAKAITE, 0.0f, 0.0f, () -> Ingredient.ofItems(ModItems.MAKAITE_INGOT));

    @SuppressWarnings("deprecation") // Not sure what I'm supposed to use here instead
    public static final StringIdentifiable.Codec<ModArmorMaterials> CODEC;
    private static final EnumMap<ArmorItem.Type, Integer> BASE_DURABILITY;
    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredientSupplier;

    ModArmorMaterials(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protectionAmounts , int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = repairIngredientSupplier;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY.get(type) * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts.get(type);
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredientSupplier.get();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }

    @Override
    public String asString() {
        return name;
    }

    static {
        CODEC = StringIdentifiable.createCodec(ModArmorMaterials::values);
        BASE_DURABILITY = Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 13);
            map.put(ArmorItem.Type.LEGGINGS, 15);
            map.put(ArmorItem.Type.CHESTPLATE, 16);
            map.put(ArmorItem.Type.HELMET, 11);
        });
    }
}
