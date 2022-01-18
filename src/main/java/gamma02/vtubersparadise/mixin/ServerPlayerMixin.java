package gamma02.vtubersparadise.mixin;

import gamma02.vtubersparadise.VTubersParadise;
import gamma02.vtubersparadise.blockEntities.StarterChestBlock;
import gamma02.vtubersparadise.blockEntities.StarterChestBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.*;

import static gamma02.vtubersparadise.features.StartingChestFeature.items;

@Mixin(PlayerEntity.class)
public abstract class ServerPlayerMixin {


    @Shadow public Container openContainer;

    @Shadow public abstract OptionalInt openContainer(@Nullable INamedContainerProvider p_213829_1_);

    @Shadow @Final public PlayerInventory inventory;

    @Shadow public abstract void closeScreen();

    @Shadow protected abstract boolean isMovementBlocked();

    @Inject(method = "tick", at = @At("HEAD"))
    public void tickMixin(CallbackInfo ci){
//        if(this.openContainer != null){
//            if(this.openContainer.getInventory().equals(StarterChestBlockEntity.Inventory)){
//                boolean e = false;
//                for (ItemStack element:
//                     this.inventory.mainInventory) {
//                    e = items.stream().anyMatch( (item) -> item == element.getItem());
//                }
//
//                if(e) {
//                    this.closeScreen();
//                }
//            }
//        }
        if(this.openContainer.getInventory().containsAll(StarterChestBlockEntity.Inventory)){
            Set<Item> set = new HashSet<Item>(Collections.EMPTY_SET);
            set.addAll(items);
            if(this.inventory.hasAny(set)){
                this.closeScreen();
            }
        }
    }

}
