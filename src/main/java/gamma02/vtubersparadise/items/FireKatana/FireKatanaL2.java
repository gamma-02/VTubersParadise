package gamma02.vtubersparadise.items.FireKatana;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class FireKatanaL2 extends FireKatanaL1
{
    public FireKatanaL2(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn)
    {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot,
            boolean isSelected)
    {
        if(isSelected && entityIn instanceof LivingEntity){
            LivingEntity entity = (LivingEntity) entityIn;
            entity.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 1));
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
