package gamma02.vtubersparadise.entities.ElectroTridentEntity;

import com.mojang.blaze3d.matrix.MatrixStack;
import gamma02.vtubersparadise.VTubersParadise;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

@OnlyIn(Dist.CLIENT)
public class ElectroRenderer extends GeoProjectilesRenderer<ElectroTridentEntity> {
    public static final ResourceLocation TRIDENT = new ResourceLocation(VTubersParadise.ModID, "textures/item/villan/villain1.png");
    private static final ElectroTridentModel tridentModel = new ElectroTridentModel();

    public ElectroRenderer(EntityRendererManager renderManagerIn) {

        super(renderManagerIn, tridentModel);


    }

    @Override public ResourceLocation getEntityTexture(ElectroTridentEntity entity)
    {
        return TRIDENT;
    }


    @Override
    public void render(ElectroTridentEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {

        matrixStackIn.push();
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90f ));
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch) + 90f ));
        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    /**
     * Returns the location of an entity's texture.
     */

    @Override public ResourceLocation getTextureLocation(ElectroTridentEntity instance)
    {
        return TRIDENT;
    }
}
