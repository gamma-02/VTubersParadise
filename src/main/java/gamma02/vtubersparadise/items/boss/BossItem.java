package gamma02.vtubersparadise.items.boss;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class BossItem extends SwordItem {


    public BossItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, 1));
        target.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 100));

        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, @NotNull World worldIn, @NotNull Entity entityIn, int itemSlot, boolean isSelected) {
        if(isSelected && entityIn instanceof LivingEntity){
            ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.RESISTANCE, 3, 1));
            ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 3));

        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public @NotNull ActionResult<ItemStack> onItemRightClick(@NotNull World worldIn, @NotNull PlayerEntity playerIn, @NotNull Hand handIn) {

        if(!playerIn.getCooldownTracker().hasCooldown(this)){
            LightningBoltEntity lightningBolt = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, worldIn);
//            Vector3d vector3d = playerIn.getLookVec();
//            vector3d = vector3d.add(vector3d.x < 0 ? -5 : 5, vector3d.y < 0 ? -5 : 5, vector3d.z < 0 ? -5 : 5);
            Vector3d vector3d = playerIn.getPositionVec();
            vector3d = vector3d.add(playerIn.getLookVec().x*5, 0, playerIn.getLookVec().z * 5);
            lightningBolt.setPosition(vector3d.x, vector3d.y, vector3d.z);
            worldIn.addEntity(lightningBolt);
            playerIn.getCooldownTracker().setCooldown(this, 600);
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
