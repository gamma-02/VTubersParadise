package gamma02.vtubersparadise;

import gamma02.vtubersparadise.entities.HellTrident.Renderer;
import gamma02.vtubersparadise.entities.HellTrident.Renderer2;
import gamma02.vtubersparadise.entities.HellTrident.Renderer3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = VTubersParadise.ModID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class VTubersParadiseClient
{
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenderers(final FMLClientSetupEvent event) {
        System.out.println("registering");
        RenderingRegistry.registerEntityRenderingHandler(VTubersParadise.HELL_TRIDENT_ENTITY_L1.get(), Renderer::new);
        RenderingRegistry.registerEntityRenderingHandler(VTubersParadise.HELL_TRIDENT_ENTITY_L2.get(), Renderer2::new);
        RenderingRegistry.registerEntityRenderingHandler(VTubersParadise.HELL_TRIDENT_ENTITY_L3.get(), Renderer3::new);
    }
}
