package gamma02.vtubersparadise.items.EchoTrident;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EchoTridentL3 extends EchoTridentL2
{
    private boolean justCreated = true;
    public EchoTridentL3(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn)
    {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot,
            boolean isSelected)
    {
        if(this.justCreated){
            stack.addEnchantment(Enchantments.LOOTING, 1);
            this.justCreated = false;
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
