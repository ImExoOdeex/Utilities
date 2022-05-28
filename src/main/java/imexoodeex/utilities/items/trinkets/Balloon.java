package imexoodeex.utilities.items.trinkets;

import dev.emi.trinkets.TrinketsClient;
import dev.emi.trinkets.TrinketsNetwork;
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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Balloon extends TrinketItem {
    public Balloon(Settings settings) {
        super(settings);
    }

    public static double add = 0.02;
    private static boolean isHolding = false;

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        PlayerEntity player = (PlayerEntity) entity;
        Vec3d vec = player.getVelocity();
        if (!player.isSneaking()) {
            player.setVelocity(vec.x, vec.y + add, vec.z);
            entity.fallDistance *= 0.5f;
        }
        isHolding = true;
        super.tick(stack, slot, entity);
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {

        isHolding = false;

        super.onUnequip(stack, slot, entity);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        PlayerEntity player = (PlayerEntity) entity;
        if (selected && !isHolding) {
            Vec3d vec = player.getVelocity();
            if (!player.isSneaking()) {
                player.setVelocity(vec.x, vec.y + add, vec.z);
                entity.fallDistance *= 0.5f;
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText(getClass().getSimpleName()).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
