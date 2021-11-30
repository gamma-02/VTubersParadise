package gamma02.vtubersparadise.items.AstroScythe;

import gamma02.vtubersparadise.items.IExtendedReach;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;

public class AstroScytheL1 extends SwordItem implements IExtendedReach
{
    public AstroScytheL1(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn)
    {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot,
            boolean isSelected)
    {
        if(isSelected && entityIn instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityIn;
            player.getAttribute(PlayerEntity.)
        }

        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override public double getCustomReach()
    {
        return 6;
    }
}
