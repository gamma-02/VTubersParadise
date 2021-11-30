package gamma02.vtubersparadise.items.SlimeSword;

import gamma02.vtubersparadise.VTubersParadise;
import gamma02.vtubersparadise.entities.SlimeballProjectile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.Random;

public class SlimeSwordL3 extends SlimeSwordL1
{
    public SlimeSwordL3(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn)
    {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        super.onItemRightClick(world, player, hand);
        PlayerEntity player1 = player;
        boolean hasIronIngots = player1.isCreative();
        for (ItemStack stack1: player1.inventory.mainInventory)
        {
            if(stack1.getItem() == Items.IRON_NUGGET)
            {
                hasIronIngots = true;
            }
        }
        if(hasIronIngots && !world.isRemote)
        {
            Entity entity = new SlimeballProjectile(VTubersParadise.SLIME_PROJECTILE.get(), player.getPositionVec().add(0, 1.8, 0), world, true, player1 );
            world.addEntity(entity);

            Vector3d vec = player1.getLookVec().mul(1.3, 1.3, 1.3);

            entity.setVelocity(vec.x, vec.y, vec.z);
            ItemStack stack2 = player1.inventory.getStackInSlot(player1.inventory.getSlotFor(Items.IRON_NUGGET.getDefaultInstance()));
            player1.inventory.getStackInSlot(player1.inventory.getSlotFor(Items.IRON_NUGGET.getDefaultInstance())).setCount(stack2.getCount()-1);
        }
        if(hasIronIngots){

            return ActionResult.resultPass(player.getHeldItem(hand));

        }else{
            return ActionResult.resultFail(player.getHeldItem(hand));
        }


    }

    @Override public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        Random rand = new Random();
        int canDo = MathHelper.nextInt(rand, 0, 1);
        if(canDo == 1){
            target.addPotionEffect(new EffectInstance(Effects.POISON, 100, 1));
        }
        return super.hitEntity(stack, target, attacker);
    }
}
