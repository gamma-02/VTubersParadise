package gamma02.vtubersparadise.entities.HellTrident;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

public class Renderer2 extends GeoProjectilesRenderer<HellTridentEntityL2>
{
    public Renderer2(EntityRendererManager renderManager)
    {
        super(renderManager, new HellTridentModel2());
        System.out.println("rendering");
        this.shadowSize = 0.1F; //change 0.7 to the desired shadow size.
    }

}