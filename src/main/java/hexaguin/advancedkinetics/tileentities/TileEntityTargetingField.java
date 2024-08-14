package hexaguin.advancedkinetics.tileentities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

import hexaguin.advancedkinetics.blocks.BlockEntityFilter;

public class TileEntityTargetingField extends TileEntity {// TODO: Fix NBT

    public void updateEntity() {
        Block block;
        int projectile = 0; // projectile refers to the entity filter type that will be flung at the target entity type
        int target = 0;
        boolean complete = true;
        double effectRange = 16;

        block = worldObj.getBlock(xCoord, yCoord + 1, zCoord); // get the top block
        if (block instanceof BlockEntityFilter) {
            projectile = worldObj.getBlockMetadata(xCoord, yCoord + 1, zCoord);
        } else {
            complete = false;
        }

        block = this.worldObj.getBlock(xCoord, yCoord - 1, zCoord); // get the bottom block
        if (block instanceof BlockEntityFilter) {
            target = worldObj.getBlockMetadata(xCoord, yCoord - 1, zCoord);
        } else {
            complete = false;
        }

        if (complete) {

            AxisAlignedBB area = AxisAlignedBB
                .getBoundingBox(
                    this.xCoord,
                    this.yCoord,
                    this.zCoord,
                    this.xCoord + 1,
                    this.yCoord + 1,
                    this.zCoord + 1)
                .expand(effectRange, effectRange, effectRange);
            List<Entity> inArea = this.worldObj.getEntitiesWithinAABB(Entity.class, area);
            ArrayList<Entity> projectiles = new ArrayList<>();
            Iterator<Entity> iterator = inArea.iterator();
            Entity entity;
            Entity targetEntity = null;

            while (iterator.hasNext()) {
                entity = iterator.next();
                if (entity instanceof EntityPlayer) {
                    if (target == 2) {
                        targetEntity = entity;
                    } else if (projectile == 2) {
                        projectiles.add(entity);
                    }
                } else if (entity instanceof EntityLiving) {
                    if (target == 0) {
                        targetEntity = entity;
                    } else if (projectile == 0) {
                        projectiles.add(entity);
                    }
                    // At this point we know that the entity is non-living.
                } else if (target == 1) {
                    targetEntity = entity;
                } else if (projectile == 1) {
                    projectiles.add(entity);
                }
            }

            if ((targetEntity != null) && !projectiles.isEmpty()) {
                Iterator<Entity> projectileIterator = projectiles.iterator();
                double distanceX, distanceY, distanceZ;

                while (projectileIterator.hasNext()) {
                    entity = projectileIterator.next();

                    distanceX = entity.posX - targetEntity.posX;
                    distanceY = entity.posY - targetEntity.posY;
                    distanceZ = entity.posZ - targetEntity.posZ;

                    double totalDistance = Math
                        .sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2) + Math.pow(distanceZ, 2));
                    double reduction = 0.3 / totalDistance;

                    entity.motionX += 0 - (distanceX * reduction);
                    entity.motionY += 0 - (distanceY * reduction);
                    entity.motionZ += 0 - (distanceZ * reduction);
                }
            }
        }
    }
}
