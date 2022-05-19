package imexoodeex.supplementaryaccessories.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "supplementaryaccessories")
public class ClothConfig implements ConfigData {

    @Comment("Change unit of stopwatch (kph, mph, mps)")
    public static String unit = "kph";

    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should loot spawn in village chests")
    public static boolean loot_in_village = true;

    @ConfigEntry.Gui.RequiresRestart
    @Comment("If true, loot will be decerased")
    public static boolean decreased_loot = false;

}
