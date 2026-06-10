package com.witchesblazepowder;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.KilledByPlayerLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;

public class WitchesDropBlazePowder implements ModInitializer {

    @Override
    public void onInitialize() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            // Compare using the witch's loot table registry key directly
            if (!key.equals(EntityType.WITCH.getLootTableId())) return;

            // Guaranteed 1 roll — always drops 1–2 blaze powder when killed by player
            LootPool blazePool = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .with(
                        ItemEntry.builder(Items.BLAZE_POWDER)
                            .apply(SetCountLootFunction.builder(
                                UniformLootNumberProvider.create(1.0f, 2.0f)
                            ))
                    )
                    .conditionally(KilledByPlayerLootCondition.builder())
                    .build();

            tableBuilder.pool(blazePool);
        });
    }
}
