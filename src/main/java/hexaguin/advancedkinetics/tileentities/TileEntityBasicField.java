package hexaguin.advancedkinetics.tileentities;

import java.util.Iterator;
import java.util.List;

import hexaguin.advancedkinetics.helper.EffectManager;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

import hexaguin.advancedkinetics.blocks.BlockEntityFilter;
import hexaguin.advancedkinetics.blocks.BlockModifier;
import hexaguin.advancedkinetics.blocks.BlockEffect;

public class TileEntityBasicField extends TileEntity { // TODO: Fix NBT

    public void updateEntity() {
        boolean affectPlayers = true;
        boolean affectLiving = true;
        boolean affectNonLiving = true;

        double effectRange = 8;
        int range = 1;
        Block block;

        for (int xOffset = -range; xOffset <= range; xOffset++) { // Modifier Blocks
            for (int yOffset = -range; yOffset <= range; yOffset++) {
                for (int zOffset = -range; zOffset <= range; zOffset++) {
                    block = this.worldObj.getBlock(xCoord + xOffset, yCoord + yOffset, zCoord + zOffset);

                    if (block instanceof BlockModifier) {
                        int modifierType = worldObj.getBlockMetadata(xCoord + xOffset, yCoord + yOffset, zCoord + zOffset);

                        switch (modifierType) {
                            case 0 -> effectRange *= 2;
                            case 1 -> {
                                if (range <= 4)
                                    range *= 2;
                            }
                            case 2 -> effectRange *= 0.5;
                        }
                    }
                }
            }
        }

        for (int xOffset = -range; xOffset <= range; xOffset++) { // Blacklist Blocks
            for (int yOffset = -range; yOffset <= range; yOffset++) {
                for (int zOffset = -range; zOffset <= range; zOffset++) {
                    block = worldObj.getBlock(xCoord + xOffset, yCoord + yOffset, zCoord + zOffset);

                    if (block instanceof BlockEntityFilter) {
                        int filterType = worldObj.getBlockMetadata(xCoord + xOffset, yCoord + yOffset, zCoord + zOffset);

                        switch (filterType) { // TODO: this is slightly unreadable
                            case 0 -> affectLiving = false;
                            case 1 -> affectNonLiving = false;
                            case 2 -> affectPlayers = false;
                        }
                    }
                }
            }
        }

        AxisAlignedBB area = AxisAlignedBB
            .getBoundingBox(
                this.xCoord,
                this.yCoord,
                this.zCoord,
                this.xCoord + 1,
                this.yCoord + 1,
                this.zCoord + 1)
            .expand(effectRange, effectRange, effectRange);

        List<Entity> inarea = this.worldObj.getEntitiesWithinAABB(Entity.class, area);
        Iterator<Entity> iterator = inarea.iterator();
        Entity entity;

        while (iterator.hasNext()) {
            entity = iterator.next();
            if (entity instanceof EntityPlayer) {
                if (affectPlayers) {
                    applyEffects(entity, range);
                }
            } else if (entity instanceof EntityLiving) {
                if (affectLiving) {
                    applyEffects(entity, range);
                }
            } else if (affectNonLiving) {
                applyEffects(entity, range);
            }
        }
    }

    private void applyEffects(Entity entity, int range) {
        Block block;
        for (int xOffset = -range; xOffset <= range; xOffset++) { // Effect Blocks
            for (int yOffset = -range; yOffset <= range; yOffset++) {
                for (int zOffset = -range; zOffset <= range; zOffset++) {

                    block = worldObj.getBlock(xCoord + xOffset, yCoord + yOffset, zCoord + zOffset);
                    int meta = worldObj.getBlockMetadata(xCoord + xOffset, yCoord + yOffset, zCoord + zOffset);

                    if (block instanceof BlockEffect) {
                        EffectManager.runForEffectId(meta, xCoord, yCoord, zCoord, xOffset, yOffset, zOffset, entity);
                        //((BlockEffect) block).ApplyEffect(xCoord, yCoord, zCoord, xOffset, yOffset, zOffset, entity);
                    }
                }
            }
        }
    }
}
