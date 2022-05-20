package imexoodeex.utilities.client.particles;

import imexoodeex.utilities.registers.ParticleRegister;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3f;
import net.minecraft.world.World;

import java.util.Random;

public class SpectreBootsParticles {


    public static void spawnRocketParticles(LivingEntity entity, World world) {
        Random rand = new Random();
        float yBodyRot = entity.getYaw();

        Vec3d playerPos = entity.getPos();
        float random = (rand.nextFloat() - 0.5F) * 0.1F;

        // -58 minimalnie za wolno; -57 minimalnie za szybko; -57.25 ultra minimalnie za szybko; -57.299f minimalnie za wolno; -57.295 za szybko minimalnie tak że idealnie;
        Vec3d vLeft = new Vec3d(-0.2, 0, 0).rotateX(0).rotateY((yBodyRot / -57.295f));
        Vec3d vRight = new Vec3d(0.2, 0, 0).rotateX(0).rotateY((yBodyRot / -57.295f));


        Vec3d right = playerPos.add(vRight).add(new Vec3d(new Vec3f(entity.getVelocity().multiply(0.01D))));
        Vec3d left = playerPos.add(vLeft).add(new Vec3d(new Vec3f(entity.getVelocity().multiply(0.01D))));

        spawnParticles(entity, random, world, left, right);
    }

    private static void spawnParticles(LivingEntity entity, float random, World world, Vec3d left, Vec3d right) {
        Vec3d vel = entity.getVelocity();
        double velY = entity.getVelocity().getY();
        if (!entity.isSubmergedInWater()) {
            for (int i = 0; i < 6; i++) {
                //left
                world.addParticle(ParticleRegister.PURPLE_PIECE, left.x, left.y, left.z, random, -0.2D, random);
                world.addParticle(ParticleRegister.PINK_PIECE, left.x, left.y, left.z, random, -0.2D, random);
                world.addParticle(ParticleRegister.GREEN_PIECE, left.x, left.y, left.z, random, -0.2D, random);
                //right
                world.addParticle(ParticleRegister.PURPLE_PIECE, right.x, right.y, right.z, random, -0.2D, random);
                world.addParticle(ParticleRegister.PINK_PIECE, right.x, right.y, right.z, random, -0.2D, random);
                world.addParticle(ParticleRegister.GREEN_PIECE, right.x, right.y, right.z, random, -0.2D, random);
            }
            world.addParticle(ParticleTypes.SMOKE, left.x, left.y, left.z, random, -0.2D, random);
            world.addParticle(ParticleTypes.SMOKE, right.x, right.y, right.z, random, -0.2D, random);
        } else if (entity.isSubmergedInWater()) {
            for (int i = 0; i < 4; i++) {
                world.addParticle(ParticleTypes.BUBBLE, left.x, left.y, left.z, random, -0.02D, random);
                world.addParticle(ParticleTypes.BUBBLE, right.x, right.y, right.z, random, -0.02D, random);
            }
        }
    }

}
