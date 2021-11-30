package gamma02.vtubersparadise.items.AstroScythe;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AstroScytheL3 extends AstroScytheL2
{
    public AstroScytheL3(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn)
    {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn)
    {
        stack.addEnchantment(Enchantments.LOOTING, 1);
        super.onCreated(stack, worldIn, playerIn);
    }

    @Override public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot,
            boolean isSelected)
    {
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
