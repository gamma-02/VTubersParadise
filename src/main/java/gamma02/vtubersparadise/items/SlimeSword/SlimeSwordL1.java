package gamma02.vtubersparadise.items.SlimeSword;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
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
    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {

        CompoundNBT nbt = stack.serializeNBT();
        if(!nbt.getBoolean("Unbreakable")){
            nbt.putBoolean("Unbreakable", true);
        }
        stack.deserializeNBT(nbt);

    }

}
