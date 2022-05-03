package imexoodeex.supplementaryaccessories.items.trinkets;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotAttributes;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

import static imexoodeex.supplementaryaccessories.SupplementaryAccessories.LOGGER;

public class Watch extends TrinketItem {
    public Watch(Settings settings) {
        super(settings);
    }

    public static boolean isEquipped = false;
    public static String text = null;

    public float getSpeed(Entity entity) {
        PlayerEntity player = (PlayerEntity) entity;
        return (float) player.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED);
    }

    public String setText(LivingEntity entity) {
        World world = entity.world;

        if (!world.isClient) {
            ServerWorld serverWorld = (ServerWorld) world;

            /*
             * 12 000 - night start
             * 0 (24 000) - day start
             *
             * 0 - 12000 = day
             * 12000 - 0 (24000) = night
             * */

            Long ticksOfDay = serverWorld.getTimeOfDay();
            Long ticksOfDayMod = ticksOfDay % 24000;

            //if is night
            if (ticksOfDayMod >= 12000) {
                Long timeToDay = 24000 - ticksOfDayMod;
                Long timeToDayFixed = (timeToDay / 20) / 60;
                String timeToDayMinutes = timeToDayFixed < 10 ? "0" + timeToDayFixed : String.valueOf(timeToDayFixed);
                String timeToDaySeconds = (timeToDay / 20) % 60 < 10 ? "0" + (timeToDay / 20) % 60 : String.valueOf((timeToDay / 20) % 60);
                text = "To day: " + timeToDayMinutes + ":" + timeToDaySeconds;
            }
            //if is day
            else if (ticksOfDayMod >= 0) {
                Long timeToNight = 12000 - ticksOfDayMod;
                Long timeToNightFixed = (timeToNight / 20) / 60;
                String timeToNightMinutes = timeToNightFixed < 10 ? "0" + timeToNightFixed : String.valueOf(timeToNightFixed);
                String timeToNightSeconds = (timeToNight / 20) % 60 < 10 ? "0" + (timeToNight / 20) % 60 : String.valueOf((timeToNight / 20) % 60);
                text = "To night: " + timeToNightMinutes + ":" + timeToNightSeconds;
            }

            Long hours = ticksOfDayMod / 1000 + 6;
            if (hours > 24) {
                hours -= 24;
            }
            String hoursText = String.valueOf(hours);

            double minutes = (ticksOfDayMod % 1000) / 16.66;
            String minutesText = minutes < 10 ? "0" + (int) minutes : String.valueOf((int) minutes);

            text = "Time: " + hoursText + ":" + minutesText + " /*jebać nową linie ez*/" + text;


        }
        return text;
    }

    /* this is second licznik ile sie na świecie jest od poczatku gry
    Long ticks = world.getTickOrder();
            LOGGER.info("Ticks: " + ticks / 20);*/

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {

        isEquipped = true;
        setText(entity);

        super.tick(stack, slot, entity);
    }


    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {

        isEquipped = false;

        super.onUnequip(stack, slot, entity);
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        var modifiers = super.getModifiers(stack, slot, entity, uuid);
        SlotAttributes.addSlotModifier(modifiers, "hand/wrist", uuid, 1, EntityAttributeModifier.Operation.ADDITION);
        return modifiers;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText(getClass().getSimpleName()).formatted(Formatting.GRAY));
        if (isEquipped) {
            tooltip.add(new TranslatableText("on").formatted(Formatting.GRAY));
        } else {
            tooltip.add(new TranslatableText("off").formatted(Formatting.GRAY));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
