package imexoodeex.utilities.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import imexoodeex.utilities.client.particles.CloudInABottleParticles;
import imexoodeex.utilities.sounds.SASounds;
import imexoodeex.utilities.utilities;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static imexoodeex.utilities.utilities.LOGGER;

public class CloudInABottle extends TrinketItem {
    public CloudInABottle(Settings settings) {
        super(settings);
    }

    private static int jumpCount = 0;
    private static boolean jumpKey = false;
    public static int a = 0;

    private static int getMultiJumps() {
        int jumpCount = 0;
        jumpCount += 1;

        return jumpCount;
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {

        Vec3d v = entity.getVelocity();
        double yVelocity = v.getY();
        boolean isActive = false;

        World world = entity.world;
        PlayerEntity player = (PlayerEntity) entity;


        // double jump
        /*
         *
         *
         * a little of double jump logic borrowed from https://github.com/genandnic/Wall-Jump/blob/1.18.1/src/main/java/genandnic/walljump/client/DoubleJumpLogic.java
         *
         *
         * */

        if (world.isClient()) {
            boolean isJumping = MinecraftClient.getInstance().options.jumpKey.isPressed();
            if (entity.isOnGround() || entity.hasVehicle()) {
                jumpCount = getMultiJumps();
            } else if (isJumping) {
                if (!jumpKey && jumpCount > 0 && yVelocity < 0.333 && a == 0) {
                    player.jump();
                    player.playSound(SoundEvents.ENTITY_GOAT_LONG_JUMP, 1.0F, 1.0F);
                    world.playSound(player.getX(), player.getY(), player.getZ(), SASounds.CLOUD_SOUND, SoundCategory.PLAYERS, 1.0F, 1.0F, false);
                    CloudInABottleParticles.spawnCloudParticles(entity, world);
                    isActive = true;
                    jumpCount--;
                    a = utilities.CONFIG.cooldown;
                }
                jumpKey = true;
            } else {
                isActive = false;
                jumpKey = false;
            }
            a--;
            if (a <= 0) {
                a = 0;
            }
            LOGGER.info("a: " + a);
        }

        if (isActive) {
            player.fallDistance = 0.0F;
            if (world.isClient()) {
                LOGGER.info("isActive: " + isActive);
            }
        }

        super.tick(stack, slot, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText(getClass().getSimpleName()).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
