package imexoodeex.utilities.registers;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class CustomVillagerTranesRegister {

    //function to add fast new trades
    private static void registerTrades(int lvl, VillagerProfession pro, int in, int out, Item item, int uses, int exp, float priceMultiplier) {
        TradeOfferHelper.registerVillagerOffers(pro, lvl, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, in),
                    new ItemStack(item, out),
                    uses, exp, priceMultiplier)
            ));
        });
    }

    public static void registerVillagerTrades() {
        //ARMORER
        registerTrades(1, VillagerProfession.ARMORER, 28, 1, ItemRegister.hermes_boots, 1, 12, 0.02f);
        registerTrades(2, VillagerProfession.ARMORER, 36, 1, ItemRegister.rocket_boots, 1, 20, 0.02f);

        //TOOLSMITH
        registerTrades(1, VillagerProfession.TOOLSMITH, 22, 1, ItemRegister.horseshoe, 1, 8, 0.02f);
        registerTrades(2, VillagerProfession.TOOLSMITH, 34, 1, ItemRegister.combatshield, 1, 12, 0.02f);

        //CARTOGRAPHER
        registerTrades(1, VillagerProfession.CARTOGRAPHER, 12, 1, ItemRegister.gps, 1, 11, 0.02f);
        registerTrades(2, VillagerProfession.CARTOGRAPHER, 26, 1, ItemRegister.radar, 1, 22, 0.04f);


    }
}
