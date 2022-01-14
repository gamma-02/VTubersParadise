package gamma02.vtubersparadise.blockEntities;

import gamma02.vtubersparadise.VTubersParadise;
import gamma02.vtubersparadise.VTubersParadiseClient;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.ChestType;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.system.CallbackI;

import javax.annotation.Nonnull;
import java.util.List;

public class StarterChestBlockEntity extends LockableLootTileEntity implements IChestLid, ITickableTileEntity {
    /** The current angle of the lid (between 0 and 1) */
    protected float lidAngle;
    /** The angle of the lid last tick */
    protected float prevLidAngle;
    private int ticksSinceSync;
    private int numPlayersUsing;
    private boolean dirty = false;

    public static NonNullList<ItemStack> Inventory = NonNullList.withSize(18, ItemStack.EMPTY);
    private static IInventory otherInventory = new IInventory() {


        @Override
        public int getSizeInventory() {
            return 18;
        }

        @Override
        public boolean isEmpty() {
            return Inventory.stream().allMatch(ItemStack::isEmpty);
        }

        @Override
        public ItemStack getStackInSlot(int index) {
            return Inventory.get(index);
        }

        @Override
        public ItemStack decrStackSize(int index, int count) {
            return Inventory != null && !Inventory.get(index).isEmpty() ? ItemStackHelper.getAndSplit(Inventory, index, count) : ItemStack.EMPTY;

        }

        @Override
        public ItemStack removeStackFromSlot(int index) {
            ItemStack stack = Inventory.get(index);
            if(!stack.isEmpty()) {
                Inventory.set(index, ItemStack.EMPTY);
                return stack;
            }else{
                return ItemStack.EMPTY;
            }
        }

        @Override
        public void setInventorySlotContents(int index, ItemStack stack) {
            Inventory.set(index, stack);
        }

        @Override
        public void markDirty() {

        }

        @Override
        public boolean isUsableByPlayer(PlayerEntity player) {
            boolean output = true;
            for (ItemStack element:
                 player.inventory.mainInventory) {
                if(element.getItem().getCreatorModId(element) == VTubersParadise.ModID){
                    output = false;
                }
            }
            return output;
        }

        @Override
        public void clear() {
            Inventory.clear();
        }
    };

    public StarterChestBlockEntity(TileEntityType<?> typeIn) {
        super(typeIn);
    }
    public StarterChestBlockEntity(){
        super(VTubersParadise.STARTER_CHEST_TYPE);
    }



    @Override
    protected @NotNull NonNullList<ItemStack> getItems() {
        return Inventory;
    }

    @Override
    protected void setItems(@NotNull NonNullList<ItemStack> itemsIn) {
        Inventory = itemsIn;
    }

    @Override
    protected @NotNull ITextComponent getDefaultName() {
        return ITextComponent.getTextComponentOrEmpty("Starter Chest");
    }

    @Override
    protected @NotNull Container createMenu(int id, @Nonnull PlayerInventory player) {
        return new ChestContainer(ContainerType.GENERIC_9X1, id, player, otherInventory, 2);
    }

    @Override
    public int getSizeInventory() {
        return 18;
    }

    @Override
    public float getLidAngle(float partialTicks) {
        return MathHelper.lerp(partialTicks, this.prevLidAngle, this.lidAngle);
    }

    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
        Inventory = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        if (!this.checkLootAndRead(nbt)) {
            ItemStackHelper.loadAllItems(nbt, Inventory);
        }

    }

    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if (!this.checkLootAndWrite(compound)) {
            ItemStackHelper.saveAllItems(compound, Inventory);
        }

        return compound;
    }

    public void tick() {
        if(this.dirty){

            this.dirty = false;
        }
        int i = this.pos.getX();
        int j = this.pos.getY();
        int k = this.pos.getZ();
        ++this.ticksSinceSync;
        this.numPlayersUsing = ChestTileEntity.calculatePlayersUsingSync(this.world, this, this.ticksSinceSync, i, j, k, this.numPlayersUsing);
        this.prevLidAngle = this.lidAngle;
        float f = 0.1F;
        if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F) {
            this.playSound(SoundEvents.BLOCK_CHEST_OPEN);
        }

        if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F) {
            float f1 = this.lidAngle;
            if (this.numPlayersUsing > 0) {
                this.lidAngle += 0.1F;
            } else {
                this.lidAngle -= 0.1F;
            }

            if (this.lidAngle > 1.0F) {
                this.lidAngle = 1.0F;
            }

            float f2 = 0.5F;
            if (this.lidAngle < 0.5F && f1 >= 0.5F) {
                this.playSound(SoundEvents.BLOCK_CHEST_CLOSE);
            }

            if (this.lidAngle < 0.0F) {
                this.lidAngle = 0.0F;
            }
        }

    }
    private void playSound(SoundEvent soundIn) {
        ChestType chesttype = this.getBlockState().get(ChestBlock.TYPE);
        if (chesttype != ChestType.LEFT) {
            double d0 = (double)this.pos.getX() + 0.5D;
            double d1 = (double)this.pos.getY() + 0.5D;
            double d2 = (double)this.pos.getZ() + 0.5D;
            if (chesttype == ChestType.RIGHT) {
                Direction direction = ChestBlock.getDirectionToAttached(this.getBlockState());
                d0 += (double)direction.getXOffset() * 0.5D;
                d2 += (double)direction.getZOffset() * 0.5D;
            }

            this.world.playSound((PlayerEntity)null, d0, d1, d2, soundIn, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
        }
    }
    public void markDirty(){
       this.dirty = true;
    }
}
