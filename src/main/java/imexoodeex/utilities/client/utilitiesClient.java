package imexoodeex.utilities.client;

import imexoodeex.utilities.registers.ParticleRegister;
import imexoodeex.utilities.screen.RenderFinalBars;
import imexoodeex.utilities.screen.RendererBars;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.FlameParticle;

@Environment(EnvType.CLIENT)
public class utilitiesClient implements ClientModInitializer {

    public static RendererBars renderer;
    @Override
    public void onInitializeClient() {

        //overspeed particle
//        .event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
//            registry.register(new Identifier("utilities", "particle/overspeed"));
//        }));
//        ParticleFactoryRegistry.getInstance().register(ParticleRegister.OVERSPEED, FlameParticle.Factory::new);
//
//        //second overspeed particle
//        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
//            registry.register(new Identifier("utilities", "particle/second_overspeed"));
//        }));
//        ParticleFactoryRegistry.getInstance().register(ParticleRegister.SEC0ND_OVERSPEED, FlameParticle.Factory::new);
//
//        //purple piece
//        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
//            registry.register(new Identifier("utilities", "particle/purple_piece"));
//        }));
//        ParticleFactoryRegistry.getInstance().register(ParticleRegister.PURPLE_PIECE, FlameParticle.Factory::new);
//
//        //pink piece
//        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
//            registry.register(new Identifier("utilities", "particle/pink_piece"));
//        }));
//        ParticleFactoryRegistry.getInstance().register(ParticleRegister.PINK_PIECE, FlameParticle.Factory::new);
//
//        //green piece
//        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
//            registry.register(new Identifier("utilities", "particle/green_piece"));
//        }));
        ParticleFactoryRegistry.getInstance().register(ParticleRegister.GREEN_PIECE, FlameParticle.Factory::new);

        //register renderer
        renderer = new RenderFinalBars();
    }
}
