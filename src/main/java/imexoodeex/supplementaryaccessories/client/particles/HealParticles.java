package imexoodeex.supplementaryaccessories.client.particles;

import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3f;
import net.minecraft.world.World;

import java.util.Random;

public class HealParticles {

    private static Random rand = new Random();

    public static void spawnHealParticles(LivingEntity entity, World world) {
        float yBodyRot = entity.getYaw();

        Vec3d playerPos = entity.getPos();
        float random = (rand.nextFloat() - 0.05F) * 0.01F;

        Vec3d vUp = new Vec3d(0.33, 0, 0).rotateX(0).rotateY((yBodyRot / -57.295f));
        Vec3d up = playerPos.add(vUp).add(new Vec3d(new Vec3f(entity.getVelocity().multiply(0.01D))));

        spawnParticles(random, world, up);
    }

    private static void spawnParticles(float random, World world, Vec3d up) {
        world.addParticle(ParticleTypes.HEART, up.x, up.y + 2D, up.z, random, 0.07D, random);
    }
}
