package imexoodeex.utilities;

import imexoodeex.utilities.config.ClothConfig;
import imexoodeex.utilities.registers.CustomVillagerTranesRegister;
import imexoodeex.utilities.registers.ItemRegister;
import imexoodeex.utilities.registers.ParticleRegister;
import imexoodeex.utilities.registers.SoundsRegister;
import imexoodeex.utilities.screen.RenderFinalBars;
import imexoodeex.utilities.screen.RendererBars;
import imexoodeex.utilities.util.LootTablesModify;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class utilities implements ModInitializer {
    public static final String MOD_ID = "utilities";
    public static final Logger LOGGER = LogManager.getLogger();
    public static ClothConfig CONFIG;
    public static RendererBars renderer;

    @Override
    public void onInitialize() {
        //Register Config
        AutoConfig.register(ClothConfig.class, GsonConfigSerializer::new);
        //Read the config file
        CONFIG = AutoConfig.getConfigHolder(ClothConfig.class).getConfig();
        //Change allow-flight to true due to rocket flight on server
        ServerLifecycleEvents.SERVER_STARTED.register(server->server.setFlightEnabled(true));
        //register renderer
        renderer = new RenderFinalBars();

        ItemRegister.registerSAItems();
        ParticleRegister.registerParticle();
        SoundsRegister.registerSounds();
        CustomVillagerTranesRegister.registerVillagerTrades();
        LootTablesModify.modifyLootTables();

    }
}
