package imexoodeex.supplementaryaccessories.registers;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static imexoodeex.supplementaryaccessories.SupplementaryAccessories.MOD_ID;

public class ParticleRegister {

    public static final DefaultParticleType OVERSPEED = FabricParticleTypes.simple();
    public static final DefaultParticleType SEC0ND_OVERSPEED = FabricParticleTypes.simple();
    public static final DefaultParticleType PURPLE_PIECE = FabricParticleTypes.simple();
    public static final DefaultParticleType PINK_PIECE = FabricParticleTypes.simple();
    public static final DefaultParticleType GREEN_PIECE = FabricParticleTypes.simple();

    public static void registerParticle() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(MOD_ID, "overspeed"), OVERSPEED);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(MOD_ID, "second_overspeed"), SEC0ND_OVERSPEED);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(MOD_ID, "purple_piece"), PURPLE_PIECE);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(MOD_ID, "pink_piece"), PINK_PIECE);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(MOD_ID, "green_piece"), GREEN_PIECE);
    }
}
