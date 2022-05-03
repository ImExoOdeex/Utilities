package imexoodeex.supplementaryaccessories.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import imexoodeex.supplementaryaccessories.client.particles.RocketBootsParticles;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

import static imexoodeex.supplementaryaccessories.SupplementaryAccessories.LOGGER;

public class RocketBoots extends TrinketItem {

    public RocketBoots(Settings settings) {
        super(settings);
    }

    int a = 0;

    private void resetTimer() {
        a = 0;
    }

    private final int activeValue = 15;

    /* 20 tick is 1 second, so 5 * 1 sec is 5 seconds of flying*/
    public static double FLIGHTTIME = 5 * 20;
    private final double flightTimeMax = 5 * 20;

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        boolean isGrounded = entity.isOnGround();
        boolean isJumping = MinecraftClient.getInstance().options.jumpKey.isPressed();
        boolean isRocketFlying = isJumping && !isGrounded && !entity.isClimbing() && a >= activeValue && FLIGHTTIME > 0;
        Vec3d v = entity.getVelocity();
        double yVelocity = v.getY();

        World world = entity.world;

        if (isJumping || !isGrounded) {
            a++;
        } else {
            resetTimer();
        }

        if (entity.isSwimming() && entity.isInSwimmingPose()) {
            entity.setVelocity(v.getX(), v.getY(), v.getZ());
        } else if (entity.isSubmergedInWater() && isJumping) {
            entity.setVelocity(v.getX(), (yVelocity * 0.9) + 0.01, v.getZ());
            RocketBootsParticles.spawnRocketParticles(entity, world);
        } else if (isJumping && !isGrounded && !entity.isClimbing() && a >= activeValue) {
            if (FLIGHTTIME > 0) {
                entity.fallDistance = 0.0F;
                FLIGHTTIME--;
                entity.setVelocity(v.getX(), (yVelocity * 0.9) + 0.1, v.getZ());
                RocketBootsParticles.spawnRocketParticles(entity, world);
            }
        }
        // add flight time while not rocket flying
        if (!isRocketFlying) {
            FLIGHTTIME += 0.15;
        }

        if (FLIGHTTIME > flightTimeMax) {
            FLIGHTTIME = flightTimeMax;
        }

        super.tick(stack, slot, entity);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        FLIGHTTIME = FLIGHTTIME + 0.15;
        if (FLIGHTTIME > flightTimeMax) {
            FLIGHTTIME = flightTimeMax;
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText(getClass().getSimpleName()).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}