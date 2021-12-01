package gamma02.vtubersparadise.entities;

import gamma02.vtubersparadise.VTubersParadise;
import gamma02.vtubersparadise.entities.HellTrident.HellTridentEntityL1;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("vtubersparadise")
public class ModEntities
{

    public static EntityType<HellTridentEntityL1> HELL_TRIDENT_ENTITY_L1 = null;

    @Mod.EventBusSubscriber(modid = VTubersParadise.ModID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistrationHandler {


        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event)
        {
            HELL_TRIDENT_ENTITY_L1 = build("hell_trident_entity_l1", net.minecraft.entity.EntityType.Builder.<HellTridentEntityL1>create(HellTridentEntityL1::new, EntityClassification.MISC).size(net.minecraft.entity.EntityType.TRIDENT.getWidth(), net.minecraft.entity.EntityType.TRIDENT.getHeight()).setShouldReceiveVelocityUpdates(true).setUpdateInterval(120));
            event.getRegistry().registerAll(HELL_TRIDENT_ENTITY_L1);
        }
    }
    private static <T extends Entity> EntityType<T> build(final String name, final EntityType.Builder<T> builder) {
        final ResourceLocation registryName = new ResourceLocation(VTubersParadise.ModID, name);

        final EntityType<T> entityType = builder
                .build(registryName.toString());

        entityType.setRegistryName(registryName);

        return entityType;
    }
}
