package hexaguin.advancedkinetics.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hexaguin.advancedkinetics.AdvancedKinetics;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public abstract class AbstractAKBlock extends Block {
    public AbstractAKBlock(String unlocalizedName) {
        super(Material.iron);
        setBlockName(unlocalizedName);
        setLightLevel(0.2f);
        setLightOpacity(1);
        setCreativeTab(AdvancedKinetics.tabAdvancedKinetics);
        setHardness(3);
        setHarvestLevel("pickaxe", 0);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }
}
