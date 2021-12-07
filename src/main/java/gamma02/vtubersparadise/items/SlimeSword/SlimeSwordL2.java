package gamma02.vtubersparadise.items.SlimeSword;

import gamma02.vtubersparadise.VTubersParadise;
import gamma02.vtubersparadise.entities.ModEntities;
import gamma02.vtubersparadise.entities.SlimeballProjectile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class SlimeSwordL2 extends SlimeSwordL1
{
    private int timer = 0;
    public SlimeSwordL2(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn)
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
        if(hasIronIngots && !world.isRemote && !player1.getCooldownTracker().hasCooldown(player.getHeldItem(hand).getItem()))
        {
            SlimeballProjectile entity = new SlimeballProjectile(ModEntities.SLIMEBALL_PROJECTILE, player.getPositionVec().add(0, 1.8, 0), world, false, player1 );
            world.addEntity(entity);

            Vector3d vec = player1.getLookVec().mul(1.3, 1.3, 1.3);

            entity.setVelocity(vec.x, vec.y, vec.z);
            ItemStack stack2 = player1.inventory.getStackInSlot(player1.inventory.getSlotFor(Items.IRON_NUGGET.getDefaultInstance()));
            if(!player1.isCreative())
            {
                player1.inventory.getStackInSlot(player1.inventory.getSlotFor(Items.IRON_NUGGET.getDefaultInstance()))
                        .setCount(stack2.getCount() - 1);
            }
            player1.getCooldownTracker().setCooldown(player1.getHeldItem(hand).getItem(), 20);
        }
        if(hasIronIngots){

            return ActionResult.resultPass(player.getHeldItem(hand));

        }else{
            return ActionResult.resultFail(player.getHeldItem(hand));
        }


    }

//    @Override public void onUse(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count)
//    {
//        if(livingEntityIn instanceof ServerPlayerEntity){
//            ServerPlayerEntity user = (ServerPlayerEntity) livingEntityIn;
//            boolean hasIronIngots = false;
//            for (ItemStack stack1:
//                 user.inventory.mainInventory)
//            {
//                if(stack1.getItem() == Items.IRON_INGOT) hasIronIngots = true;
//            }
//            if(hasIronIngots){
//                new SlimeballProjectile(VTubersParadise.SLIME_PROJECTILE.get(), livingEntityIn.getPosition().add(0, 1.8, 0), worldIn, livingEntityIn.getLookVec().mul(0.5, 0.5, 0.5),true, (PlayerEntity) livingEntityIn );
//            }
//        }
//        super.onUse(worldIn, livingEntityIn, stack, count);
//    }

    @Override public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot,
            boolean isSelected)
    {
        if(this.timer > 0){
            this.timer--;
        }
    }
}
