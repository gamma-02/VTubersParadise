package gamma02.vtubersparadise.entities.NeonSwordEntity;

import com.mojang.blaze3d.matrix.MatrixStack;
import gamma02.vtubersparadise.VTubersParadise;
import gamma02.vtubersparadise.entities.HellTrident.HellTridentEntityL1;
import gamma02.vtubersparadise.entities.HellTrident.HellTridentModel;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

public class NeonSpearRender extends GeoProjectilesRenderer<NeonSwordEntity>
{

    public static final ResourceLocation TRIDENT = new ResourceLocation(VTubersParadise.ModID, "textures/item/pixel1.png");
    private static final NeonSwordModel tridentModel = new NeonSwordModel();

    public NeonSpearRender(EntityRendererManager renderManagerIn)
    {

        super(renderManagerIn, tridentModel);

    }

    @Override public ResourceLocation getEntityTexture(NeonSwordEntity entity)
    {
        return TRIDENT;
    }

    @Override public void render(NeonSwordEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn)
    {

        matrixStackIn.push();
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(
                MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90f));
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(
                MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch) + 90f));
        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    /**
     * Returns the location of an entity's texture.
     */

    @Override public ResourceLocation getTextureLocation(NeonSwordEntity instance)
    {
        return TRIDENT;
    }
}
