package gamma02.vtubersparadise.mixin;

import gamma02.vtubersparadise.features.StartingChestFeature;
import gamma02.vtubersparadise.features.SussyBakaUwu;
import net.minecraft.inventory.IInventory;
import net.minecraft.profiler.IProfiler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.server.ServerChunkProvider;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.ISpawnWorldInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin extends World implements SussyBakaUwu {

    @Shadow @Nonnull public abstract MinecraftServer getServer();

    @Shadow public abstract ServerChunkProvider getChunkProvider();

    @Shadow public abstract BlockPos getSpawnPoint();

    public boolean loaded = false;


    protected ServerWorldMixin(ISpawnWorldInfo worldInfo, RegistryKey<World> dimension, DimensionType dimensionType, Supplier<IProfiler> profiler, boolean isRemote, boolean isDebug, long seed) {
        super(worldInfo, dimension, dimensionType, profiler, isRemote, isDebug, seed);
    }


    @Inject(method = "tick", at = @At("HEAD"))
    public void tickMixin(BooleanSupplier j, CallbackInfo ci){

        if(this.isAreaLoaded(this.getSpawnPoint(), 1) && !this.loaded){
            StartingChestFeature generate = new StartingChestFeature(NoFeatureConfig.CODEC);
            generate.generate(((ISeedReader) this), (this.getChunkProvider().generator), new Random(), this.getServer().func_241755_D_().getSpawnPoint(), NoFeatureConfig.INSTANCE);
            this.loaded = true;

        }
    }



}
