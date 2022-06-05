package imexoodeex.utilities;

import com.mojang.blaze3d.systems.RenderSystem;
import imexoodeex.utilities.config.ClothConfig;
import imexoodeex.utilities.registers.CustomVillagerTranesRegister;
import imexoodeex.utilities.registers.ItemRegister;
import imexoodeex.utilities.registers.ParticleRegister;
import imexoodeex.utilities.registers.SoundsRegister;
import imexoodeex.utilities.util.LootTablesModify;
import imexoodeex.utilities.util.TimesBars;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.GameRenderer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class utilities implements ModInitializer {
    public static final String MOD_ID = "utilities";
    public static final Logger LOGGER = LogManager.getLogger();
    public static ClothConfig CONFIG;
    public static TimesBars renderer;

    @Override
    public void onInitialize() {
        //Register Config
        AutoConfig.register(ClothConfig.class, GsonConfigSerializer::new);
        //Read the config file
        CONFIG = AutoConfig.getConfigHolder(ClothConfig.class).getConfig();
        //Change allow-flight to true due to rocket flight on server
        ServerLifecycleEvents.SERVER_STARTED.register(server->server.setFlightEnabled(true));
        //register renderer
        renderer = new TimesBars() {
            @Override
            protected void renderGuiQuad(BufferBuilder buffer, int x, int y, int width, int height, int red, int green, int blue, int alpha) {
                RenderSystem.setShader(GameRenderer::getPositionColorShader);
                buffer.vertex(x, y + height, 0).color(red, green, blue, alpha).next();
                buffer.vertex(x + width, y + height, 0).color(red, green, blue, alpha).next();
                buffer.vertex(x + width, y, 0).color(red, green, blue, alpha).next();
                buffer.vertex(x, y, 0).color(red, green, blue, alpha).next();
                buffer.end();
                BufferRenderer.draw(buffer);
            }
        };

        ItemRegister.registerSAItems();
        ParticleRegister.registerParticle();
        SoundsRegister.registerSounds();
        CustomVillagerTranesRegister.registerVillagerTrades();
        LootTablesModify.modifyLootTables();

    }
}
