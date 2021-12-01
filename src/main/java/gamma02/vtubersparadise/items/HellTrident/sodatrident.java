package gamma02.vtubersparadise.items.HellTrident;// Made with Blockbench 4.0.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import gamma02.vtubersparadise.entities.HellTrident.HellTridentEntityL1;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.projectile.AbstractArrowEntity;


public class sodatrident extends Model
{

	private final ModelRenderer group2;
	private final ModelRenderer cube_r1;
	private final ModelRenderer group3;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer group4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer group;
	private final ModelRenderer cube_r7;

	public sodatrident() {
		super(RenderType::getEntitySolid);
		textureWidth = 32;
		textureHeight = 32;

		group2 = new ModelRenderer(this);
		group2.setRotationPoint(-8.0F, 16.0F, 8.0F);
		group2.setTextureOffset(31, 2).addBox(7.55F, -8.0F, -8.95F, 0.0F, 21.0F, 0.0F, 0.0F, false);
		group2.setTextureOffset(27, 30).addBox(7.5F, -6.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group2.setTextureOffset(27, 32).addBox(7.5F, 2.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group2.setTextureOffset(27, 31).addBox(7.5F, 10.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group2.setTextureOffset(6, 32).addBox(6.625F, 12.875F, -8.75F, 2.0F, 4.0F, 0.0F, 0.0F, true);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(15.0F, 8.0F, -17.0F);
		group2.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.7854F);
		cube_r1.setTextureOffset(0, 11).addBox(0.5F, 10.375F, 8.0F, 2.0F, 2.0F, 1.0F, 0.0F, true);
		cube_r1.setTextureOffset(0, 11).addBox(-2.5F, 7.375F, 8.0F, 2.0F, 2.0F, 1.0F, 0.0F, true);

		group3 = new ModelRenderer(this);
		group3.setRotationPoint(-8.0F, 16.0F, 8.0F);
		group3.setTextureOffset(0, 15).addBox(4.375F, -14.0F, -8.75F, 1.0F, 4.0F, 0.0F, 0.0F, false);
		group3.setTextureOffset(0, 15).addBox(10.5F, -14.0F, -8.75F, 1.0F, 4.0F, 0.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(15.0F, 8.0F, -17.0F);
		group3.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -0.3927F);
		cube_r2.setTextureOffset(3, 15).addBox(2.75F, -18.4F, 8.125F, 0.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(15.0F, 8.0F, -17.0F);
		group3.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, 0.3927F);
		cube_r3.setTextureOffset(3, 15).addBox(-16.3F, -13.0F, 8.125F, 0.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(15.0F, 8.0F, -17.0F);
		group3.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 0.7854F);
		cube_r4.setTextureOffset(3, 9).addBox(-23.1F, -8.75F, 8.125F, 0.0F, 0.0F, 0.0F, 0.0F, false);
		cube_r4.setTextureOffset(3, 9).addBox(-18.725F, -13.125F, 8.125F, 0.0F, 0.0F, 0.0F, 0.0F, false);

		group4 = new ModelRenderer(this);
		group4.setRotationPoint(0.0F, 24.0F, 0.0F);
		group4.setTextureOffset(0, 15).addBox(3.0F, -21.0F, -0.95F, 1.0F, 4.0F, 0.0F, 0.0F, false);
		group4.setTextureOffset(0, 15).addBox(-4.125F, -21.0F, -0.95F, 1.0F, 4.0F, 0.0F, 0.0F, false);
		group4.setTextureOffset(2, 16).addBox(-2.0F, -16.1F, -1.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(7.0F, 0.0F, -9.0F);
		group4.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, 0.7854F);
		cube_r5.setTextureOffset(8, 30).addBox(-20.0F, -5.0F, 8.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(7.0F, 0.0F, -9.0F);
		group4.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, -0.7854F);
		cube_r6.setTextureOffset(8, 30).addBox(7.0F, -15.0F, 8.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		group = new ModelRenderer(this);
		group.setRotationPoint(-8.0F, 16.0F, 8.0F);
		group.setTextureOffset(22, 5).addBox(6.5F, -18.25F, -8.75F, 3.0F, 6.0F, 0.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(15.0F, 8.0F, -17.0F);
		group.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, 0.7854F);
		cube_r7.setTextureOffset(20, 1).addBox(-20.5F, -10.625F, 8.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r7.setTextureOffset(15, 21).addBox(-24.5F, -14.625F, 8.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
	}


	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		this.group2.render(matrixStack, buffer, packedLight, packedOverlay);
		this.group3.render(matrixStack, buffer, packedLight, packedOverlay);
		this.group4.render(matrixStack, buffer, packedLight, packedOverlay);
		this.group.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}