package gamma02.vtubersparadise.items.NeonBlade;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class NeonBladeL3 extends NeonBladeL2
{
    public NeonBladeL3(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn)
    {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        if(target.getHeldItemMainhand().getItem() == Items.SHIELD){
            target.getHeldItemMainhand().setCount(0);
        }else if(target.getHeldItemOffhand().getItem() == Items.SHIELD){
            target.getHeldItemOffhand().setCount(0);
        }
        return super.hitEntity(stack, target, attacker);
    }
}
