package imexoodeex.utilities.util;

import imexoodeex.utilities.utilities;
import imexoodeex.utilities.registers.ItemRegister;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup SUPPLEMENTARY_ACCESSORIES = FabricItemGroupBuilder.build(
            new Identifier(utilities.MOD_ID, "utilities"),
            () -> new ItemStack(ItemRegister.balloon));
}
