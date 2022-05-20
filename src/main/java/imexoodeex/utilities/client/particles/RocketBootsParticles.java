package imexoodeex.utilities.client.particles;

import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3f;
import net.minecraft.world.World;

import java.util.Random;

public class RocketBootsParticles {


    public static void spawnRocketParticles(LivingEntity entity, World world) {
        Random rand = new Random();
        float yBodyRot = entity.getYaw();

        Vec3d playerPos = entity.getPos();
        float random = (rand.nextFloat() - 0.5F) * 0.1F;

        Vec3d vLeft = new Vec3d(-0.15, 0, 0).rotateX(0).rotateY((yBodyRot / -57.295f));
        Vec3d vRight = new Vec3d(0.15, 0, 0).rotateX(0).rotateY((yBodyRot / -57.295f));

        Vec3d right = playerPos.add(vRight).add(new Vec3d(new Vec3f(entity.getVelocity().multiply(0.01D))));
        Vec3d left = playerPos.add(vLeft).add(new Vec3d(new Vec3f(entity.getVelocity().multiply(0.01D))));

        spawnParticles(entity, random, world, left, right);
    }

    private static void spawnParticles(LivingEntity entity, float random, World world, Vec3d left, Vec3d right) {
        if (!entity.isSubmergedInWater()) {
            for (int i = 0; i < 16; i++) {
                //left
                world.addParticle(ParticleTypes.FLAME, left.x, left.y, left.z, random, -0.2D, random);
                world.addParticle(ParticleTypes.SMOKE, left.x, left.y - 0.1, left.z, random, -0.2D, random);
                //right
                world.addParticle(ParticleTypes.FLAME, right.x, right.y, right.z, random, -0.2D, random);
                world.addParticle(ParticleTypes.SMOKE, right.x, right.y - 0.1, right.z, random, -0.2D, random);
            }

        } else {
            for (int i = 0; i < 5; i++) {
                world.addParticle(ParticleTypes.BUBBLE, left.x, left.y, left.z, random, -0.02D, random);
                world.addParticle(ParticleTypes.BUBBLE, right.x, right.y, right.z, random, -0.02D, random);
            }
        }
    }

}
