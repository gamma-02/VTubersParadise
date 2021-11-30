package gamma02.vtubersparadise.entities.HellTrident;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HellTridentModel3 extends AnimatedGeoModel<HellTridentEntityL3>
{


    @Override public ResourceLocation getModelLocation(HellTridentEntityL3 object)
    {
        System.out.println("renderingx2");
        return new ResourceLocation("vtubersparadise", "geo/sodatrident.geo.json");
    }

    @Override public ResourceLocation getTextureLocation(HellTridentEntityL3 object)
    {
        System.out.println("renderingx3");
        return new ResourceLocation("vtubersparadise", "textures/item/soda1");
    }

    @Override public ResourceLocation getAnimationFileLocation(HellTridentEntityL3 animatable)
    {
        System.out.println("renderingx4");
        return new ResourceLocation("vtubersparadise", "animations/sodatrident.animation.json");
    }


}