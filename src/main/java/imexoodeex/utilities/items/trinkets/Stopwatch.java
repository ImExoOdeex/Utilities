package imexoodeex.utilities.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import imexoodeex.utilities.config.ClothConfig;
import imexoodeex.utilities.utilities;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.text.DecimalFormat;
import java.util.List;

public class Stopwatch extends TrinketItem {

    public Stopwatch(Settings settings) {
        super(settings);
    }

    public static String text = "";
    public static String text1 = "";
    int a = 0;
    String unit = "";

    Vec3d lastPos = new Vec3d(0, 0, 0);

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {

        World world = entity.world;
        if (world.isClient()) {

            DecimalFormat dec = new DecimalFormat("#0.00");
            PlayerEntity player = (PlayerEntity) entity;
            Vec3d pos = player.getPos();
            a++;

            if (a > 20) {
                a = 0;
            }

            if (a == 0) {
                lastPos = player.getPos();
            }

            double distance = lastPos.distanceTo(pos);

            if (utilities.CONFIG.unit == ClothConfig.UNIT.KPH) {
                distance *= 3.6;
                unit = "km/h";
            } else if (utilities.CONFIG.unit == ClothConfig.UNIT.MPS) {
                distance *= 1;
                unit = "m/s";
            } else if (utilities.CONFIG.unit == ClothConfig.UNIT.MPH) {
                distance *= 2.23;
                unit = "mph";
            }

            String formattedSpeed = dec.format(distance);

            if (a == 20) {
                text = formattedSpeed + " " + unit;
            }
        }


        super.tick(stack, slot, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable(getClass().getSimpleName()).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
