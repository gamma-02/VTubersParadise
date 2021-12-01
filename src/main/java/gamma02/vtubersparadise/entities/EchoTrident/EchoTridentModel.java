package gamma02.vtubersparadise.entities.EchoTrident;

import gamma02.vtubersparadise.VTubersParadise;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EchoTridentModel extends AnimatedGeoModel<EchoTridentEntityL1>
{
    @Override public ResourceLocation getModelLocation(EchoTridentEntityL1 object)
    {
        return new ResourceLocation(VTubersParadise.ModID, "geo/trident.geo.json");
    }

    @Override public ResourceLocation getTextureLocation(EchoTridentEntityL1 object)
    {
        return new ResourceLocation(VTubersParadise.ModID, "textures/item/trident2.png");
    }

    @Override public ResourceLocation getAnimationFileLocation(EchoTridentEntityL1 animatable)
    {
        return new ResourceLocation(VTubersParadise.ModID, "animations/trident.animation.json");
    }
}
