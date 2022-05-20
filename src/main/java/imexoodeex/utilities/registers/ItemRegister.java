package imexoodeex.utilities.registers;

import dev.emi.trinkets.api.TrinketItem;
import imexoodeex.utilities.items.trinkets.*;
import imexoodeex.utilities.util.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

import static imexoodeex.utilities.items.SAItems.registerItems;

public class ItemRegister {

    private static final Item.Settings createGroup = new Item.Settings().group(ModItemGroup.SUPPLEMENTARY_ACCESSORIES).maxCount(1).maxDamage(100);
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
    }
}