package gamma02.vtubersparadise.entities.NeonSwordEntity;

import gamma02.vtubersparadise.VTubersParadise;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NeonSwordModel extends AnimatedGeoModel<NeonSwordEntity>
{

    @Override public ResourceLocation getModelLocation(NeonSwordEntity object)
    {
        return new ResourceLocation(VTubersParadise.ModID, "geo/neonsword.geo.json");
    }

    @Override public ResourceLocation getTextureLocation(NeonSwordEntity object)
    {
        return new ResourceLocation(VTubersParadise.ModID, "textures/item/pixel1.png");
    }

    @Override public ResourceLocation getAnimationFileLocation(NeonSwordEntity animatable)
    {
        return new ResourceLocation(VTubersParadise.ModID, "animations/model.animation.json");
    }
}
