package gamma02.vtubersparadise.items.SlimeSword;

import com.google.common.collect.Multimap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.World;

public class SlimeSwordL1 extends SwordItem
{

    public SlimeSwordL1(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn)
    {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);

    }
    @Override public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        return true;
    }

    @Override public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn)
    {
//        AttributeModifier yes = new AttributeModifier(Attributes.ATTACK_DAMAGE, )
//        stack.addAttributeModifier(Attributes.ATTACK_DAMAGE, AttributeModifier., EquipmentSlotType.MAINHAND);
    }
}
