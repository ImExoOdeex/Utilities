package imexoodeex.utilities.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Mask extends TrinketItem {
    public Mask(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {

        if (entity.isSneaking() && entity.isOnGround() && !entity.isTouchingWater()) {
//            change Attribute Modifier for generic_movement_speed to 1.15 multipy total
//            Objects.requireNonNull(entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED)).addPersistentModifier(new EntityAttributeModifier("generic_movement_speed", 1.15, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
//            LOGGER.info("SNEAKING");
            Vec3d vec = entity.getVelocity();
            entity.setVelocity(vec.x * 1.05, vec.y, vec.z * 1.05);
        }
        super.tick(stack, slot, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable(getClass().getSimpleName()).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
