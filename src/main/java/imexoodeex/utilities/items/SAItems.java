package imexoodeex.utilities.items;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static imexoodeex.utilities.utilities.MOD_ID;

public class SAItems extends Item {

    public SAItems(Settings settings) {
        super(settings);
    }

    public static Item registerItems(String itemName, Item item) {
        Registry.register(Registries.ITEM, createIdentifier(itemName), item);
        return item;
    }

    public static Identifier createIdentifier(String name) {
        return new Identifier(MOD_ID, name);
    }
}
