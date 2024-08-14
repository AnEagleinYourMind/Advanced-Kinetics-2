package hexaguin.advancedkinetics.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class MetaAKBlockItem extends ItemBlockWithMetadata {
    public MetaAKBlockItem(Block of) {
        super(of, of);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName(stack) + "." + stack.getItemDamage();
    }
}
