package hexaguin.advancedkinetics.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hexaguin.advancedkinetics.AdvancedKinetics;

public class ItemGlideGenerator extends Item {

    public ItemGlideGenerator() {
        setMaxStackSize(1);
        setHasSubtypes(true);
        setUnlocalizedName(AdvancedKinetics.MODID + "_" + "glideGenerator");
        setCreativeTab(AdvancedKinetics.tabAdvancedKinetics);

        GameRegistry.registerItem(this, "glideGeneratorItem");
    }

    @Override
    public void onUpdate(ItemStack itemstack, World world, Entity player, int par4, boolean par5) {

        if (itemstack.getItemDamage() == 0) { // Don't do anything if inactive.
            return;
        }

        if (!(player instanceof EntityPlayer)) {
            return; // Just in case an arrow somehow holds this item or something. Probably impossible, but better safe
                    // than sorry.
        }

        if (world.getWorldTime() % 10 == 0) {
            int activeInstances = 0;
            InventoryPlayer inventory = ((EntityPlayer) player).inventory;
            ItemStack[] items = inventory.mainInventory;

            for (int i = 0; i < items.length; i++) {
                if (items[i] != null) {
                    if (items[i].getItem() == itemstack.getItem()) {
                        if (items[i].getItemDamage() == 1) {
                            activeInstances++;
                        }
                    }
                }
            }
            if (activeInstances > 1) {
                itemstack.setItemDamage(0);
            }
        }

        int boostLevel = (int) ((Math
            .sqrt(Math.abs(player.motionX * player.motionX) + Math.abs(player.motionZ * player.motionZ)) * 12) + 1);
        if (!((EntityLivingBase) player).isPotionActive(Potion.jump)) {
            ((EntityLivingBase) player).addPotionEffect(new PotionEffect(Potion.jump.id, 4, boostLevel, true));
        }
        if (!((EntityLivingBase) player).isPotionActive(Potion.moveSpeed)) {
            ((EntityLivingBase) player).addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 8, 0, true));
        }

        if (Math.abs(player.motionX * player.motionX) + Math.abs(player.motionZ * player.motionZ) < 3) {
            player.motionX *= 1.08;
            player.motionZ *= 1.08;
        }

        if (player.motionY < 0) {
            if (!player.isSneaking()) {
                player.motionY += 0.06;
            }
        } else {
            player.motionY *= 0.8;
        }

        player.fallDistance *= 0;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par2World.isRemote) {
            if (par1ItemStack.getItemDamage() == 1) {
                par1ItemStack.setItemDamage(0);
            } else {
                boolean alone = true;
                InventoryPlayer inventory = par3EntityPlayer.inventory;
                ItemStack[] items = inventory.mainInventory;

                for (int i = 0; i < items.length; i++) {
                    if (items[i] != null) {
                        if (items[i].getItem() == par1ItemStack.getItem() && items[i].getItemDamage() == 1) {
                            alone = false;
                        }
                    }
                }
                if (alone) {
                    par1ItemStack.setItemDamage(1);
                }
            }
        }

        return par1ItemStack;
    }

    @Override
    public boolean onDroppedByPlayer(ItemStack itemStack, EntityPlayer player) {
        return itemStack.getItemDamage() == 0;
    }

    @Override
    public boolean onEntityItemUpdate(EntityItem entityItem) {
        if (entityItem.getEntityItem()
            .getItemDamage() == 1) {
            entityItem.getEntityItem()
                .setItemDamage(0);
        }
        return false;
    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack, int a) {
        return par1ItemStack.getItemDamage() == 1;
    }

    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack) {
        if (par1ItemStack.getItemDamage() == 1) {
            return EnumRarity.rare;
        } else {
            return EnumRarity.common;
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack) {
        return super.getUnlocalizedName() + "." + par1ItemStack.getItemDamage();
    }
}
