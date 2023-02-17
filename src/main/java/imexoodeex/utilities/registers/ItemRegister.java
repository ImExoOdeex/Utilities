package imexoodeex.utilities.registers;

import imexoodeex.utilities.items.trinkets.*;
import imexoodeex.utilities.util.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Rarity;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import static imexoodeex.utilities.items.SAItems.registerItems;

public class ItemRegister {

    private static final Item.Settings createGroup = new Item.Settings().maxCount(1).maxDamage(100);
    public static Item spectre_boots = new SpectreBoots(createGroup.rarity(Rarity.EPIC));
    public static Item combatshield = new CombatShield(createGroup.rarity(Rarity.EPIC));
    public static Item obsidianshield = new ObsidianShield(createGroup.rarity(Rarity.EPIC));
    public static Item rocket_boots = new RocketBoots(createGroup.rarity(Rarity.RARE));
    public static Item hermes_boots = new HermesBoots(createGroup.rarity(Rarity.RARE));
    public static Item bandofregeneration = new BandOfRegeneration(createGroup.rarity(Rarity.RARE));
    public static Item feralclaws = new FeralClaws(createGroup.rarity(Rarity.RARE));
    public static Item berserkerglove = new BerserkerGlove(createGroup.rarity(Rarity.RARE));
    public static Item cloudinabottle = new CloudInABottle(createGroup.rarity(Rarity.RARE));
    public static Item cloudinaballoon = new CloudInABalloon(createGroup.rarity(Rarity.RARE));
    public static Item horseshoe = new Horseshoe(createGroup.rarity(Rarity.UNCOMMON));
    public static Item obsidianhorseshoe = new ObsidianHorseshoe(createGroup.rarity(Rarity.UNCOMMON));
    public static Item frogleg = new FrogLeg(createGroup.rarity(Rarity.UNCOMMON));
    public static Item frogflipper = new FrogFlipper(createGroup.rarity(Rarity.UNCOMMON));
    public static Item mask = new Mask(createGroup.rarity(Rarity.UNCOMMON));
    public static Item blindfold = new Blindfold(createGroup.rarity(Rarity.COMMON));
    public static Item shackle = new Shackle(createGroup.rarity(Rarity.COMMON));
    public static Item vitamins = new Vitamins(createGroup.rarity(Rarity.COMMON));
    public static Item chefhat = new HamburgerCap(createGroup.rarity(Rarity.COMMON));
    public static Item aglet = new Aglet(createGroup.rarity(Rarity.COMMON));
    public static Item flipper = new Flipper(createGroup.rarity(Rarity.COMMON));
    public static Item balloon = new Balloon(createGroup.rarity(Rarity.COMMON));
    public static Item bezoar = new Bezoar(createGroup.rarity(Rarity.COMMON));
    public static Item watch = new Watch(createGroup.rarity(Rarity.COMMON));
    public static Item gps = new GPS(createGroup.rarity(Rarity.COMMON));
    public static Item radar = new Radar(createGroup.rarity(Rarity.COMMON));
    public static Item stopwatch = new Stopwatch(createGroup.rarity(Rarity.COMMON));
    public static Item blackbelt = new BlackBelt(createGroup.rarity(Rarity.COMMON));
    public static Item warrioremblem = new WarriorEmblem(createGroup.rarity(Rarity.COMMON));

    public static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void addItemsToModItemGroup() {
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, spectre_boots);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, combatshield);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, obsidianshield);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, rocket_boots);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, hermes_boots);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, bandofregeneration);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, feralclaws);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, berserkerglove);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, cloudinabottle);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, cloudinaballoon);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, horseshoe);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, obsidianhorseshoe);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, frogleg);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, frogflipper);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, mask);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, blindfold);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, shackle);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, vitamins);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, chefhat);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, aglet);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, flipper);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, balloon);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, bezoar);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, watch);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, gps);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, radar);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, stopwatch);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, blackbelt);
        addToItemGroup(ModItemGroup.SUPPLEMENTARY_ACCESSORIES, warrioremblem);
    }

    public static void registerSAItems() {
        registerItems("spectre_boots", spectre_boots);
        registerItems("rocket_boots", rocket_boots);
        registerItems("hermes_boots", hermes_boots);
        registerItems("horseshoe", horseshoe);
        registerItems("obsidianhorseshoe", obsidianhorseshoe);
        registerItems("aglet", aglet);
        registerItems("bandofregeneration", bandofregeneration);
        registerItems("blindfold", blindfold);
        registerItems("feralclaws", feralclaws);
        registerItems("berserkerglove", berserkerglove);
        registerItems("mask", mask);
        registerItems("bezoar", bezoar);
        registerItems("chefhat", chefhat);
        registerItems("combatshield", combatshield);
        registerItems("obsidianshield", obsidianshield);
        registerItems("balloon", balloon);
        registerItems("cloudinaballoon", cloudinaballoon);
        registerItems("cloudinabottle", cloudinabottle);
        registerItems("radar", radar);
        registerItems("gps", gps);
        registerItems("watch", watch);
        registerItems("stopwatch", stopwatch);
        registerItems("vitamins", vitamins);
        registerItems("flipper", flipper);
        registerItems("frogleg", frogleg);
        registerItems("frogflipper", frogflipper);
        registerItems("blackbelt", blackbelt);
        registerItems("warrioremblem", warrioremblem);
        registerItems("shackle", shackle);
        addItemsToModItemGroup();
    }
}