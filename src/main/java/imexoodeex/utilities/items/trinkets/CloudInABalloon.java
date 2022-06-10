package imexoodeex.utilities.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import imexoodeex.utilities.client.particles.CloudInABottleParticles;
import imexoodeex.utilities.sounds.SASounds;
import imexoodeex.utilities.utilities;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
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

public class CloudInABalloon extends TrinketItem {
    public CloudInABalloon(Settings settings) {
        super(settings);
    }

    private static int jumpCount = 0;
    private static boolean jumpKey = false;
    public static int a = 0;
    public static boolean isSelected = false;
    private static int getMultiJumps() {
        jumpCount = 1;
        return jumpCount;
    }

    private static boolean isHolding = false;


    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {

        Vec3d v = entity.getVelocity();
        double yVelocity = v.getY();
        World world = entity.world;
        PlayerEntity player = (PlayerEntity) entity;

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
                    jumpCount--;
                    a = utilities.CONFIG.cooldown;
                }
                jumpKey = true;
            } else {
                jumpKey = false;
            }
            a--;
            if (a <= 0) {
                a = 0;
            }
        }

        if (!player.isSneaking()) {
            player.addVelocity(0, 0.02, 0);
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
        Vec3d v = entity.getVelocity();
        double yVelocity = v.getY();

        PlayerEntity player = (PlayerEntity) entity;
        if (selected && !isHolding && !player.isSneaking() && !player.isSubmergedInWater() && !player.isFallFlying() && !player.getAbilities().flying) {
            isSelected = true;
            if (!player.isSneaking()) {
                player.addVelocity(0, 0.02, 0);
                entity.fallDistance *= 0.5f;
            }

            // double jump
            if (world.isClient()) {
                boolean isJumping = MinecraftClient.getInstance().options.jumpKey.isPressed();
                if (entity.isOnGround() || entity.hasVehicle()) {
                    jumpCount = getMultiJumps();
                } else if (isJumping) {
                    if (!jumpKey && jumpCount > 0 && yVelocity < 0.333 && a == 0) {
                        player.jump();
                        player.playSound(SoundEvents.ENTITY_GOAT_LONG_JUMP, 1.0F, 1.0F);
                        world.playSound(player.getX(), player.getY(), player.getZ(), SASounds.CLOUD_SOUND, SoundCategory.PLAYERS, 1.0F, 1.0F, false);
                        CloudInABottleParticles.spawnCloudParticles((LivingEntity) entity, world);
                        jumpCount--;
                        a = utilities.CONFIG.cooldown;
                    }
                    jumpKey = true;
                } else {
                    jumpKey = false;
                }
                a--;
                if (a <= 0) {
                    a = 0;
                }
            }
        } else {
            isSelected = false;
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        isSelected = false;
        super.onEquip(stack, slot, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText(getClass().getSimpleName()).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }

}
