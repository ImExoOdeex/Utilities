package imexoodeex.supplementaryaccessories;

import imexoodeex.supplementaryaccessories.config.ModConfigs;
import imexoodeex.supplementaryaccessories.config.SAConfigs;
import imexoodeex.supplementaryaccessories.registers.CustomVillagerTranesRegister;
import imexoodeex.supplementaryaccessories.registers.ItemRegister;
import imexoodeex.supplementaryaccessories.registers.ParticleRegister;
import imexoodeex.supplementaryaccessories.registers.SoundsRegister;
import imexoodeex.supplementaryaccessories.util.LootTablesModify;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SupplementaryAccessories implements ModInitializer {
    public static final String MOD_ID = "supplementaryaccessories";
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        ModConfigs.registerConfigs();
        ItemRegister.registerSAItems();
        ParticleRegister.registerParticle();
        SoundsRegister.registerSounds();
        CustomVillagerTranesRegister.registerVillagerTrades();
        LootTablesModify.modifyLootTables();
    }
}
