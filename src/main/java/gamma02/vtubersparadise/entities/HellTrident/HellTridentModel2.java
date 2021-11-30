package gamma02.vtubersparadise.entities.HellTrident;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HellTridentModel2 extends AnimatedGeoModel<HellTridentEntityL2>
{

    @Override public ResourceLocation getModelLocation(HellTridentEntityL2 object)
    {
        return new ResourceLocation("vtubersparadise", "geo/sodatrident.geo.json");
    }

    @Override public ResourceLocation getTextureLocation(HellTridentEntityL2 object)
    {
        return new ResourceLocation("vtubersparadise", "textures/item/soda1.png");
    }

    @Override public ResourceLocation getAnimationFileLocation(HellTridentEntityL2 animatable)
    {
        return new ResourceLocation("vtubersparadise", "animations/sodatrident.animation.json");
    }
}

