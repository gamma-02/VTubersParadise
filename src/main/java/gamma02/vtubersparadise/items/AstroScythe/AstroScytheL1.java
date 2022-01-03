package gamma02.vtubersparadise.items.AstroScythe;

import gamma02.vtubersparadise.items.IExtendedReach;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeMod;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

public class AstroScytheL1 extends SwordItem implements IExtendedReach
{

    public AstroScytheL1(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn)
    {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @ParametersAreNonnullByDefault
    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot,
            boolean isSelected)
    {

        if(entityIn instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityIn;

            if (player.getHeldItemMainhand().getItem() instanceof AstroScytheL1)
            {
                Objects.requireNonNull(player.getAttribute(ForgeMod.REACH_DISTANCE.get())).setBaseValue(6);
            } else
            {
                Objects.requireNonNull(player.getAttribute(ForgeMod.REACH_DISTANCE.get())).setBaseValue(5);
            }

        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override public double getCustomReach()
    {
        return 6;
    }

    @Override
    public boolean hitEntity( ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        if(target.getHeldItemMainhand().getItem() == Items.SHIELD){
            target.getHeldItemMainhand().setCount(0);
        }else if(target.getHeldItemOffhand().getItem() == Items.SHIELD){
            target.getHeldItemOffhand().setCount(0);
        }
        return true;
    }

    @Override public UseAction getUseAction(ItemStack stack)
    {
        return UseAction.BLOCK;
    }
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }


    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);
        return ActionResult.resultConsume(itemstack);
    }
}

