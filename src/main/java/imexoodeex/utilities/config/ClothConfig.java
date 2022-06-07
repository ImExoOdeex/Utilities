package imexoodeex.utilities.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "utilities")
@Config.Gui.Background("minecraft:textures/block/ancient_debris_side.png")
//@Config.Gui.Background("minecraft:textures/block/azalea_top.png")
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

    @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
    @Comment("Cloud in a bottle cooldown duration")
    public int cooldown = 40;

    @Comment("Text location of informational items | delete text to see other options!")
    public TEXT_ENUM text_location = TEXT_ENUM.LEFT_MID;

    @ConfigEntry.Gui.CollapsibleObject(startExpanded = true)
    public BarStuff barStuff = new BarStuff();

    public static class BarStuff {
        @Comment("If enabled, bars with cooldown/flight time will be displayed on screen")
        public boolean display_bars = true;

        @Comment("Size of bar")
        @ConfigEntry.BoundedDiscrete(min = 0, max = 200)
        public int bar_size = 70;

        @Comment("Color of first bar")
        @ConfigEntry.ColorPicker(allowAlpha = false)
        public int bar_color1 = 0xFFFFFF;

        @Comment("Color of second bar")
        @ConfigEntry.ColorPicker(allowAlpha = false)
        public int bar_color2 = 0x000000;

        @Comment("Translate 'X' of the bar")
        @ConfigEntry.BoundedDiscrete(min = -100, max = 100)
        public int x = 0;

        @Comment("Translate 'Y' of the bar")
        @ConfigEntry.BoundedDiscrete(min = -100, max = 100)
        public int y = 0;
    }

}