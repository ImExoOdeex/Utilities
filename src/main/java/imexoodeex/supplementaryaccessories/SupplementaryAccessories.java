package imexoodeex.supplementaryaccessories;

import imexoodeex.supplementaryaccessories.registers.ItemRegister;
import imexoodeex.supplementaryaccessories.registers.ParticleRegister;
import imexoodeex.supplementaryaccessories.registers.SoundsRegister;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SupplementaryAccessories implements ModInitializer {
    public static final String MOD_ID = "supplementaryaccessories";
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        ItemRegister.init();
        ParticleRegister.registerParticle();
        SoundsRegister.registerSounds();
    }
}
