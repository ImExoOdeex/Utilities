package imexoodeex.supplementaryaccessories.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Radar extends TrinketItem {
    public Radar(Settings settings) {
        super(settings);
    }

    public static String text = null;
    public static boolean isEquipped = false;
    String closestEntityName = null;

    public String setText(World world, Entity entity) {
        Vec3d pos = entity.getPos();

        //get all entities in a radius of 5 blocks by using getEntitiesByType
//        List<Entity> entities = world.getEntitiesByType(TypeFilter.instanceOf(Entity.class), entity.getBoundingBox().expand(5, 5, 5), Predicate.isEqual(entity));
//        List<Entity> entitiesInRadius = new ArrayList<>();
//        for (Entity entity1 : entities) {
//            if (entity1.getPos().distanceTo(pos) < 5) {
//                entitiesInRadius.add(entity1);
//            }
//        }

//        text = "Closest Player: " + entitiesInRadius.get(1).getName().asString();

        text = "masz małego huja";
        return text;
    }


    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        World world = entity.world;

        isEquipped = true;
        setText(world, entity);

        super.tick(stack, slot, entity);
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {

        isEquipped = false;

        super.onUnequip(stack, slot, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText(getClass().getSimpleName()).formatted(Formatting.GRAY));
        if (isEquipped) {
            tooltip.add(new TranslatableText("on").formatted(Formatting.GRAY));
        } else {
            tooltip.add(new TranslatableText("off").formatted(Formatting.GRAY));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}

