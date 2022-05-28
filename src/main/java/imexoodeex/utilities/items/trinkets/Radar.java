package imexoodeex.utilities.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class Radar extends TrinketItem {
    public Radar(Settings settings) {
        super(settings);
    }

    public static String text = null;
    float distanceTraveled = 0;

    public String setText(World world, Entity entity) {

        PlayerEntity player = (PlayerEntity) entity;

        if (world.isClient()) {
            distanceTraveled = player.getAttackCooldownProgress(10);
        }

        text = "Cooldown: " +  distanceTraveled + "s";
//        text = "Experience: " + totalExpLvl + "." + expLvlString;

        return text;
    }


    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        World world = entity.world;

        setText(world, entity);

        super.tick(stack, slot, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText(getClass().getSimpleName()).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}

