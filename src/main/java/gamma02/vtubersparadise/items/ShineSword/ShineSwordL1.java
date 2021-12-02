package gamma02.vtubersparadise.items.ShineSword;

import gamma02.vtubersparadise.items.ISweepingNoEnchant;
import net.minecraft.enchantment.SweepingEnchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
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

        for (LivingEntity livingentity : target.world.getEntitiesWithinAABB(LivingEntity.class,
                target.getBoundingBox().grow(1.0D, 0.25D, 1.0D)))
        {
            if (livingentity != attacker && livingentity != target && (!(livingentity instanceof ArmorStandEntity) || !((ArmorStandEntity) livingentity).hasMarker()) && attacker.getDistanceSq(
                    livingentity) < 9.0D)
            {
                livingentity.applyKnockback(0.4F, (double) MathHelper.sin(attacker.rotationYaw * ((float) Math.PI / 180F)),
                        (double) (-MathHelper.cos(attacker.rotationYaw * ((float) Math.PI / 180F))));

                livingentity.attackEntityFrom(DamageSource.causeMobDamage(attacker), SweepingEnchantment.getSweepingDamageRatio(10));
            }
        }
        attacker.world.playSound((PlayerEntity)null, attacker.getPosX(), attacker.getPosY(), attacker.getPosZ(), SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, attacker.getSoundCategory(), 1.0F, 1.0F);
        if(attacker instanceof PlayerEntity){
            PlayerEntity user = (PlayerEntity) attacker;
            user.spawnSweepParticles();
        }
        return super.hitEntity(stack, target, attacker);
    }
}
