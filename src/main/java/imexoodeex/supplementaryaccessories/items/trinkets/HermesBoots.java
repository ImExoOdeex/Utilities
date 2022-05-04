package imexoodeex.supplementaryaccessories.items.trinkets;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import imexoodeex.supplementaryaccessories.client.particles.HermesBootsParticles;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class HermesBoots extends TrinketItem {

    public HermesBoots(Settings settings) {
        super(settings);
    }

    double value = 1.0;
    final double DefaultValue = 1.0;
    int a = 0;

    void resetTimer() {
        a = 0;
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        World world = entity.world;
        boolean isSprinting = entity.isSprinting();
        boolean isGrounded = entity.isOnGround();
        PlayerEntity player = (PlayerEntity) entity;
        Vec3d vec = player.getVelocity();

        if (entity.isSprinting()) {
            a++;
        } else if (!entity.isSprinting()) {
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
        if (isSprinting && isGrounded) {
            player.setVelocity(vec.getX() * value, vec.getY(), vec.getZ() * value);
            HermesBootsParticles.spawnRocketParticles(entity, world);
        }

        super.tick(stack, slot, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText(getClass().getSimpleName()).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
