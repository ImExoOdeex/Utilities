package imexoodeex.supplementaryaccessories.items.trinkets;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotAttributes;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
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

public class Radar extends TrinketItem {
    public Radar(Settings settings) {
        super(settings);
    }

    public static String text = null;
    public static boolean isEquipped = false;
    String closestEntityName = null;
    float distanceTraveled = 0;

    public String setText(World world, Entity entity) {

//        get all entities in a radius of 5 blocks by using getEntitiesByType
//        List<Entity> entities = world.getEntitiesByType(TypeFilter.instanceOf(Entity.class), entity.getBoundingBox().expand(5, 5, 5), Predicate.isEqual(entity));
//        List<Entity> entitiesInRadius = new ArrayList<>();
//        for (Entity entity1 : entities) {
//            if (entity1.getPos().distanceTo(pos) < 5) {
//                entitiesInRadius.add(entity1);
//            }
//        }
//
//        text = "Closest Player: " + entitiesInRadius.get(1).getName().asString();
        LivingEntity livingEntity = (LivingEntity) entity;
        PlayerEntity player = (PlayerEntity) entity;
        Vec3d pos = player.getPos();

//        List<Entity> lol = world.getEntitiesByType((TypeFilter<Entity, Entity>) entity.getType(), new Box(player.getX() - 10, player.getY() - 10, player.getZ() - 10, player.getX() + 10, player.getY() + 10, player.getZ() + 10), EntityPredicates.VALID_ENTITY);


//        List<Entity> entities = world.getEntitiesByType(TypeFilter.instanceOf(Entity.class), entity.getBoundingBox().expand(10, 10, 10), null);
//        List<Entity> entityList = world.getEntitiesByClass(Entity.class, player.getBoundingBox().expand(100, 100, 100), null);
//        List<Entity> entityList1 = world.getOtherEntities(null, player.getBoundingBox().expand(100, 100, 100), Predicate.isEqual(entity));

//        final PlayerEntity closestPlayer = world.getClosestPlayer(player.getX(), player.getY(), player.getZ(), 4.4, true);
////        final PlayerEntity closestEntity = world.getClosestEntity(entities, TargetPredicate.DEFAULT, livingEntity, player.getX(),player.getY(), player.getZ(), player.getBoundingBox().expand(4.4, 4.4, 4.4));
//
//        if (!world.isClient()) {
//            text = "entities around: " + ((ServerWorld)world).getEntitiesByType(entity.getType(), EntityPredicates.VALID_ENTITY).size();
//        }
//
//        if (!world.isClient()) {
//            LOGGER.info("entities around: ");
//        }
        // FUCK IT

        String expLvlString = "";

        int totalExpLvl = player.experienceLevel;
        float expLvl = player.experienceProgress;

        int expProgFix = (int) (expLvl * 100);
        expLvlString = String.valueOf(expProgFix);
        if (expProgFix < 10) {
            expLvlString = "0" + expProgFix;
        }

        if (world.isClient()) {
            distanceTraveled = player.distanceTraveled;
        }

//        text = "Total distance: " + (int) distanceTraveled + " blocks";
        text = "Experience: " + totalExpLvl + "." + expLvlString;

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
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        var modifiers = super.getModifiers(stack, slot, entity, uuid);
        SlotAttributes.addSlotModifier(modifiers, "hand/wrist", uuid, 1, EntityAttributeModifier.Operation.ADDITION);
        return modifiers;
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

