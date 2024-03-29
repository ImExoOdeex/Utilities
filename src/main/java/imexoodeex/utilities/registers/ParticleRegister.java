package imexoodeex.utilities.registers;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static imexoodeex.utilities.utilities.MOD_ID;

public class ParticleRegister {

    public static final DefaultParticleType OVERSPEED = FabricParticleTypes.simple();
    public static final DefaultParticleType SEC0ND_OVERSPEED = FabricParticleTypes.simple();
    public static final DefaultParticleType PURPLE_PIECE = FabricParticleTypes.simple();
    public static final DefaultParticleType PINK_PIECE = FabricParticleTypes.simple();
    public static final DefaultParticleType GREEN_PIECE = FabricParticleTypes.simple();

    public static void registerParticle() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "overspeed"), OVERSPEED);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "second_overspeed"), SEC0ND_OVERSPEED);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "purple_piece"), PURPLE_PIECE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "pink_piece"), PINK_PIECE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "green_piece"), GREEN_PIECE);
    }
}
