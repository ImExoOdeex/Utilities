package imexoodeex.utilities.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import imexoodeex.utilities.client.particles.HealParticles;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BandOfRegeneration extends TrinketItem {
    public BandOfRegeneration(Settings settings) {
        super(settings);
    }

    int a = 0;
    public void resetTimer() {
        a = 0;
    }
    private int activeValue = 400;

    private void heal(PlayerEntity player) {
        player.setHealth(player.getHealth() + 1.0f);
        World world = player.world;
        HealParticles.spawnHealParticles(player, world);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {

        a += 1;
        PlayerEntity player = (PlayerEntity) entity;
        if (a >= activeValue) {
            heal(player);
            resetTimer();
            player.getItemCooldownManager().set(stack.getItem(), activeValue / 2);
        }

        super.tick(stack, slot, entity);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new TranslatableText(getClass().getSimpleName()).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
