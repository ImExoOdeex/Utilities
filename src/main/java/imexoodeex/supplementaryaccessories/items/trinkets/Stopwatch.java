package imexoodeex.supplementaryaccessories.items.trinkets;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotAttributes;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

//import LOGGER from main file supplementary accessories
import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;

import static imexoodeex.supplementaryaccessories.SupplementaryAccessories.LOGGER;

public class Stopwatch extends TrinketItem {
    public Stopwatch(Settings settings) {
        super(settings);
    }

    public static boolean isEquipped = false;

    public static String text = "";

    int a = 0;

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {

        isEquipped = true;
        PlayerEntity player = (PlayerEntity) entity;
        World world = player.world;


        Vec3d vec = entity.getVelocity();

        double xOffset = 0;
        double zOffset = 0;
        double vOffset = 0;

        double speed = (Math.sqrt(Math.pow(vec.x + xOffset, 2) + Math.pow(vec.z + zOffset, 2)) * 20) + vOffset;
        // to km/h
        speed *= 3.6;

        DecimalFormat dec = new DecimalFormat("#0.00");
        String formattedSpeed = dec.format(speed);

        if (!world.isClient()) {
            LOGGER.info("Speed: " + formattedSpeed + " km/h");
        }

        a++;

        if (a >= 2) {
            text = "Speed: " + formattedSpeed + " km/h";
            a = 0;
        }

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
