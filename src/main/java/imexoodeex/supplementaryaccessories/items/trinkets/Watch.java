package imexoodeex.supplementaryaccessories.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Watch extends TrinketItem {
    public Watch(Settings settings) {
        super(settings);
    }

    public static boolean isEquipped = false;
    public static String text = "null";

    public String setText(LivingEntity entity) {
        World world = entity.world;
        text = "Watch: " + (world.isDay() ? "Day" : "Night");
        return text;
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {

        isEquipped = true;
        setText(entity);

        super.tick(stack, slot, entity);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        isEquipped = true;
        setText((LivingEntity) entity);

        super.inventoryTick(stack, world, entity, slot, selected);
    }


    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {

        isEquipped = false;

        super.onUnequip(stack, slot, entity);
    }
}
