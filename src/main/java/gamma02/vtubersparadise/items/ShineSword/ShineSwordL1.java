package gamma02.vtubersparadise.items.ShineSword;

import gamma02.vtubersparadise.items.ISweepingNoEnchant;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import org.jetbrains.annotations.NotNull;

public class ShineSwordL1 extends SwordItem implements ISweepingNoEnchant
{
    public ShineSwordL1(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn)
    {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override public boolean hitEntity(@NotNull ItemStack stack, LivingEntity target, @NotNull LivingEntity attacker)
    {
        target.addPotionEffect(new EffectInstance(Effects.GLOWING, 600));
        return super.hitEntity(stack, target, attacker);
    }
}
