package com.formas1.ruispantry.client.entity.model;

import com.formas1.ruispantry.entities.UndeadVindicator;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.monster.AbstractIllagerEntity;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;

public class UndeadVindicatorModel<T extends UndeadVindicator> extends EntityModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer chest;
	private final ModelRenderer jacket;
	private final ModelRenderer head;
	private final ModelRenderer nose;
	private final ModelRenderer armsvillager;
	private final ModelRenderer armstogheter;
	private final ModelRenderer rightarm;
	private final ModelRenderer leftarm;
	private final ModelRenderer armsplayer;
	private final ModelRenderer right;
	private final ModelRenderer left;
	private final ModelRenderer legs;
	private final ModelRenderer leftleg;
	private final ModelRenderer rightleg;
	private float field_217145_m;

	public UndeadVindicatorModel() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);

		chest = new ModelRenderer(this);
		chest.setRotationPoint(0.0F, -13.0F, 0.0F);
		body.addChild(chest);
		chest.setTextureOffset(16, 20).addBox(-4.0F, -11.0F, -3.0F, 8, 12, 6, 0.0F, false);

		jacket = new ModelRenderer(this);
		jacket.setRotationPoint(0.0F, 13.0F, 0.0F);
		chest.addChild(jacket);
		jacket.setTextureOffset(0, 38).addBox(-4.0F, -23.5F, -3.0F, 8, 12, 6, 0.5F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -11.5F, 0.0F);
		chest.addChild(head);
		head.setTextureOffset(0, 0).addBox(-4.0F, -9.5F, -4.0F, 8, 10, 8, 0.0F, false);

		nose = new ModelRenderer(this);
		nose.setRotationPoint(0.0F, 0.5F, -2.5F);
		head.addChild(nose);
		nose.setTextureOffset(24, 0).addBox(-1.0F, -3.0F, -3.5F, 2, 4, 2, 0.0F, false);

		armsvillager = new ModelRenderer(this);
		armsvillager.setRotationPoint(0.0F, -5.0F, -3.0F);
		setRotationAngle(armsvillager, -0.7854F, 0.0F, 0.0F);
		chest.addChild(armsvillager);

		armstogheter = new ModelRenderer(this);
		armstogheter.setRotationPoint(0.0F, 2.0F, -2.0F);
		armsvillager.addChild(armstogheter);
		armstogheter.setTextureOffset(40, 38).addBox(-4.0F, -2.0F, -1.0F, 8, 4, 4, 0.0F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(0.0F, 0.0F, 0.0F);
		armsvillager.addChild(rightarm);
		rightarm.setTextureOffset(44, 22).addBox(-8.0F, -4.0F, -3.0F, 4, 8, 4, 0.0F, false);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(0.0F, 0.0F, 0.0F);
		armsvillager.addChild(leftarm);
		leftarm.setTextureOffset(44, 22).addBox(4.0F, -4.0F, -3.0F, 4, 8, 4, 0.0F, false);

		armsplayer = new ModelRenderer(this);
		armsplayer.setRotationPoint(4.0F, 20.0F, -4.0F);
		chest.addChild(armsplayer);

		right = new ModelRenderer(this);
		right.setRotationPoint(-10.0F, -29.0F, 4.0F);
		setRotationAngle(right, -1.3963F, 0.0F, 0.2618F);
		armsplayer.addChild(right);
		right.setTextureOffset(40, 46).addBox(-2.0F, -1.0F, -2.0F, 4, 12, 4, 0.0F, false);

		left = new ModelRenderer(this);
		left.setRotationPoint(2.0F, -28.0F, 4.0F);
		setRotationAngle(left, 0.0F, 0.0F, -0.1745F);
		armsplayer.addChild(left);
		left.setTextureOffset(40, 46).addBox(-3.0353F, -2.1363F, -2.0F, 4, 12, 4, 0.0F, false);

		legs = new ModelRenderer(this);
		legs.setRotationPoint(0.0F, -6.0F, 0.0F);
		body.addChild(legs);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(2.0F, -4.0F, 0.0F);
		legs.addChild(leftleg);
		leftleg.setTextureOffset(0, 22).addBox(-2.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-2.0F, -4.0F, 0.0F);
		legs.addChild(rightleg);
		rightleg.setTextureOffset(0, 22).addBox(-2.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public ModelRenderer getModelHead() {
		return this.head;
	}
	
	 public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	      this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
	      this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
	      //this.armsvillager.rotationPointY = 3.0F;
	      //this.armsvillager.rotationPointZ = -1.0F;
	      //this.armsvillager.rotateAngleX = -0.75F;
	      if (this.isSitting) {
	         this.right.rotateAngleX = (-(float)Math.PI / 5F);
	         this.right.rotateAngleY = 0.0F;
	         this.right.rotateAngleZ = 0.0F;
	         this.left.rotateAngleX = (-(float)Math.PI / 5F);
	         this.left.rotateAngleY = 0.0F;
	         this.left.rotateAngleZ = 0.0F;
	         this.legs.rotateAngleX = -1.4137167F;
	         this.legs.rotateAngleY = ((float)Math.PI / 10F);
	         this.legs.rotateAngleZ = 0.07853982F;
	      } else {
	         this.right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
	         this.right.rotateAngleY = 0.0F;
	         this.right.rotateAngleZ = 0.0F;
	         this.left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
	         this.left.rotateAngleY = 0.0F;
	         this.left.rotateAngleZ = 0.0F;
	         this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
	         this.rightleg.rotateAngleY = 0.0F;
	         this.rightleg.rotateAngleZ = 0.0F;
	         this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
	         this.leftleg.rotateAngleY = 0.0F;
	         this.leftleg.rotateAngleZ = 0.0F;
	      }

	      AbstractIllagerEntity.ArmPose abstractillagerentity$armpose = entityIn.getArmPose();
	      if (abstractillagerentity$armpose == AbstractIllagerEntity.ArmPose.ATTACKING) {
	         float f = MathHelper.sin(this.swingProgress * (float)Math.PI);
	         float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float)Math.PI);
	         this.right.rotateAngleZ = 0.0F;
	         this.left.rotateAngleZ = 0.0F;
	         this.right.rotateAngleY = 0.15707964F;
	         this.left.rotateAngleY = -0.15707964F;
	         if (entityIn.getPrimaryHand() == HandSide.RIGHT) {
	            this.right.rotateAngleX = -1.8849558F + MathHelper.cos(ageInTicks * 0.09F) * 0.15F;
	            this.left.rotateAngleX = -0.0F + MathHelper.cos(ageInTicks * 0.19F) * 0.5F;
	            this.right.rotateAngleX += f * 2.2F - f1 * 0.4F;
	            this.left.rotateAngleX += f * 1.2F - f1 * 0.4F;
	         } else {
	            this.right.rotateAngleX = -0.0F + MathHelper.cos(ageInTicks * 0.19F) * 0.5F;
	            this.left.rotateAngleX = -1.8849558F + MathHelper.cos(ageInTicks * 0.09F) * 0.15F;
	            this.right.rotateAngleX += f * 1.2F - f1 * 0.4F;
	            this.left.rotateAngleX += f * 2.2F - f1 * 0.4F;
	         }

	         this.right.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
	         this.left.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
	         this.right.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	         this.left.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	      } else if (abstractillagerentity$armpose == AbstractIllagerEntity.ArmPose.SPELLCASTING) {
	         this.right.rotationPointZ = 0.0F;
	         this.right.rotationPointX = -5.0F;
	         this.left.rotationPointZ = 0.0F;
	         this.left.rotationPointX = 5.0F;
	         this.right.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F) * 0.25F;
	         this.left.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F) * 0.25F;
	         this.right.rotateAngleZ = 2.3561945F;
	         this.left.rotateAngleZ = -2.3561945F;
	         this.right.rotateAngleY = 0.0F;
	         this.left.rotateAngleY = 0.0F;
	      } else if (abstractillagerentity$armpose == AbstractIllagerEntity.ArmPose.BOW_AND_ARROW) {
	         this.right.rotateAngleY = -0.1F + this.head.rotateAngleY;
	         this.right.rotateAngleX = (-(float)Math.PI / 2F) + this.head.rotateAngleX;
	         this.left.rotateAngleX = -0.9424779F + this.head.rotateAngleX;
	         this.left.rotateAngleY = this.head.rotateAngleY - 0.4F;
	         this.left.rotateAngleZ = ((float)Math.PI / 2F);
	      } else if (abstractillagerentity$armpose == AbstractIllagerEntity.ArmPose.CROSSBOW_HOLD) {
	         this.right.rotateAngleY = -0.3F + this.head.rotateAngleY;
	         this.left.rotateAngleY = 0.6F + this.head.rotateAngleY;
	         this.right.rotateAngleX = (-(float)Math.PI / 2F) + this.head.rotateAngleX + 0.1F;
	         this.left.rotateAngleX = -1.5F + this.head.rotateAngleX;
	      } else if (abstractillagerentity$armpose == AbstractIllagerEntity.ArmPose.CROSSBOW_CHARGE) {
	         this.right.rotateAngleY = -0.8F;
	         this.right.rotateAngleX = -0.97079635F;
	         this.left.rotateAngleX = -0.97079635F;
	         float f2 = MathHelper.clamp(this.field_217145_m, 0.0F, 25.0F);
	         this.left.rotateAngleY = MathHelper.lerp(f2 / 25.0F, 0.4F, 0.85F);
	         this.left.rotateAngleX = MathHelper.lerp(f2 / 25.0F, this.left.rotateAngleX, (-(float)Math.PI / 2F));
	      } else if (abstractillagerentity$armpose == AbstractIllagerEntity.ArmPose.CELEBRATING) {
	         this.right.rotationPointZ = 0.0F;
	         this.right.rotationPointX = -5.0F;
	         this.right.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F) * 0.05F;
	         this.right.rotateAngleZ = 2.670354F;
	         this.right.rotateAngleY = 0.0F;
	         this.left.rotationPointZ = 0.0F;
	         this.left.rotationPointX = 5.0F;
	         this.left.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F) * 0.05F;
	         this.left.rotateAngleZ = -2.3561945F;
	         this.left.rotateAngleY = 0.0F;
	      }

	      boolean flag = abstractillagerentity$armpose == AbstractIllagerEntity.ArmPose.CROSSED;
	      this.armsvillager.showModel = flag;
	      //this.armstogheter.showModel = flag;
	      this.armsplayer.showModel = !flag;
	      this.armsplayer.showModel = !flag;
	   }
	 
	 public ModelRenderer getLegs() {
		return legs;
	}
	 
	 public ModelRenderer getHead() {
		return head;
	}
	 
	 public ModelRenderer getBody() {
		return body;
	}
	 
	  public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
	      this.field_217145_m = (float)entityIn.getItemInUseMaxCount();
	      super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	   }
}