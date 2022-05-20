package imexoodeex.utilities.items;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static imexoodeex.utilities.utilities.MOD_ID;

public class SAItems extends Item {

    public SAItems(Settings settings) {
        super(settings);
    }

    public static Item registerItems(String itemName, Item item) {
        Registry.register(Registry.ITEM, createIdentifier(itemName), item);
        return item;
    }

    public static Identifier createIdentifier(String name) {
        return new Identifier(MOD_ID, name);
    }
}
