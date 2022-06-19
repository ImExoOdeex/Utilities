package imexoodeex.utilities.util;

import imexoodeex.utilities.registers.ItemRegister;
import imexoodeex.utilities.utilities;
import net.fabricmc.fabric.api.loot.v2.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class LootTablesModify {

    private static final Identifier MINESHAFT_CHEST_ID
            = new Identifier("minecraft", "chests/abandoned_mineshaft");

    private static final Identifier DESERT_CHEST_ID
            = new Identifier("minecraft", "chests/desert_pyramid");

    private static final Identifier BASTION_BRIDGE_CHEST_ID
            = new Identifier("minecraft", "chests/bastion_bridge");

    private static final Identifier BASTION_HOGLIN_CHEST_ID
            = new Identifier("minecraft", "chests/bastion_hoglin_stable");

    private static final Identifier BASTION_OTHER_CHEST_ID
            = new Identifier("minecraft", "chests/bastion_other");

    private static final Identifier BASTION_TREASURE_CHEST_ID
            = new Identifier("minecraft", "chests/bastion_treasure");

    private static final Identifier BURIED_TREASURE_CHEST_ID
            = new Identifier("minecraft", "chests/buried_treasure");

    private static final Identifier END_CITY_CHEST_ID
            = new Identifier("minecraft", "chests/end_city_treasure");

    private static final Identifier IGLOO_CHEST_ID
            = new Identifier("minecraft", "chests/igloo_chest");

    private static final Identifier JUNGLE_TEMPLE_CHEST_ID
            = new Identifier("minecraft", "chests/jungle_temple");

    private static final Identifier NETHER_BRIDGE_CHEST_ID
            = new Identifier("minecraft", "chests/nether_bridge");

    private static final Identifier PILLAGER_CHEST_ID
            = new Identifier("minecraft", "chests/pillager_outpost");

    private static final Identifier RUINED_PORTAL_CHEST_ID
            = new Identifier("minecraft", "chests/ruined_portal");

    private static final Identifier SHIPWRECK_MAP_CHEST_ID
            = new Identifier("minecraft", "chests/shipwreck_map");

    private static final Identifier SHIPWRECT_SUPPLY_CHEST_ID
            = new Identifier("minecraft", "chests/shipwreck_supply");

    private static final Identifier SHIPWRECT_TREASURE_CHEST_ID
            = new Identifier("minecraft", "chests/shipwreck_treasure");

    private static final Identifier SIMPLE_DUNGEON_CHEST_ID
            = new Identifier("minecraft", "chests/simple_dungeon");

    private static final Identifier STRONGHOLD_CORRIDOR_CHEST_ID
            = new Identifier("minecraft", "chests/stronghold_corridor");

    private static final Identifier STRONGHOLD_CROSSING_CHEST_ID
            = new Identifier("minecraft", "chests/stronghold_crossing");

    private static final Identifier STRONGHOLD_LIBRARY_CHEST_ID
            = new Identifier("minecraft", "chests/stronghold_library");

    private static final Identifier UNDERWATER_RUIN_BIG_CHEST_ID
            = new Identifier("minecraft", "chests/underwater_ruin_big");

    private static final Identifier UNDERWATER_RUIN_SMALL_CHEST_ID
            = new Identifier("minecraft", "chests/underwater_ruin_small");

    private static final Identifier WOODLAND_MANSION_CHEST_ID
            = new Identifier("minecraft", "chests/woodland_mansion");

    // village
    private static final Identifier VILLAGE_ARMORER_CHEST_ID
            = new Identifier("minecraft", "chests/village/village_armorer");

    private static final Identifier VILLAGE_BUTCHER_CHEST_ID
            = new Identifier("minecraft", "chests/village/village_butcher");

    private static final Identifier VILLAGE_CARTOGRAPHER_CHEST_ID
            = new Identifier("minecraft", "chests/village/village_cartographer");

    private static final Identifier VILLAGE_DESERT_HOUSE_CHEST_ID
            = new Identifier("minecraft", "chests/village/village_desert_house");

    private static final Identifier VILLAGE_FISHER_CHEST_ID
            = new Identifier("minecraft", "chests/village/village_fisher");

    private static final Identifier VILLAGE_FLETCHER_CHEST_ID
            = new Identifier("minecraft", "chests/village/village_fletcher");

    private static final Identifier VILLAGE_MASON_CHEST_ID
            = new Identifier("minecraft", "chests/village/village_mason");

    private static final Identifier VILLAGE_PLAINS_HOUSE_CHEST_ID
            = new Identifier("minecraft", "chests/village/village_plains_house");

    private static final Identifier VILLAGE_SAVANNA_HOUSE_CHEST_ID
            = new Identifier("minecraft", "chests/village/village_savanna_house");

    private static final Identifier VILLAGE_SHEPHERD_CHEST_ID
            = new Identifier("minecraft", "chests/village/village_shepherd");

    private static final Identifier VILLAGE_SNOWY_HOUSE_CHEST_ID
            = new Identifier("minecraft", "chests/village/village_snowy_house");

    private static final Identifier VILLAGE_TAIGA_HOUSE_CHEST_ID
            = new Identifier("minecraft", "chests/village/village_taiga_house");

    private static final Identifier VILLAGE_TANNERY_CHEST_ID
            = new Identifier("minecraft", "chests/village/village_tannery");

    private static final Identifier VILLAGE_TEMPLE_CHEST_ID
            = new Identifier("minecraft", "chests/village/village_temple");

    private static final Identifier VILLAGE_TOOLSMITH_CHEST_ID
            = new Identifier("minecraft", "chests/village/village_toolsmith");

    private static final Identifier VILLAGE_WEAPONSMITH_CHEST_ID
            = new Identifier("minecraft", "chests/village/village_weaponsmith");

    // all items to chest loot
    private static void registerMultipleLoot(Identifier id, FabricLootTableBuilder supplier, Identifier name) {
        if (name.equals(id)) {
            if (!utilities.CONFIG.disable_loot) {
                if (!utilities.CONFIG.decreased_loot) {
                    LootPool.Builder builder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))

                            .with(ItemEntry.builder(ItemRegister.aglet))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.balloon))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.bandofregeneration))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.bezoar))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.blackbelt))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.blindfold))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.cloudinabottle))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.combatshield))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.feralclaws))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.flipper))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.frogleg))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.chefhat))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.horseshoe))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.mask))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.hermes_boots))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.rocket_boots))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.vitamins))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.warrioremblem))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.watch))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.gps))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.radar))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.berserkerglove))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.shackle))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());
                    supplier.pool(builder.build());
                } else {
                    LootPool.Builder builder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))

                            .with(ItemEntry.builder(ItemRegister.aglet))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.balloon))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.bandofregeneration))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.bezoar))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.blackbelt))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.blindfold))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.cloudinabottle))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.combatshield))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.feralclaws))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.flipper))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.frogleg))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.chefhat))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.horseshoe))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.mask))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.hermes_boots))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.rocket_boots))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.vitamins))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.warrioremblem))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.watch))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.gps))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.radar))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.berserkerglove))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(ItemRegister.shackle))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())


                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

                            .with(ItemEntry.builder(Items.AIR))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                    supplier.pool(builder.build());
                }
            }
        }
    }


    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(((resourceManager, manager, id, supplier, setter) -> {
            registerMultipleLoot(id, supplier, STRONGHOLD_CROSSING_CHEST_ID);
            registerMultipleLoot(id, supplier, BASTION_BRIDGE_CHEST_ID);
            registerMultipleLoot(id, supplier, BASTION_HOGLIN_CHEST_ID);
            registerMultipleLoot(id, supplier, BASTION_OTHER_CHEST_ID);
            registerMultipleLoot(id, supplier, BASTION_TREASURE_CHEST_ID);
            registerMultipleLoot(id, supplier, BURIED_TREASURE_CHEST_ID);
            registerMultipleLoot(id, supplier, END_CITY_CHEST_ID);
            registerMultipleLoot(id, supplier, IGLOO_CHEST_ID);
            registerMultipleLoot(id, supplier, NETHER_BRIDGE_CHEST_ID);
            registerMultipleLoot(id, supplier, PILLAGER_CHEST_ID);
            registerMultipleLoot(id, supplier, JUNGLE_TEMPLE_CHEST_ID);
            registerMultipleLoot(id, supplier, RUINED_PORTAL_CHEST_ID);
            registerMultipleLoot(id, supplier, SHIPWRECK_MAP_CHEST_ID);
            registerMultipleLoot(id, supplier, SHIPWRECT_SUPPLY_CHEST_ID);
            registerMultipleLoot(id, supplier, SHIPWRECT_TREASURE_CHEST_ID);
            registerMultipleLoot(id, supplier, SIMPLE_DUNGEON_CHEST_ID);
            registerMultipleLoot(id, supplier, STRONGHOLD_CORRIDOR_CHEST_ID);
            registerMultipleLoot(id, supplier, STRONGHOLD_CROSSING_CHEST_ID);
            registerMultipleLoot(id, supplier, STRONGHOLD_LIBRARY_CHEST_ID);
            registerMultipleLoot(id, supplier, UNDERWATER_RUIN_SMALL_CHEST_ID);
            registerMultipleLoot(id, supplier, UNDERWATER_RUIN_BIG_CHEST_ID);
            registerMultipleLoot(id, supplier, WOODLAND_MANSION_CHEST_ID);
            registerMultipleLoot(id, supplier, MINESHAFT_CHEST_ID);
            registerMultipleLoot(id, supplier, DESERT_CHEST_ID);

            if (utilities.CONFIG.loot_in_village) {
                //village
                registerMultipleLoot(id, supplier, VILLAGE_ARMORER_CHEST_ID);
                registerMultipleLoot(id, supplier, VILLAGE_BUTCHER_CHEST_ID);
                registerMultipleLoot(id, supplier, VILLAGE_CARTOGRAPHER_CHEST_ID);
                registerMultipleLoot(id, supplier, VILLAGE_DESERT_HOUSE_CHEST_ID);
                registerMultipleLoot(id, supplier, VILLAGE_FISHER_CHEST_ID);
                registerMultipleLoot(id, supplier, VILLAGE_FLETCHER_CHEST_ID);
                registerMultipleLoot(id, supplier, VILLAGE_MASON_CHEST_ID);
                registerMultipleLoot(id, supplier, VILLAGE_PLAINS_HOUSE_CHEST_ID);
                registerMultipleLoot(id, supplier, VILLAGE_SAVANNA_HOUSE_CHEST_ID);
                registerMultipleLoot(id, supplier, VILLAGE_SHEPHERD_CHEST_ID);
                registerMultipleLoot(id, supplier, VILLAGE_SNOWY_HOUSE_CHEST_ID);
                registerMultipleLoot(id, supplier, VILLAGE_TAIGA_HOUSE_CHEST_ID);
                registerMultipleLoot(id, supplier, VILLAGE_TANNERY_CHEST_ID);
                registerMultipleLoot(id, supplier, VILLAGE_TEMPLE_CHEST_ID);
                registerMultipleLoot(id, supplier, VILLAGE_TOOLSMITH_CHEST_ID);
                registerMultipleLoot(id, supplier, VILLAGE_WEAPONSMITH_CHEST_ID);
            }
        }));
    }
}