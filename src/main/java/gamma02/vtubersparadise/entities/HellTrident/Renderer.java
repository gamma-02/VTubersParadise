package gamma02.vtubersparadise.entities.HellTrident;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;
import software.bernie.geckolib3.renderers.geo.GeoReplacedEntityRenderer;

public class Renderer extends GeoProjectilesRenderer<HellTridentEntityL1>
{
    public Renderer(EntityRendererManager renderManager)
    {
        super(renderManager, new HellTridentModel());
        System.out.println("rendering");
        this.shadowSize = 0.1F; //change 0.7 to the desired shadow size.
    }



}
