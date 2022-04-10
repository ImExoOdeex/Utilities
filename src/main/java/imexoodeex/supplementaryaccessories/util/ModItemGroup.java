package imexoodeex.supplementaryaccessories.util;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import imexoodeex.supplementaryaccessories.SupplementaryAccessories;

public class ModItemGroup {
    public static final ItemGroup SUPPLEMENTARY_ACCESSORIES = FabricItemGroupBuilder.build(
            new Identifier(SupplementaryAccessories.MOD_ID, "supplementaryaccessories"),
            () -> new ItemStack(Items.LEATHER_BOOTS));
}
