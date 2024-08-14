package hexaguin.advancedkinetics.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import cpw.mods.fml.common.registry.GameRegistry;
import hexaguin.advancedkinetics.AdvancedKinetics;

public class BlockCaution extends Block {

    public BlockCaution(String unlocalizedName) {
        super(Material.cloth);
        setBlockName(unlocalizedName);
        setBlockTextureName(AdvancedKinetics.MODID + ":" + unlocalizedName);
        setCreativeTab(AdvancedKinetics.tabAdvancedKinetics);
        setHardness(0.8f);
    }
}
