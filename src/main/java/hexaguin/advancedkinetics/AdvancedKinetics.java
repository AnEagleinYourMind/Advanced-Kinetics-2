package hexaguin.advancedkinetics;

import hexaguin.advancedkinetics.recipes.Recipes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hexaguin.advancedkinetics.blocks.AKBlocks;
import hexaguin.advancedkinetics.items.AKItems;

@Mod(modid = AdvancedKinetics.MODID, name = "Advanced Kinetics 2", version = "2.0.1")
public class AdvancedKinetics {

    public static final String MODID = "advancedkinetics";
    public static final String RESOURCE_NAME = MODID + ":";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        AKBlocks.init();
        AKItems.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        Recipes.registerRecipes();
        // TODO: config?
    }

    public static CreativeTabs tabAdvancedKinetics = new CreativeTabs("tabAdvancedKinetics") {

        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return Item.getItemFromBlock(AKBlocks.basicFieldBlock);
        }
    };
}
