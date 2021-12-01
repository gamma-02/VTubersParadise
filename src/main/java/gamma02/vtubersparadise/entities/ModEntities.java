package gamma02.vtubersparadise.entities;

import gamma02.vtubersparadise.VTubersParadise;
import gamma02.vtubersparadise.entities.EchoTrident.EchoTridentEntityL1;
import gamma02.vtubersparadise.entities.HellTrident.HellTridentEntityL1;
import gamma02.vtubersparadise.entities.NeonSwordEntity.NeonSwordEntity;
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
    public static EntityType<NeonSwordEntity> NEON_SWORD_ENTITY = null;
    public static EntityType<EchoTridentEntityL1> ECHO_TRIDENT_ENTITY_L1 = null;

    @Mod.EventBusSubscriber(modid = VTubersParadise.ModID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistrationHandler {


        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event)
        {
            HELL_TRIDENT_ENTITY_L1 = build("hell_trident_entity_l1", net.minecraft.entity.EntityType.Builder.<HellTridentEntityL1>create(HellTridentEntityL1::new, EntityClassification.MISC).size(net.minecraft.entity.EntityType.TRIDENT.getWidth(), net.minecraft.entity.EntityType.TRIDENT.getHeight()).setShouldReceiveVelocityUpdates(true).setUpdateInterval(120));
            NEON_SWORD_ENTITY = build("neon_sword_entity", EntityType.Builder.<NeonSwordEntity>create(NeonSwordEntity::new, EntityClassification.MISC).size(EntityType.TRIDENT.getWidth(), EntityType.TRIDENT.getHeight()).setShouldReceiveVelocityUpdates(true).setUpdateInterval(120));
            ECHO_TRIDENT_ENTITY_L1 = build("echo_trident_entity_l1", EntityType.Builder.<EchoTridentEntityL1>create(EchoTridentEntityL1::new, EntityClassification.MISC).size(EntityType.TRIDENT.getWidth(), EntityType.TRIDENT.getHeight()).setShouldReceiveVelocityUpdates(true).setUpdateInterval(120));
            event.getRegistry().registerAll(HELL_TRIDENT_ENTITY_L1, NEON_SWORD_ENTITY);
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
