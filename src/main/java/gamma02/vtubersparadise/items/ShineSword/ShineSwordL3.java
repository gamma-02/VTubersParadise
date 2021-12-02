package gamma02.vtubersparadise.items.ShineSword;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class ShineSwordL3 extends ShineSwordL2
{
    public ShineSwordL3(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn)
    {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override public @NotNull UseAction getUseAction(@NotNull ItemStack stack)
    {
        return UseAction.CROSSBOW;
    }

    @Override public int getUseDuration(@NotNull ItemStack stack)
    {
        return 72000;
    }

    @Override public void onPlayerStoppedUsing(@NotNull ItemStack stack, @NotNull World worldIn, @NotNull LivingEntity entityLiving, int timeLeft)
    {
        if(entityLiving instanceof PlayerEntity && this.getUseDuration(stack) - timeLeft >= 40)
        {
            PlayerEntity user = (PlayerEntity) entityLiving;
            if (!user.getCooldownTracker().hasCooldown(stack.getItem()))
            {

                AreaEffectCloudEntity areaEffectCloud = new AreaEffectCloudEntity(worldIn, user.getPosX(), user.getPosY(),
                        user.getPosZ());
                areaEffectCloud.setOwner(user);
                EffectInstance effects;
                effects = new EffectInstance(Effects.BLINDNESS, 600);
                areaEffectCloud.setPotion(new Potion(effects));
                areaEffectCloud.setDuration(100);
                areaEffectCloud.setRadius(5f);
                worldIn.addEntity(areaEffectCloud);
                user.getCooldownTracker().setCooldown(stack.getItem(), 600);
            }
        }
    }

    @Override public @NotNull ActionResult<ItemStack> onItemRightClick(@NotNull World worldIn, PlayerEntity playerIn, @NotNull Hand handIn)
    {
        playerIn.setActiveHand(handIn);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override public void inventoryTick(@NotNull ItemStack stack, @NotNull World worldIn, @NotNull Entity entityIn, int itemSlot,
            boolean isSelected)
    {

        if(entityIn instanceof PlayerEntity)
        {
            PlayerEntity user = (PlayerEntity) entityIn;


        if (user.getActivePotionEffect(Effects.BLINDNESS) != null && isSelected)
        {
            user.removeActivePotionEffect(Effects.BLINDNESS);
        }

        }

    }
}
