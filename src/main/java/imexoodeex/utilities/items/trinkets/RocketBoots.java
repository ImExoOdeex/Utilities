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

    public static int getMultiJumps() {
        jumpCount = 1;
        return jumpCount;
    }

    private static void fly(PlayerEntity player, double yVelocity, Vec3d v) {
        fallFlyingA += 1;
        if (!player.isFallFlying()) {
            player.setVelocity(v.getX(), (yVelocity * 0.9) + 0.1, v.getZ());
            jumpCount--;
            FLIGHTTIME--;
        } else {
            if (fallFlyingA >= 10) {
                player.stopFallFlying();
            }
        }
    }


    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {

        World world = entity.getWorld();
        boolean isActive = false;
        PlayerEntity player = (PlayerEntity) entity;
        if (world.isClient()) {
            boolean isGrounded = player.isOnGround();
            boolean isJumping = MinecraftClient.getInstance().options.jumpKey.isPressed();
            Vec3d v = player.getVelocity();
            double yVelocity = v.getY();

            // rocket flight
            if (player.isSwimming() && player.isInSwimmingPose()) {
                player.addVelocity(0, 0, 0);
            } else if (player.isSubmergedInWater() && isJumping) {
                player.setVelocity(v.getX(), (yVelocity * 0.9) + 0.01, v.getZ());
            } else if (player.isOnGround() || player.hasVehicle()) {
                jumpCount = getMultiJumps();
                fallFlyingA = 0;
            } else if (isJumping && !isGrounded && !player.isClimbing() && FLIGHTTIME >= 0) {
                if (!jumpKey && jumpCount > 0 && yVelocity < 0.333) {
                    fly(player, yVelocity, v);
                } else if (jumpCount <= 0) {
                    fly(player, yVelocity, v);
                    isActive = true;
                }
                jumpKey = true;
            } else {
                jumpKey = false;
                isActive = false;
            }
            // add flight time while not rocket flying
            if (FLIGHTTIME > -10) {
                FLIGHTTIME += 0.15;
            }
            if (FLIGHTTIME > flightTimeMax) {
                FLIGHTTIME = flightTimeMax;
            }
        }

        if (isActive) {
            RocketBootsParticles.spawnRocketParticles(player, world);
        }
        player.fallDistance = 0.0F;

        super.tick(stack, slot, entity);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        FLIGHTTIME += 0.15;
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