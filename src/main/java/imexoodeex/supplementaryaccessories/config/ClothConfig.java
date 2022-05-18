package imexoodeex.supplementaryaccessories.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "supplementaryaccessories")
public class ClothConfig implements ConfigData {

    @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
    @Comment("Change unit of stopwatch")
    public static InnerStuff unit = new InnerStuff();
    static class InnerStuff {
        double mps = 1;
        double kph = 3.6;
        double mph = 1609;
    }
}