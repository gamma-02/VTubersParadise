package gamma02.vtubersparadise.items.BeckyBow;

import jdk.nashorn.internal.ir.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.system.CallbackI;

import java.util.Objects;
import java.util.Random;
import java.util.function.Predicate;

public class BeckyBowL1 extends BowItem
{
    public int level;
    public BeckyBowL1(Properties properties, int level)
    {
        super(properties);
        this.level = level;
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
            NonNullList<ItemStack> stack1 = NonNullList.create();
            int i = 0;
            for (ItemStack element:
                 inventory)
            {
                if(element.getItem() instanceof BlockItem){
                    stack1.add(element);
                    shouldFire = true;
                }
                i++;
            }
            if(shouldFire)
            {
                if(!user.isCreative())
                {
                    System.out.println(stack1.toArray().length-1);
                    int i2 = MathHelper.nextInt(new Random(), 0, stack1.toArray().length - 1 );
                    Objects.requireNonNull(stack1.get(i2)).setCount(stack1.get(i2).getCount() - 1);
                }
                ArrowEntity entity = new ArrowEntity(worldIn, entityLiving);
                Vector3d vec = entityLiving.getLookVec().mul(2, 2, 2);
                entity.setVelocity(vec.x, vec.y, vec.z);
                if(this.level == 2){
                    entity.setDamage(8);
                }else if(this.level == 3){
                    entity.setDamage(12);
                }else{
                    entity.setDamage(5);
                }
                EffectInstance[] effects = new EffectInstance[2];
                if (this.level == 2)
                {
                    effects[0] = new EffectInstance(Effects.INSTANT_DAMAGE);
                    effects[1] = new EffectInstance(Effects.INSTANT_HEALTH);
                } else if (this.level == 3)
                {
                    effects[0] = new EffectInstance(Effects.INSTANT_DAMAGE, 1, 1);
                    effects[1] = new EffectInstance(Effects.INSTANT_HEALTH, 1, 1);
                }
                ArrowEntity actualEntity = setEffectsAndChance(entity, effects, new Random());
                actualEntity.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
                worldIn.addEntity(actualEntity);
                worldIn.playSound(null, user.getPosX(), user.getPosY(), user.getPosZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) * 0.5F);
            }


        }
    }

    @Override public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        playerIn.setActiveHand(handIn);
        return ActionResult.resultFail(playerIn.getHeldItem(handIn));
    }
    public static float getArrowVelocity(int charge) {
        float f = (float)charge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }
    public Predicate<ItemStack> getInventoryAmmoPredicate() {
        return (stack) -> stack.getItem() instanceof BlockItem;
    }

    public AbstractArrowEntity customArrow(AbstractArrowEntity arrow) {
        return arrow;
    }

    public int func_230305_d_() {
        return 15;
    }

    public ArrowEntity setEffectsAndChance(ArrowEntity entity, EffectInstance[] effects, Random random){


        for (EffectInstance element :
             effects)
        {
            int chance = MathHelper.nextInt(new Random(), 0, 20);
            if(chance <= 3 && element != null)
            {
                entity.addEffect(element);
            }


        }

        return entity;
    }

}

