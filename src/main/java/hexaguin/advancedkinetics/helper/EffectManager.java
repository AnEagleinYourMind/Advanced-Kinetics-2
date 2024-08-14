package hexaguin.advancedkinetics.helper;

import net.minecraft.entity.Entity;

public class EffectManager {
    public static void runForEffectId(int meta, double sourceX, double sourceY, double sourceZ, double xOffset, double yOffset,
                                      double zOffset, Entity entity) {
        switch (meta) {
            case 0 -> Accelerate(xOffset, yOffset, zOffset, entity);
            case 1 -> Bounce(xOffset, yOffset, zOffset, entity);
            case 2 -> Burn(entity);
            case 3 -> Move(xOffset, yOffset, zOffset, entity);
            case 4 -> Pull(sourceX, sourceY, sourceZ, entity);
            case 5 -> Slow(sourceX, sourceY, sourceZ, entity);

            default -> {
                // probably should log something in this case
            }
        }
    }

    private static void Accelerate(double xOffset, double yOffset,
                                   double zOffset, Entity entity) {
        float maxEffect = 1.1f;

        if (entity.motionX + entity.motionY + entity.motionZ < 15) {
            if ((entity.motionX > 0 && xOffset > 0) | (entity.motionX < 0 && xOffset < 0)) {
                entity.motionX *= maxEffect;
            }
            if ((entity.motionY > 0 && yOffset > 0) | (entity.motionY < 0 && yOffset < 0)) {
                entity.motionY *= maxEffect;
            }
            if ((entity.motionZ > 0 && zOffset > 0) | (entity.motionZ < 0 && xOffset < 0)) {
                entity.motionZ *= maxEffect;
            }
        }
    }

    private static void Bounce(double xOffset, double yOffset, double zOffset, Entity entity) {
        if ((entity.motionX < 0 && xOffset > 0) | (entity.motionX > 0 && xOffset < 0)) {
            entity.motionX *= -1;
        }
        if ((entity.motionY < 0 && yOffset > 0) | (entity.motionY > 0 && yOffset < 0)) {
            if (Math.abs(entity.motionY) > 0.25) {
                entity.motionY *= -1;
            }
        }
        if ((entity.motionZ < 0 && zOffset > 0) | (entity.motionZ > 0 && zOffset < 0)) {
            entity.motionZ *= -1;
        }
    }

    private static void Burn(Entity entity) {
        entity.setFire(1);
    }

    private static void Move(double xOffset, double yOffset, double zOffset, Entity entity) {
        float maxEffect = 0.03f;
        entity.motionX += xOffset * maxEffect;
        entity.motionY += yOffset * maxEffect;
        entity.motionZ += zOffset * maxEffect;
    }

    private static void Pull(double sourceX, double sourceY, double sourceZ, Entity entity) {
        float maxEffect = 0.03f;

        double distanceX = entity.posX - (sourceX + 0.5);
        double distanceY = entity.posY - (sourceY + 0.5);
        double distanceZ = entity.posZ - (sourceZ + 0.5);

        double totalDistance = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2) + Math.pow(distanceZ, 2));
        double reduction = maxEffect / totalDistance;

        entity.motionX += 0 - (distanceX * reduction);
        entity.motionY += 0 - (distanceY * reduction);
        entity.motionZ += 0 - (distanceZ * reduction);
    }

    private static void Slow(double xOffset, double yOffset, double zOffset, Entity entity) {
        float maxEffect = 0.9f;

        if ((entity.motionX > 0 && xOffset > 0) | (entity.motionX < 0 && xOffset < 0)) {
            entity.motionX *= maxEffect;
        }
        if ((entity.motionY > 0 && yOffset > 0) | (entity.motionY < 0 && yOffset < 0)) {
            entity.motionY *= maxEffect;
            entity.fallDistance = 0;
        }
        if ((entity.motionZ > 0 && zOffset > 0) | (entity.motionZ < 0 && xOffset < 0)) {
            entity.motionZ *= maxEffect;
        }
    }
}
