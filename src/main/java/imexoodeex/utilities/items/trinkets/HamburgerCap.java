package imexoodeex.utilities.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HamburgerCap extends TrinketItem {
    public HamburgerCap(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {

        if (entity.hasStatusEffect(StatusEffects.HUNGER)) {
            entity.removeStatusEffect(StatusEffects.HUNGER);
        }

        super.tick(stack, slot, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable(getClass().getSimpleName()).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
