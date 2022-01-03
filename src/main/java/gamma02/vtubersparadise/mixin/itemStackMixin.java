package gamma02.vtubersparadise.mixin;

import gamma02.vtubersparadise.VTubersParadise;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.World;
import org.lwjgl.system.CallbackI;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Mixin(Item.class)
public abstract class itemStackMixin
{
     HashMap<ItemStack, Boolean> stacks = new HashMap<>();


    @Inject(method = "inventoryTick", at = @At("HEAD"))
    public void tickMixin(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected, CallbackInfo ci){
        System.out.println(stack.getItem());
        if(entityIn instanceof PlayerEntity){
            if (Objects.equals(stack.getItem().getCreatorModId(stack), VTubersParadise.ModID) && !stacks.containsKey(stack))
            {

                CompoundNBT e = new CompoundNBT() ;
                e.putBoolean("Unbreakable", true);
                stack.setTag(e);
                stacks.put(stack, true);
                
                
            }
        }
    }

}
