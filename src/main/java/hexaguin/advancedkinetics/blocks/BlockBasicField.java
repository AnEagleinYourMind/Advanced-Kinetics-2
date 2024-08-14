package hexaguin.advancedkinetics.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.GameRegistry;
import hexaguin.advancedkinetics.AdvancedKinetics;
import hexaguin.advancedkinetics.tileentities.TileEntityBasicField;

public class BlockBasicField extends BlockContainer {

    public BlockBasicField(String unlocalizedName) {
        super(Material.iron);
        setBlockName(unlocalizedName);
        setBlockTextureName(AdvancedKinetics.MODID + ":" + unlocalizedName);
        setLightLevel(1);
        //setLightOpacity(1);
        setCreativeTab(AdvancedKinetics.tabAdvancedKinetics);
        setHardness(3);
        setHarvestLevel("pickaxe", 0);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityBasicField();
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int xPos, int yPos, int zPos, Entity entity) {
        if (entity instanceof EntityFX) {
            entity.motionX *= 0.7;
            entity.motionY *= 0.7;
            entity.motionZ *= 0.7;
        }
    }
}
