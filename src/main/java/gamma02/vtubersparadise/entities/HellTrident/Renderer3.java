package gamma02.vtubersparadise.entities.HellTrident;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

public class Renderer3 extends GeoProjectilesRenderer<HellTridentEntityL3>
{
    public Renderer3(EntityRendererManager renderManager)
    {
        super(renderManager, new HellTridentModel3());
        System.out.println("rendering");
        this.shadowSize = 0.1F;
    }
    @Override public ResourceLocation getEntityTexture(HellTridentEntityL3 entity){
        return new ResourceLocation("vtubersparadise", "textures/item/soda1.png");
    }

}