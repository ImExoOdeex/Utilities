package imexoodeex.utilities.util;

import imexoodeex.utilities.utilities;
import imexoodeex.utilities.registers.ItemRegister;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup SUPPLEMENTARY_ACCESSORIES = FabricItemGroup.builder(new Identifier(utilities.MOD_ID, "group"))
            .icon(() -> new ItemStack(ItemRegister.balloon)).displayName(Text.literal("Utilities")).build();
}
