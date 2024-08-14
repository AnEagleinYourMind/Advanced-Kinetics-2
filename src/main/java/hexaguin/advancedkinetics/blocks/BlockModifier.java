package hexaguin.advancedkinetics.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import cpw.mods.fml.common.registry.GameRegistry;
import hexaguin.advancedkinetics.AdvancedKinetics;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockModifier extends AbstractAKBlock {
    @SideOnly(Side.CLIENT)
    private static IIcon[] textures;

    public static final String[] TEXTURE_NAMES = {
        "block_modifier_double_range",
        "block_modifier_double_size",
        "block_modifier_half_range"
    };

    public BlockModifier(String unlocalizedName) {
        super(unlocalizedName);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return textures[meta];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        textures = new IIcon[TEXTURE_NAMES.length];

        for (int i = 0; i < TEXTURE_NAMES.length; i++) {
            textures[i] = register.registerIcon(AdvancedKinetics.MODID + ":" + TEXTURE_NAMES[i]);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
        for (int i = 0; i < TEXTURE_NAMES.length; i++)
            list.add(new ItemStack(item, 1, i));
    }

}
