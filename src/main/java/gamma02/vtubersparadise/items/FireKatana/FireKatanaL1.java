package gamma02.vtubersparadise.items.FireKatana;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

public class FireKatanaL1 extends SwordItem
{
    public FireKatanaL1(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn)
    {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        target.setFire(5);
        return true;
    }
}
