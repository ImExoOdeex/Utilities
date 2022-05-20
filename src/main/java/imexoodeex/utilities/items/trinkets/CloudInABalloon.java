package imexoodeex.utilities.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import imexoodeex.utilities.client.particles.CloudInABottleParticles;
import imexoodeex.utilities.sounds.SASounds;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static imexoodeex.utilities.items.trinkets.Balloon.add;

public class CloudInABalloon extends TrinketItem {
    public CloudInABalloon(Settings settings) {
        super(settings);
    }

    private static int jumpCount = 0;
    private static boolean jumpKey = false;

    private static int getMultiJumps() {
        jumpCount = 1;

        return jumpCount;
    }

    private static boolean isHolding = false;


    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {

        boolean isJumping = MinecraftClient.getInstance().options.jumpKey.isPressed();
        Vec3d v = entity.getVelocity();
        double yVelocity = v.getY();
        World world = entity.world;
        PlayerEntity player = (PlayerEntity) entity;

        // double jump
        if (entity.isOnGround() || entity.hasVehicle()) {
            jumpCount = getMultiJumps();
        } else if (isJumping) {
            if (!jumpKey && jumpCount > 0 && yVelocity < 0.333) {
                player.jump();
                player.playSound(SASounds.CLOUD_SOUND, 1.0F, 1.0F);
                world.playSound(player.getX(), player.getY(), player.getZ(), SASounds.CLOUD_SOUND, SoundCategory.PLAYERS, 1.0F, 1.0F, false);
                CloudInABottleParticles.spawnCloudParticles(entity, world);
                entity.fallDistance = 0.0F;
                jumpCount--;
            }
            jumpKey = true;
        } else {
            jumpKey = false;
        }

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
        boolean isJumping = MinecraftClient.getInstance().options.jumpKey.isPressed();
        LivingEntity entity1 = (LivingEntity) entity;
        Vec3d v = entity.getVelocity();
        double yVelocity = v.getY();

        PlayerEntity player = (PlayerEntity) entity;
        if (selected && !isHolding) {
            Vec3d vec = player.getVelocity();
            if (!player.isSneaking()) {
                player.setVelocity(vec.x, vec.y + add, vec.z);
                entity.fallDistance *= 0.5f;
            }
            // double jump
            if (entity.isOnGround() || entity.hasVehicle()) {
                jumpCount = getMultiJumps();
            } else if (isJumping) {
                if (!jumpKey && jumpCount > 0 && yVelocity < 0.333) {
                    player.jump();
                    player.playSound(SASounds.CLOUD_SOUND, 1.0F, 1.0F);
                    world.playSound(player.getX(), player.getY(), player.getZ(), SASounds.CLOUD_SOUND, SoundCategory.PLAYERS, 1.0F, 1.0F, false);
                    CloudInABottleParticles.spawnCloudParticles(entity1, world);
                    entity.fallDistance = 0.0F;
                    jumpCount--;
                }
                jumpKey = true;
            } else {
                jumpKey = false;
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new TranslatableText(getClass().getSimpleName()).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }

}
