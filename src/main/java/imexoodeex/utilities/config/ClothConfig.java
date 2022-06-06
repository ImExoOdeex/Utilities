package imexoodeex.utilities.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import me.shedaniel.clothconfig2.impl.builders.DropdownMenuBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;

import java.util.stream.Collectors;

@Config(name = "utilities")
@Config.Gui.Background("minecraft:textures/block/oak_planks.png")
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
    BarStuff stuff = new BarStuff();

    public static class BarStuff {
        @Comment("If enabled, bars with cooldown/flight time will be displayed on screen")
        public static boolean display_bars = true;

        @Comment("Size of bar")
        @ConfigEntry.BoundedDiscrete(min = 0, max = 2)
        public static double bar_size = 0.7;

        @Comment("Translate 'X' of the bar")
        @ConfigEntry.BoundedDiscrete(min = -100, max = 100)
        public static int x = 0;

        @Comment("Translate 'Y' of the bar")
        @ConfigEntry.BoundedDiscrete(min = -100, max = 100)
        public static int y = 0;
    }

}