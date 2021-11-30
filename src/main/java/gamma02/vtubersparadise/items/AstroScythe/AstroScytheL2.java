package gamma02.vtubersparadise.items.AstroScythe;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class AstroScytheL2 extends AstroScytheL1
{
    public AstroScytheL2(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn)
    {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot,
            boolean isSelected)
    {
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20, 0));
        return super.hitEntity(stack, target, attacker);
    }
}
