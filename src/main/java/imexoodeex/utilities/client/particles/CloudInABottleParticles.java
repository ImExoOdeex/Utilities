package imexoodeex.utilities.client.particles;

import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3f;
import net.minecraft.world.World;

import java.util.Random;

public class CloudInABottleParticles {

    private static Random rand = new Random();

    public static void spawnCloudParticles(LivingEntity entity, World world) {
        float yBodyRot = entity.getYaw();

        Vec3d playerPos = entity.getPos();
        float random = (rand.nextFloat() - 0.05F) * 0.01F;

        Vec3d vLeft = new Vec3d(-0.2, 0 , 0 ).rotateX(0).rotateY((yBodyRot / -57.295f));
        Vec3d vRight = new Vec3d(0.2, 0 , 0 ).rotateX(0).rotateY((yBodyRot / -57.295f));

        Vec3d right = playerPos.add(vRight).add(new Vec3d(new Vec3f(entity.getVelocity().multiply(0.01D))));
        Vec3d left = playerPos.add(vLeft).add(new Vec3d(new Vec3f(entity.getVelocity().multiply(0.01D))));

        spawnParticles(entity, random, world, left, right);
    }

    private static void spawnParticles(LivingEntity entity, float random, World world, Vec3d left, Vec3d right) {
        boolean isSneaking = entity.isSneaking();
        if (!entity.isSubmergedInWater() && !isSneaking) {
            for (int i = 0; i < 10; i++) {
                world.addParticle(ParticleTypes.CLOUD, left.x, left.y + 0.1D, left.z, random, -0.01D, random);
                world.addParticle(ParticleTypes.CLOUD, left.x, left.y + 0.1D, left.z, random, -0.01D, random);
                world.addParticle(ParticleTypes.CLOUD, right.x, right.y, right.z + 0.1D, random, -0.01D, random);
                world.addParticle(ParticleTypes.CLOUD, right.x, right.y, right.z + 0.1D, random, -0.01D, random);
            }
        } else if (entity.isSubmergedInWater()) {
            world.addParticle(ParticleTypes.BUBBLE, left.x, left.y, left.z, random, 0.0D, random);
            world.addParticle(ParticleTypes.BUBBLE, right.x, right.y, right.z, random, 0.0D, random);
        }
    }

}
