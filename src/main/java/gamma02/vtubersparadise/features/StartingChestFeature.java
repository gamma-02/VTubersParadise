package gamma02.vtubersparadise.features;

import com.mojang.serialization.Codec;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import gamma02.vtubersparadise.VTubersParadise;
import gamma02.vtubersparadise.blockEntities.StarterChestBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import org.lwjgl.system.CallbackI;

import static gamma02.vtubersparadise.blockEntities.StarterChestBlockEntity.Inventory;

public class StartingChestFeature extends Feature<NoFeatureConfig> {
    public StartingChestFeature(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {

        BlockPos pos1 = new BlockPos(pos.getX(), generator.getHeight(pos.getX(), pos.getZ(), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES), pos.getZ());
        reader.setBlockState(pos1, VTubersParadise.STARTER_CHEST_BLOCK.get().getDefaultState(), 2);
        Inventory.set(0, VTubersParadise.ASTRO_SCYTHE_L1.get().getDefaultInstance());
        Inventory.set(1, VTubersParadise.SHINE_SWORD_L1.get().getDefaultInstance());
        Inventory.set(2, VTubersParadise.SLIME_SWORD_L1.get().getDefaultInstance());
        Inventory.set(3, VTubersParadise.BECKY_BOWL_L1.get().getDefaultInstance());
        Inventory.set(4, VTubersParadise.DISDEERS_CLAWS_L1.get().getDefaultInstance());
        Inventory.set(5, VTubersParadise.NEON_BLADE_L1.get().getDefaultInstance());
        Inventory.set(6, VTubersParadise.FIRE_KATANA_L1.get().getDefaultInstance());
        Inventory.set(7, VTubersParadise.HELL_TRIDENT_L1.get().getDefaultInstance());
        Inventory.set(8, VTubersParadise.ASTRO_SCYTHE_L1.get().getDefaultInstance());


        BlockState blockstate = Blocks.TORCH.getDefaultState();


        return false;
    }
    public static NonNullList<Item> items = NonNullList.withSize(VTubersParadise.Items.getEntries().size(), Items.AIR);
    static {
        int i = 0;
        for (RegistryObject<Item> element : VTubersParadise.Items.getEntries()) {
            items.set(i, element.get());
            i++;
        }
    }
}