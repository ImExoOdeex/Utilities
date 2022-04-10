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

        Vec3d vLeft = new Vec3d(-0.2, 0 , 0 ).rotateX(0).rotateY((yBodyRot / -57.295f));
        Vec3d vRight = new Vec3d(0.2, 0 , 0 ).rotateX(0).rotateY((yBodyRot / -57.295f));

        Vec3d right = playerPos.add(vRight).add(new Vec3d(new Vec3f(entity.getVelocity().multiply(0.01D))));
        Vec3d left = playerPos.add(vLeft).add(new Vec3d(new Vec3f(entity.getVelocity().multiply(0.01D))));

        spawnParticles(entity, random, world, left, right);
    }

    private static void spawnParticles(LivingEntity entity, float random, World world, Vec3d left, Vec3d right) {
                world.addParticle(ParticleTypes.HEART, right.x, right.y  + 2D, right.z, random, 0.1D, random);
    }
}
