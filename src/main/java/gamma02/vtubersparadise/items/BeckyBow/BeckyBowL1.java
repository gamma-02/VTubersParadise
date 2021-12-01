package gamma02.vtubersparadise.items.BeckyBow;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Random;

public class BeckyBowL1 extends Item
{
    public BeckyBowL1(Properties properties)
    {
        super(properties);
    }

    @Override public UseAction getUseAction(ItemStack stack)
    {
        return UseAction.BOW;
    }

    @Override public int getUseDuration(ItemStack stack)
    {
        return 72000;
    }

    public int level(){
        return 1;
    }

    @Override public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft)
    {
        if(entityLiving instanceof PlayerEntity && this.getUseDuration(stack) - timeLeft >= 20){
            PlayerEntity user = (PlayerEntity) entityLiving;
            boolean shouldFire = false;
            if(user.isCreative()){
                shouldFire = true;
            }
            NonNullList<ItemStack> inventory = user.inventory.mainInventory;
            ItemStack stack1 = null;
            for (ItemStack element:
                 inventory)
            {
                if(element.getItem() instanceof BlockItem){
                    stack1 = element;
                    shouldFire = true;
                    break;
                }
            }
            if(shouldFire)
            {
                if(!user.isCreative())
                {
                    Objects.requireNonNull(stack1).setCount(stack1.getCount() - 1);
                }
                ArrowEntity entity = new ArrowEntity(worldIn, entityLiving);
                Vector3d vec = entityLiving.getLookVec().mul(2, 2, 2);
                entity.setVelocity(vec.x, vec.y, vec.z);
                entity.setDamage(getArrowDamage());
                EffectInstance[] effects = new EffectInstance[2];
                if (level() == 2)
                {
                    effects[0] = new EffectInstance(Effects.INSTANT_DAMAGE);
                    effects[1] = new EffectInstance(Effects.INSTANT_HEALTH);
                } else if (level() == 3)
                {
                    effects[0] = new EffectInstance(Effects.INSTANT_DAMAGE, 1, 1);
                    effects[1] = new EffectInstance(Effects.INSTANT_HEALTH, 1, 1);
                }
                ArrowEntity actualEntity = setEffectsAndChance(entity, effects, new Random());
                actualEntity.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
                worldIn.addEntity(actualEntity);
            }


        }

        super.onPlayerStoppedUsing(stack, worldIn, entityLiving, timeLeft);
    }

    @Override public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        playerIn.setActiveHand(handIn);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
    public static float getArrowVelocity(int charge) {
        float f = (float)charge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }
    public double getArrowDamage(){
        return 5;
    }
    public ArrowEntity setEffectsAndChance(ArrowEntity entity, EffectInstance[] effects, Random random){


        for (EffectInstance element :
             effects)
        {
            int chance = MathHelper.nextInt(random, 0, 100);
            if(chance >= 15 && element != null)
            {
                entity.addEffect(element);
            }


        }

        return entity;
    }

}

