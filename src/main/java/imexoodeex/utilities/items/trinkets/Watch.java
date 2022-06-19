package imexoodeex.utilities.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Watch extends TrinketItem {
    public Watch(Settings settings) {
        super(settings);
    }

    public static String text = null;
    public static String text1 = null;

    public String setText(World world) {

        if (world.isClient) {

            /*
             * 12 542 - night start
             * 0 (24 000) - day start
             *
             * 0 - 12 542 = day
             * 12 542 - 0 (24000) = night
             *
             *
             * !IMPORTANT!
             * Time is calculated from Minecraft day start (0 ticks, 6 AM), when players and villagers are waking up.
             * Next is night. Night is calculated from Minecraft night start (12 542 ticks, 6:32 PM), when players and villagers are able to sleep.
             *
             * So don't mind me, that day and night are exactly 10 minutes long.
             *
             * */

            Long ticksOfDay = world.getTimeOfDay();
            Long ticksOfDayMod = ticksOfDay % 24000;

            Long hours = ticksOfDayMod / 1000 + 6;
            if (hours >= 24) {
                hours -= 24;
            }
            String hoursText = String.valueOf(hours);

            double minutes = (ticksOfDayMod % 1000) / 16.66;
            String minutesText = minutes < 10 ? "0" + (int) minutes : String.valueOf((int) minutes);

            text = "Time: " + hoursText + ":" + minutesText;
        }
        return text;
    }

    public static String setText1(World world) {

        if (world.isClient) {
            Long ticksOfDay = world.getTimeOfDay();
            Long ticksOfDayMod = ticksOfDay % 24000;

            //if it is night
            if (ticksOfDayMod >= 12542) {
                Long timeToDay = 24000 - ticksOfDayMod;
                Long timeToDayFixed = (timeToDay / 20) / 60;
                String timeToDayMinutes = timeToDayFixed < 10 ? "0" + timeToDayFixed : String.valueOf(timeToDayFixed);
                String timeToDaySeconds = (timeToDay / 20) % 60 < 10 ? "0" + (timeToDay / 20) % 60 : String.valueOf((timeToDay / 20) % 60);
                text1 = "To day: " + timeToDayMinutes + ":" + timeToDaySeconds + " minutes";
            }
            //if it is day
            else if (ticksOfDayMod >= 0) {
                Long timeToNight = 12542 - ticksOfDayMod;
                Long timeToNightFixed = (timeToNight / 20) / 60;
                String timeToNightMinutes = timeToNightFixed < 10 ? "0" + timeToNightFixed : String.valueOf(timeToNightFixed);
                String timeToNightSeconds = (timeToNight / 20) % 60 < 10 ? "0" + (timeToNight / 20) % 60 : String.valueOf((timeToNight / 20) % 60);
                text1 = "To night: " + timeToNightMinutes + ":" + timeToNightSeconds + " minutes";
            }
        }

        return text1;
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {

        World world = entity.getWorld();

        setText(world);
        setText1(world);

        super.tick(stack, slot, entity);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable(getClass().getSimpleName()).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
