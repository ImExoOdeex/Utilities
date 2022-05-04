package imexoodeex.supplementaryaccessories.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import imexoodeex.supplementaryaccessories.client.particles.CloudInABottleParticles;
import imexoodeex.supplementaryaccessories.sounds.SASounds;
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

import static imexoodeex.supplementaryaccessories.SupplementaryAccessories.LOGGER;

public class CloudInABottle extends TrinketItem {
    public CloudInABottle(Settings settings) {
        super(settings);
    }

    private static int jumpCount = 0;
    private static boolean jumpKey = false;

    private static int getMultiJumps() {
        int jumpCount = 0;
        jumpCount += 1;

        return jumpCount;
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {

        boolean isJumping = MinecraftClient.getInstance().options.jumpKey.isPressed();
        Vec3d v = entity.getVelocity();
        double yVelocity = v.getY();
        Vec3d pos = entity.getPos();

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

        if (entity.isOnGround() || entity.hasVehicle()) {
            jumpCount = getMultiJumps();
        } else if (isJumping) {
            if (!jumpKey && jumpCount > 0 && yVelocity < 0.333) {
                player.jump();
//                player.playSound(SASounds.CLOUD_SOUND, 1.0F, 1.0F);
                player.playSound(SoundEvents.ENTITY_GOAT_LONG_JUMP, 1.0F, 1.0F);
                world.playSound(player.getX(), player.getY(), player.getZ(), SASounds.CLOUD_SOUND, SoundCategory.PLAYERS, 1.0F, 1.0F, false);
                CloudInABottleParticles.spawnCloudParticles(entity, world);
                entity.fallDistance = 0.0F;
                jumpCount--;
            }
            jumpKey = true;
        } else {
            jumpKey = false;
        }

        LOGGER.info("Jump Count: " + jumpCount + " | Jump Key: " + jumpKey);
        super.tick(stack, slot, entity);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new TranslatableText(getClass().getSimpleName()).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
