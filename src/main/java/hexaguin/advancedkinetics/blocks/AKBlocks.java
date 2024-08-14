package hexaguin.advancedkinetics.blocks;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameRegistry;
import hexaguin.advancedkinetics.items.MetaAKBlockItem;
import hexaguin.advancedkinetics.tileentities.TileEntityBasicField;
import hexaguin.advancedkinetics.tileentities.TileEntityTargetingField;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public final class AKBlocks {

    public static Block metaEffectBlock;
    public static Block cautionBlock;
    public static Block cautionLightBlock;
    public static Block basicFieldBlock;
    public static Block targetingFieldBlock; // TODO replace with metadata
    public static Block metaFilterBlock;
    public static Block metaModifierBlock;

    public static void init() {
        cautionBlock = new BlockCaution("caution_block");
        cautionLightBlock = new BlockCaution("caution_light_block").setLightLevel(1);
        basicFieldBlock = new BlockBasicField("basic_field_block");
        targetingFieldBlock = new BlockTargetingField("targeting_field_block");
        metaEffectBlock = new BlockEffect("effect_block");
        metaFilterBlock = new BlockEntityFilter("filter_block");
        metaModifierBlock = new BlockModifier("modifier_block");

        GameRegistry.registerBlock(cautionBlock, "caution_block");
        GameRegistry.registerBlock(cautionLightBlock, "caution_light_block");
        GameRegistry.registerBlock(basicFieldBlock, "basic_field_block");
        GameRegistry.registerBlock(targetingFieldBlock, "targeting_field_block");
        GameRegistry.registerBlock(metaEffectBlock, MetaAKBlockItem.class, "effect_block");
        GameRegistry.registerBlock(metaFilterBlock, MetaAKBlockItem.class, "filter_block");
        GameRegistry.registerBlock(metaModifierBlock, MetaAKBlockItem.class, "modifier_block");

        if (Loader.isModLoaded("ForgeMicroblock")) {
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(cautionBlock));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(cautionLightBlock));
        }

        GameRegistry.registerTileEntity(TileEntityBasicField.class, "basicFieldTileEntity");
        GameRegistry.registerTileEntity(TileEntityTargetingField.class, "targetingFieldTileEntity");
    }
}
