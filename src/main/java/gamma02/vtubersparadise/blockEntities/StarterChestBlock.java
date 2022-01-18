package gamma02.vtubersparadise.blockEntities;

import gamma02.vtubersparadise.VTubersParadise;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.ChestType;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMerger;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class StarterChestBlock extends AbstractChestBlock<StarterChestBlockEntity> {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    protected static final VoxelShape SHAPE_SINGLE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 14.0D, 15.0D);

    public StarterChestBlock(Properties properties) {
        super(properties, (Supplier<TileEntityType<? extends StarterChestBlockEntity>>) VTubersParadise.STARTER_CHEST_TYPE);
        this.setDefaultState(this.getStateContainer().getBaseState().with(FACING, Direction.NORTH));
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new StarterChestBlockEntity(VTubersParadise.STARTER_CHEST_TYPE);
    }

    public ActionResultType onBlockActivated(@Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull PlayerEntity player, @Nonnull Hand handIn, @Nonnull BlockRayTraceResult hit){
        TileEntity tileEntity = worldIn.getTileEntity(pos);
        if(tileEntity instanceof StarterChestBlockEntity && player instanceof ServerPlayerEntity){
            NetworkHooks.openGui((ServerPlayerEntity) player, (StarterChestBlockEntity) tileEntity);
        }
        return ActionResultType.SUCCESS;
    }
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
            return SHAPE_SINGLE;
    }
    public void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public TileEntityMerger.ICallbackWrapper<? extends ChestTileEntity> combine(BlockState state, World world, BlockPos pos, boolean override) {
        BiPredicate<IWorld, BlockPos> bipredicate;
        if (override) {
            bipredicate = (worldIn, posIn) -> {
                return false;
            };
        } else {
            bipredicate = ChestBlock::isBlocked;
        }
        return TileEntityMerger.func_226924_a_(VTubersParadise.STARTER_CHEST_TYPE, StarterChestBlock::hackery, ChestBlock::getDirectionToAttached, FACING, state, world, pos, bipredicate);
    }

    public static TileEntityMerger.Type hackery(BlockState state){
        return TileEntityMerger.Type.SINGLE;
    }
}
