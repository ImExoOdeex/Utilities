package imexoodeex.supplementaryaccessories.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Blindfold extends TrinketItem {

    public Blindfold(Settings settings) {
        super(settings);
    }


    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {

        if (entity.hasStatusEffect(StatusEffects.BLINDNESS)) {

            entity.removeStatusEffect(StatusEffects.BLINDNESS);
            // TODO: in 1.19 add darkness effect

        }
        super.tick(stack, slot, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new TranslatableText(getClass().getSimpleName()).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}