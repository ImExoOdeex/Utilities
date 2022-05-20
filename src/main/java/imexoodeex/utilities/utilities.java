package imexoodeex.utilities;

import imexoodeex.utilities.config.ClothConfig;
import imexoodeex.utilities.registers.CustomVillagerTranesRegister;
import imexoodeex.utilities.registers.ItemRegister;
import imexoodeex.utilities.registers.ParticleRegister;
import imexoodeex.utilities.registers.SoundsRegister;
import imexoodeex.utilities.util.LootTablesModify;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class utilities implements ModInitializer {
    public static final String MOD_ID = "utilities";
    public static final Logger LOGGER = LogManager.getLogger();
    public static ClothConfig CONFIG;

    @Override
    public void onInitialize() {

        AutoConfig.register(ClothConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(ClothConfig.class).getConfig();

        ItemRegister.registerSAItems();
        ParticleRegister.registerParticle();
        SoundsRegister.registerSounds();
        CustomVillagerTranesRegister.registerVillagerTrades();
        LootTablesModify.modifyLootTables();
    }
}
