package hexaguin.advancedkinetics.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import hexaguin.advancedkinetics.blocks.AKBlocks;
import hexaguin.advancedkinetics.items.AKItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Recipes {
    public static void registerRecipes() {
        ItemStack cautionBlock32Stack = new ItemStack(AKBlocks.cautionBlock, 32);
        ItemStack cautionBlockStack = new ItemStack(AKBlocks.cautionBlock);
        ItemStack cautionLightBlockStack = new ItemStack(AKBlocks.cautionLightBlock);
        ItemStack basicFieldBlockStack = new ItemStack(AKBlocks.basicFieldBlock);
        ItemStack targetingFieldBlockStack = new ItemStack(AKBlocks.targetingFieldBlock);
        ItemStack accelerateEffectBlockStack = new ItemStack(AKBlocks.metaEffectBlock, 1, 0);
        ItemStack bounceEffectBlockStack = new ItemStack(AKBlocks.metaEffectBlock, 1, 1);
        ItemStack burnEffectBlockStack = new ItemStack(AKBlocks.metaEffectBlock, 1, 2);
        ItemStack moveEffectBlockStack = new ItemStack(AKBlocks.metaEffectBlock, 1, 3);
        ItemStack pullEffectBlockStack = new ItemStack(AKBlocks.metaEffectBlock, 1, 4);
        ItemStack slowEffectBlockStack = new ItemStack(AKBlocks.metaEffectBlock, 1, 5);
        ItemStack livingFilterBlockStack = new ItemStack(AKBlocks.metaFilterBlock);
        ItemStack nonLivingFilterBlockStack = new ItemStack(AKBlocks.metaFilterBlock, 1, 1);
        ItemStack playerFilterBlockStack = new ItemStack(AKBlocks.metaFilterBlock, 1, 2);
        ItemStack doubleRangeModifierBlockStack = new ItemStack(AKBlocks.metaModifierBlock);
        ItemStack doubleSizeModifierBlockStack = new ItemStack(AKBlocks.metaModifierBlock,1, 1);
        ItemStack halfRangeModifierBlock4Stack = new ItemStack(AKBlocks.metaModifierBlock, 1, 2);

        ItemStack orangeWoolStack = new ItemStack(Blocks.wool, 1, 1);
        ItemStack blackWoolStack = new ItemStack(Blocks.wool, 1, 15);
        ItemStack glowstoneDustStack = new ItemStack(Items.glowstone_dust);
        ItemStack enderPearlStack = new ItemStack(Items.ender_pearl);
        ItemStack redstoneBlockStack = new ItemStack(Blocks.redstone_block);
        ItemStack goldIngotStack = new ItemStack(Items.gold_ingot);
        ItemStack enderEyeStack = new ItemStack(Items.ender_eye);
        ItemStack obsidianStack = new ItemStack(Blocks.obsidian);
        ItemStack glassStack = new ItemStack(Blocks.glass);
        ItemStack redstoneStack = new ItemStack(Items.redstone);
        ItemStack netherrackStack = new ItemStack(Blocks.netherrack);
        ItemStack blazeRodStack = new ItemStack(Items.blaze_rod);
        ItemStack slimeBallStack = new ItemStack(Items.slime_ball);
        ItemStack soulSandStack = new ItemStack(Blocks.soul_sand);
        ItemStack comparatorStack = new ItemStack(Items.comparator);
        ItemStack boneStack = new ItemStack(Items.bone);
        ItemStack repeaterStack = new ItemStack(Items.repeater);

        GameRegistry.addRecipe(
            new ItemStack(AKItems.glideGenerator),
            "ban",
            "aca",
            "las",
            'b',
            bounceEffectBlockStack,
            'a',
            accelerateEffectBlockStack,
            'n',
            nonLivingFilterBlockStack,
            'c',
            basicFieldBlockStack,
            'l',
            livingFilterBlockStack,
            's',
            slowEffectBlockStack);

        GameRegistry.addRecipe(cautionBlock32Stack, "xxy", "xyx", "yxx", 'x', orangeWoolStack, 'y', blackWoolStack);
        GameRegistry.addShapelessRecipe(cautionLightBlockStack, cautionBlockStack, glowstoneDustStack);
        GameRegistry.addRecipe(
            basicFieldBlockStack,
            "xyx",
            "yzy",
            "xyx",
            'x',
            enderPearlStack,
            'y',
            goldIngotStack,
            'z',
            redstoneBlockStack);
        GameRegistry.addRecipe(
            targetingFieldBlockStack,
            " x ",
            "yzy",
            " x ",
            'x',
            enderEyeStack,
            'y',
            pullEffectBlockStack,
            'z',
            basicFieldBlockStack);
        GameRegistry.addRecipe(
            pullEffectBlockStack,
            "yxy",
            "xzx",
            "yxy",
            'x',
            obsidianStack,
            'y',
            enderPearlStack,
            'z',
            glassStack);
        GameRegistry.addRecipe(
            moveEffectBlockStack,
            "xyx",
            "yzy",
            "xyx",
            'x',
            enderPearlStack,
            'y',
            redstoneStack,
            'z',
            glassStack);
        GameRegistry.addRecipe(
            accelerateEffectBlockStack,
            "xyx",
            "yzy",
            "xyx",
            'x',
            goldIngotStack,
            'y',
            redstoneStack,
            'z',
            glassStack);
        GameRegistry.addRecipe(
            burnEffectBlockStack,
            "xyx",
            "yzy",
            "xyx",
            'x',
            netherrackStack,
            'y',
            blazeRodStack,
            'z',
            glassStack);
        GameRegistry.addRecipe(
            bounceEffectBlockStack,
            "xyx",
            "yzy",
            "xyx",
            'x',
            slimeBallStack,
            'y',
            redstoneStack,
            'z',
            glassStack);
        GameRegistry.addRecipe(
            slowEffectBlockStack,
            "xyx",
            "yzy",
            "xyx",
            'x',
            soulSandStack,
            'y',
            redstoneStack,
            'z',
            glassStack);
        GameRegistry.addRecipe(
            nonLivingFilterBlockStack,
            "xyx",
            "yzy",
            "xyx",
            'x',
            enderEyeStack,
            'y',
            comparatorStack,
            'z',
            glassStack);
        GameRegistry
            .addRecipe(livingFilterBlockStack, "x x", " z ", "x x", 'x', boneStack, 'z', nonLivingFilterBlockStack);
        GameRegistry
            .addRecipe(playerFilterBlockStack, " x ", "xzx", " x ", 'x', obsidianStack, 'z', livingFilterBlockStack);
        GameRegistry.addRecipe(
            doubleRangeModifierBlockStack,
            "xyx",
            "yzy",
            "xyx",
            'x',
            enderPearlStack,
            'y',
            repeaterStack,
            'z',
            basicFieldBlockStack);
        GameRegistry.addRecipe(
            halfRangeModifierBlock4Stack,
            "x x",
            " z ",
            "x x",
            'x',
            enderPearlStack,
            'z',
            doubleRangeModifierBlockStack);
        GameRegistry.addRecipe(
            doubleSizeModifierBlockStack,
            "xyx",
            "yzy",
            "xyx",
            'x',
            doubleRangeModifierBlockStack,
            'y',
            repeaterStack,
            'z',
            basicFieldBlockStack);
    }
}
