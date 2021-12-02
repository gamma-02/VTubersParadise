package gamma02.vtubersparadise.items.DisdeersClaws;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class DisdeersClawsL2 extends DisdeersClawsL1
{
    public DisdeersClawsL2(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn)
    {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        if(MathHelper.nextInt(new Random(), 0, 100) <= 15){
            target.addPotionEffect(new EffectInstance(Effects.HUNGER, 600, 1));
        }


        return super.hitEntity(stack, target, attacker);
    }
}
