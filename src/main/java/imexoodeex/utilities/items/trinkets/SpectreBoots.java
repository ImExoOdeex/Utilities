package imexoodeex.utilities.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import imexoodeex.utilities.client.particles.HermesBootsParticles;
import imexoodeex.utilities.client.particles.SpectreBootsParticles;
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

public class SpectreBoots extends TrinketItem {

    public SpectreBoots(Settings settings) {
        super(settings);
    }

    /* 20 tick is 1 second, so 7 * 1 sec is 7 seconds of flying*/
    public static double FLIGHTTIME = 7 * 20;
    private final double flightTimeMax = 7 * 20;
    private static int fallFlyingA = 0;

    private static int jumpCount = 0;
    private static boolean jumpKey = false;

    private static int getMultiJumps() {
        jumpCount = 1;
        return jumpCount;
    }

    double value = 1.0;
    final double DefaultValue = 1.0;
    int a = 0;

    void resetTimer() {
        a = 0;
    }

    private static void fly(LivingEntity entity, double yVelocity, Vec3d v) {
        fallFlyingA += 1;
        if (!entity.isFallFlying()) {
            entity.fallDistance = 0.0F;
            entity.setVelocity(v.getX(), (yVelocity * 0.9) + 0.1, v.getZ());
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

        //some functions
        World world = entity.world;
        boolean isActive = false;
        PlayerEntity player = (PlayerEntity) entity;
        boolean isSprinting = entity.isSprinting();
        boolean isGrounded = entity.isOnGround();
        Vec3d v = entity.getVelocity();

        if (world.isClient()) {
            boolean isJumping = MinecraftClient.getInstance().options.jumpKey.isPressed();
            double yVelocity = v.getY();

            // rocket flight
            if (entity.isSwimming() && entity.isInSwimmingPose()) {
                entity.addVelocity(0, 0, 0);
            } else if (entity.isSubmergedInWater() && isJumping) {
                entity.setVelocity(v.getX(), (yVelocity * 0.9) + 0.01, v.getZ());
            } else if (entity.isOnGround() || entity.hasVehicle()) {
                jumpCount = getMultiJumps();
                fallFlyingA = 0;
            } else if (isJumping && !isGrounded && !entity.isClimbing() && FLIGHTTIME >= 0) {
                if (!jumpKey && jumpCount > 0 && yVelocity < 0.333) {
                    fly(entity, yVelocity, v);
                    isActive = true;
                } else if (jumpCount <= 0) {
                    fly(entity, yVelocity, v);
                    isActive = true;
                }
                jumpKey = true;
            } else {
                jumpKey = false;
            }
        }


        // hermes speed
        if (isSprinting && isGrounded) {
            a++;
        } else if (!isSprinting) {
            resetTimer();
        }
        if (a >= 50 && a < 100) {
            value = 1.04;
        } else if (a >= 100 && a < 150) {
            value = 1.08;
        } else if (a >= 150 && a < 200) {
            value = 1.12;
        } else if (a >= 200 && a < 250) {
            value = 1.14;
        } else if (a >= 250 && a < 300) {
            value = 1.16;
        } else if (a >= 300 && a < 350) {
            value = 1.18;
        } else if (a >= 350) {
            value = 1.20;
        } else {
            value = DefaultValue;
        }
        // hermes particles && velocity
        if (isSprinting && isGrounded) {
            player.setVelocity(v.getX() * value, v.getY(), v.getZ() * value);
            HermesBootsParticles.spawnRocketParticles(entity, world);
        }

        if (FLIGHTTIME > -10) {
            FLIGHTTIME += 0.2;
        }

        if (FLIGHTTIME > flightTimeMax) {
            FLIGHTTIME = flightTimeMax;
        }

        if (isActive) {
            SpectreBootsParticles.spawnRocketParticles(player, world);
        }
        player.fallDistance = 0.0F;

        super.tick(stack, slot, entity);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        FLIGHTTIME += 0.2;
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
