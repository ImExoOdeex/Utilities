package imexoodeex.supplementaryaccessories.client;

import imexoodeex.supplementaryaccessories.registers.ParticleRegister;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SupplementaryAccessoriesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //overspeed particle
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier("spectreboots", "particle/overspeed"));
        }));
        ParticleFactoryRegistry.getInstance().register(ParticleRegister.OVERSPEED, FlameParticle.Factory::new);

        //second overspeed particle
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier("spectreboots", "particle/second_overspeed"));
        }));
        ParticleFactoryRegistry.getInstance().register(ParticleRegister.SEC0ND_OVERSPEED, FlameParticle.Factory::new);

        //purple piece
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier("spectreboots", "particle/purple_piece"));
        }));
        ParticleFactoryRegistry.getInstance().register(ParticleRegister.PURPLE_PIECE, FlameParticle.Factory::new);

        //pink piece
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier("spectreboots", "particle/pink_piece"));
        }));
        ParticleFactoryRegistry.getInstance().register(ParticleRegister.PINK_PIECE, FlameParticle.Factory::new);

        //green piece
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier("spectreboots", "particle/green_piece"));
        }));
        ParticleFactoryRegistry.getInstance().register(ParticleRegister.GREEN_PIECE, FlameParticle.Factory::new);
    }
}
