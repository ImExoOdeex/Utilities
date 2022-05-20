package imexoodeex.utilities.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import imexoodeex.utilities.client.particles.RocketBootsParticles;
import net.minecraft.client.MinecraftClient;
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

import javax.annotation.Nullable;
import java.util.List;

public class RocketBoots extends TrinketItem {

    public RocketBoots(Settings settings) {
        super(settings);
    }

    /* 20 tick is 1 second, so 5 * 1 sec is 5 seconds of flying*/
    public static double FLIGHTTIME = 5 * 20;
    private final double flightTimeMax = 5 * 20;
    private static int fallFlyingA = 0;

    private static int jumpCount = 0;
    private static boolean jumpKey = false;

    private static int getMultiJumps() {
        jumpCount = 1;
        return jumpCount;
    }

    private static void fly(LivingEntity entity, double yVelocity, World world, Vec3d v) {
        fallFlyingA += 1;
        if (!entity.isFallFlying()) {
            entity.fallDistance = 0.0F;
            entity.setVelocity(v.getX(), (yVelocity * 0.9) + 0.1, v.getZ());
            RocketBootsParticles.spawnRocketParticles(entity, world);
            jumpCount--;
            FLIGHTTIME--;
        } else {
            if (fallFlyingA >= 10) {
                PlayerEntity player = (PlayerEntity) entity;
                player.stopFallFlying();
            }
        }
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        boolean isGrounded = entity.isOnGround();
        boolean isJumping = MinecraftClient.getInstance().options.jumpKey.isPressed();
        boolean isRocketFlying = isJumping && !isGrounded && !entity.isClimbing() && FLIGHTTIME > 0;
        Vec3d v = entity.getVelocity();
        double yVelocity = v.getY();
        World world = entity.world;

        // rocket flight
        if (entity.isSwimming() && entity.isInSwimmingPose()) {
            entity.addVelocity(0, 0, 0);
        } else if (entity.isSubmergedInWater() && isJumping) {
            entity.setVelocity(v.getX(), (yVelocity * 0.9) + 0.01, v.getZ());
            RocketBootsParticles.spawnRocketParticles(entity, world);
        } else if (entity.isOnGround() || entity.hasVehicle()) {
            jumpCount = getMultiJumps();
            fallFlyingA = 0;
        } else if (isJumping && !isGrounded && !entity.isClimbing() && FLIGHTTIME >= 0) {
            if (!jumpKey && jumpCount > 0 && yVelocity < 0.333) {
                fly(entity, yVelocity, world, v);
            } else if (jumpCount <= 0) {
                fly(entity, yVelocity, world, v);
            }
            jumpKey = true;
        } else {
            jumpKey = false;
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