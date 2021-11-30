package gamma02.vtubersparadise.entities.HellTrident;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.geo.raw.pojo.RawGeoModel;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class HellTridentModel extends AnimatedGeoModel<HellTridentEntityL1>
{


    @Override public ResourceLocation getModelLocation(HellTridentEntityL1 object)
    {
        return new ResourceLocation("vtubersparadise", "geo/sodatrident.geo.json");
    }

    @Override public ResourceLocation getTextureLocation(HellTridentEntityL1 object)
    {
        return new ResourceLocation("vtubersparadise", "textures/item/soda1.png");
    }

    @Override public ResourceLocation getAnimationFileLocation(HellTridentEntityL1 animatable)
    {
        return new ResourceLocation("vtubersparadise", "animations/sodatrident.animation.json");
    }
}
