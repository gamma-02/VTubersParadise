package gamma02.vtubersparadise.blockEntities;

import gamma02.vtubersparadise.VTubersParadise;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class StarterChestBlock extends ContainerBlock {
    public StarterChestBlock(Properties properties) {
        super(properties);
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




}
