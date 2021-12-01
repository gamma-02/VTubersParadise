package gamma02.vtubersparadise.entities.EchoTrident;

import com.mojang.blaze3d.matrix.MatrixStack;
import gamma02.vtubersparadise.VTubersParadise;
import gamma02.vtubersparadise.entities.NeonSwordEntity.NeonSwordEntity;
import gamma02.vtubersparadise.entities.NeonSwordEntity.NeonSwordModel;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

public class EchoTridentRender extends GeoProjectilesRenderer<EchoTridentEntityL1>
{

    public static final ResourceLocation TRIDENT = new ResourceLocation(VTubersParadise.ModID, "textures/item/trident2.png");
    private static final EchoTridentModel tridentModel = new EchoTridentModel();

    public EchoTridentRender(EntityRendererManager renderManagerIn)
    {

        super(renderManagerIn, tridentModel);

    }

    @Override public ResourceLocation getEntityTexture(EchoTridentEntityL1 entity)
    {
        return TRIDENT;
    }

    @Override public void render(EchoTridentEntityL1 entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn)
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

    @Override public ResourceLocation getTextureLocation(EchoTridentEntityL1 instance)
    {
        return TRIDENT;
    }
}
