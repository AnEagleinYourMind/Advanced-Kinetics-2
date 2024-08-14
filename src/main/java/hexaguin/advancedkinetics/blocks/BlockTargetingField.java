package hexaguin.advancedkinetics.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.GameRegistry;
import hexaguin.advancedkinetics.AdvancedKinetics;
import hexaguin.advancedkinetics.tileentities.TileEntityTargetingField;

public class BlockTargetingField extends BlockBasicField {

    public BlockTargetingField(String unlocalizedName) {
        super(unlocalizedName);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityTargetingField();
    }
}
