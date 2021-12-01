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
        if(target instanceof PlayerEntity){
            PlayerEntity targetedPlayer = (PlayerEntity) target;
            targetedPlayer.getActiveHand();
            ItemStack stack1 = targetedPlayer.getHeldItem(targetedPlayer.getActiveHand());
            if (stack1.getItem().equals(Items.SHIELD))
            {
                stack1.setDamage(0);
            }
        }
        return super.hitEntity(stack, target, attacker);
    }
}
