package imexoodeex.supplementaryaccessories.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import imexoodeex.supplementaryaccessories.client.particles.HermesBootsParticles;
import imexoodeex.supplementaryaccessories.client.particles.SpectreBootsParticles;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
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

import static imexoodeex.supplementaryaccessories.SupplementaryAccessories.*;

public class SpectreBoots extends TrinketItem {

    public SpectreBoots(Settings settings) {
        super(settings);
    }

    static int a = 0;

    public static int getFlightTime() {
        return a;
    }

    private void resetTimer() {
        a = 0;
    }
    private final int activeValue = 15;

    /* 20 tick is 1 second, so 7 * 1 sec is 7 seconds of flying*/
    public static double FLIGHTTIME = 7 * 20;
    private final double flightTimeMax = 7 * 20;

    private static int jumpCount = 0;
    private static boolean jumpKey = false;

    private static int getMultiJumps() {
        int jumpCount = 0;
        jumpCount += 1;

        return jumpCount;
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {

        boolean isSprinting = entity.isSprinting();
        boolean isGrounded = entity.isOnGround();
        boolean isJumping = MinecraftClient.getInstance().options.jumpKey.isPressed();
        boolean wasJumping = MinecraftClient.getInstance().options.jumpKey.wasPressed();
        boolean isRocketFlying = isJumping && !isGrounded && !entity.isClimbing() && a >= activeValue;
        Vec3d v = entity.getVelocity();
        double yVelocity = v.getY();

        World world = entity.world;

        PlayerEntity player = (PlayerEntity) entity ;
        if (entity.isOnGround() || entity.hasVehicle()) {
            jumpCount = getMultiJumps();
        } else if (isJumping) {
            if (!jumpKey && jumpCount > 0 && yVelocity < 0.333) {
//                    player.jump();
                entity.setVelocity(v.getX(), 0.5, v.getZ());
                SpectreBootsParticles.spawnRocketParticles(entity, world);
//                    FLIGHTTIME--;
//                    LOGGER.info("Double Jump----------------------------------------------------------------------------------------------------------------------");
                entity.fallDistance = 0.0F;
                jumpCount--;
            }
            jumpKey = true;
        } else {
            jumpKey = false;
        }

        if (world.isClient()) {
            LOGGER.info("is jumping: " + isJumping + "     ||     is grounded: " + isGrounded + "     ||     jump key: " + jumpKey + "     ||     jump count: " + jumpCount + "     ||     flight time: " + FLIGHTTIME);
        }

        if (isSprinting && isGrounded) {
            HermesBootsParticles.spawnRocketParticles(entity, world);
        }

        if ((isJumping) || !isGrounded) {
            a++;
        } else {
            resetTimer();
        }

        String rf = "|||||||||||||||||||||||||||||||";
        if (a < activeValue || !isJumping || entity.isClimbing()) {
            FLIGHTTIME += 0.2;
            rf = "REFILING";
        }

        if (isGrounded) {
            a = 0;
        }

        if (FLIGHTTIME > flightTimeMax) {
            FLIGHTTIME = flightTimeMax;
        }

        if (FLIGHTTIME < 0) {
            resetTimer();
        }

        super.tick(stack, slot, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new TranslatableText(getClass().getSimpleName()).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
