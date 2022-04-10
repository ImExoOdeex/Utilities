package imexoodeex.supplementaryaccessories.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import imexoodeex.supplementaryaccessories.client.particles.HealParticles;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static imexoodeex.supplementaryaccessories.SupplementaryAccessories.*;

public class BandOfRegeneration extends TrinketItem {
    public BandOfRegeneration(Settings settings) {
        super(settings);
    }

    int a = 0;
    public void resetTimer() {
        a = 0;
    }

    private void heal(PlayerEntity player) {
        player.setHealth(player.getHealth() + 1.0f);

        World world = player.world;
        world.addParticle(ParticleTypes.HEART, player.getX(), player.getY() + 2D, player.getZ(), 0, 0.07D, 0);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {

        a += 1;
        PlayerEntity player = (PlayerEntity) entity;
        if (a >= 200) {
            heal(player);
            a = 0;
        }

        super.tick(stack, slot, entity);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new TranslatableText(getClass().getSimpleName()).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
