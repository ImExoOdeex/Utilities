package imexoodeex.utilities.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ObsidianHorseshoe extends TrinketItem {
    public ObsidianHorseshoe(Settings settings) {
        super(settings);
    }

    public static boolean isEquipped = false;

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        entity.fallDistance = entity.fallDistance * 0.8f;
        super.tick(stack, slot, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable(getClass().getSimpleName()).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        isEquipped = true;
        super.onEquip(stack, slot, entity);
    }
    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        isEquipped = false;
        super.onUnequip(stack, slot, entity);
    }
}
