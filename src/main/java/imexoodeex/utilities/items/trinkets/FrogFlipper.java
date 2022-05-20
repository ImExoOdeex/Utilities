package imexoodeex.utilities.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FrogFlipper extends TrinketItem {
    public FrogFlipper(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        boolean isJumping = MinecraftClient.getInstance().options.jumpKey.isPressed();
        Vec3d vec = entity.getVelocity();
        double y = vec.y;

        if (isJumping && !entity.isSwimming() && y > 0.0D) {
            entity.setVelocity(entity.getVelocity().add(0, 0.04, 0));
        }

        if (entity.isInSwimmingPose()) {
            Vec3d vel = entity.getVelocity();
            entity.setVelocity(vel.x * 1.05, vel.y * 1.05, vel.z * 1.05);
        } else if (entity.isTouchingWater()) {
            Vec3d vel = entity.getVelocity();
            entity.setVelocity(vel.x * 1.1, vel.y * 1.1, vel.z * 1.1);
        }

        super.tick(stack, slot, entity);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new TranslatableText(getClass().getSimpleName()).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
