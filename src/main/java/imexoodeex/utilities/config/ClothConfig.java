package imexoodeex.utilities.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "utilities")
public class ClothConfig implements ConfigData {

    public enum UNIT {
        KPH, MPS, MPH
    }

    @Comment("Change unit of stopwatch | delete text to see other options!")
    public UNIT unit = UNIT.KPH;

    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should loot spawn in village chests")
    public boolean loot_in_village = true;

    @ConfigEntry.Gui.RequiresRestart
    @Comment("If true, loot will be decerased")
    public boolean decreased_loot = false;

    @ConfigEntry.Gui.RequiresRestart
    @Comment("If enabled drops will be disabled")
    public boolean disable_loot = false;

    public enum TEXT_ENUM {
        LEFT_BOTTOM, LEFT_MID, LEFT_TOP, RIGHT_BOTTOM, RIGHT_MID, RIGHT_TOP
    }

    @Comment("Text location of informational items | delete text to see other options!")
    public TEXT_ENUM text_location = TEXT_ENUM.LEFT_MID;

}
