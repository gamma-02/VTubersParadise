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
        if(target.getHeldItemMainhand().getItem() == Items.SHIELD){
            target.getHeldItemMainhand().setCount(0);
        }else if(target.getHeldItemOffhand().getItem() == Items.SHIELD){
            target.getHeldItemOffhand().setCount(0);
        }
        return super.hitEntity(stack, target, attacker);
    }
}
