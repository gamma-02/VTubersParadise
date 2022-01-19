package gamma02.vtubersparadise.entities.ElectroTridentEntity;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import static gamma02.vtubersparadise.VTubersParadise.ModID;

public class ElectroTridentModel extends AnimatedGeoModel<ElectroTridentEntity> {
    @Override
    public ResourceLocation getModelLocation(ElectroTridentEntity object) {
        return new ResourceLocation(ModID, "geo/villain.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(ElectroTridentEntity object) {
        return new ResourceLocation(ModID, "textures/item/villan/villain1.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ElectroTridentEntity animatable) {
        return new ResourceLocation(ModID, "animations/villain.animation.json");
    }
}
