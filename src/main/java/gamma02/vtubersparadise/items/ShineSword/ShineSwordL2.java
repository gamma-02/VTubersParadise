package gamma02.vtubersparadise.items.ShineSword;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.jetbrains.annotations.NotNull;

public class ShineSwordL2 extends ShineSwordL1
{
    public ShineSwordL2(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn)
    {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override public boolean hitEntity(@NotNull ItemStack stack, LivingEntity target, @NotNull LivingEntity attacker)
    {
        ItemStack shield = target.getHeldItem(target.getActiveHand());
        if(shield.getItem() == Items.SHIELD){
            shield.setDamage(0);
        }
        return super.hitEntity(stack, target, attacker);
    }
}
