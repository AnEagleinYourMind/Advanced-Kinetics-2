package hexaguin.advancedkinetics.items;

import hexaguin.advancedkinetics.AdvancedKinetics;
import net.minecraft.item.Item;

public class AKItems {

    public static Item glideGenerator;

    public static void init() {
        glideGenerator = new ItemGlideGenerator().setTextureName(AdvancedKinetics.MODID + ":" + "item_glide_generator");
    }
}
