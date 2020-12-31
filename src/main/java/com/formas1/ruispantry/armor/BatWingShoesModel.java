package com.formas1.ruispantry.armor;
import java.util.Vector;

import com.formas1.ruispantry.RuisPantry;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.Vector3d;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

// Here we are extending ArmorBaseModel class that we just got from BlockBench

/* Basically this is the class you get when you export your BlockBench model as a .java
*  Change the class name to whatever you want
*  Note: constructors must have the same name as their class so we will have to change both names
*/

public class BatWingShoesModel extends ArmorBaseModel {

// Keep in mind that this is just a model I made up off the top of my head, this won't work in game
// As long as you put your actual model exported from BlockBench in, it will be fine

/* What we are doing below is creating parts of our model, but right now we haven't defined them
*  In the setupArmorParts method we will define them
*  Now, we just have to change some stuff up
*/

/* This is how BlockBench gives it to us:
*   private final ModelRenderer myHatPart1;
*   private final ModelRenderer myHatPart2;
*/

/* Below is what we need to change it to
*  Why do we do this though?
*  This is because we aren't done toying with the model parts yet so we can't make them final
*  As you may have guessed, final means final in java (in other words not to be changed)
*  More importantly, we haven't even defined these parts, we shouldn't make them final right now
*/

/* One important thing to note is that you must delete all of the ModelRenderer variables that we already defined in our extended class
*  This is gonna be our armorHead, armorBody, armorRightArm, etc.
*  If you don't know which variable we need to delete, go back and reference our ArmorBaseModel class
*  Every variable defined there is what we need to delete, and we need to delete the entire line
*  We will fix all the errors your IDE is giving you in a second so just be patient
*/
	private ModelRenderer RightLeg;
	private ModelRenderer cube_r1;
	private ModelRenderer LeftLeg;
	private ModelRenderer cube_r2;
	
	public boolean isFlying;
	
	public float time = 0.00F;

    static ResourceLocation ourTexture = new ResourceLocation("rpantry:textures/models/armor/bat_wing_shoes.png");

    
    public BatWingShoesModel() {
        super(32, 32, ourTexture);
        setupArmorParts();
    }

    public void setupArmorParts()
    {
    	textureWidth = 32;
		textureHeight = 32;
		
        RightLeg = new ModelRenderer(textureWidth, textureHeight, 0, 0);
        RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		RightLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 1.0F, false);

		cube_r1 = new ModelRenderer(textureWidth, textureHeight, 0, 0);
		cube_r1.setRotationPoint(-1.6F, 8.5F, 0.0F);
		RightLeg.addChild(cube_r1);
		setRotationAngles(cube_r1, 0.0F, 0.0F, 0.3491F);
		cube_r1.setTextureOffset(0, 0).addBox(-9.5F, -5.5F, 0.0F, 9.0F, 7.0F, 0.0F, 0.0F, false);
		
		LeftLeg = new ModelRenderer(textureWidth, textureHeight, 0, 0);
		LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		LeftLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 1.0F, false);
		
		cube_r2 = new ModelRenderer(textureWidth, textureHeight, 0, 0);
		cube_r2.setRotationPoint(1.6F, 8.5F, 0.0F);
		LeftLeg.addChild(cube_r2);
		setRotationAngles(cube_r2, 0.0F, -0.0436F, -0.3491F);
		cube_r2.setTextureOffset(0, 0).addBox(0.5F, -5.5F, 0.0F, 9.0F, 7.0F, 0.0F, 0.0F, true);
		
    }

    public BipedModel applySlot(EquipmentSlotType slot){
        armorHead.showModel = false;
        armorBody.showModel = false;
        armorRightArm.showModel = false;
        armorLeftArm.showModel = false;
        armorRightLeg.showModel = false;
        armorLeftLeg.showModel = false;
        armorRightBoot.showModel = false;
        armorLeftBoot.showModel = false;

        switch(slot){
            case HEAD:
                armorHead.showModel = true;
                break;
            case CHEST:
                armorBody.showModel = true;
                armorRightArm.showModel = true;
                armorLeftArm.showModel = true;
                break;
            case LEGS:
                armorRightLeg.showModel = true;
                armorLeftLeg.showModel = true;
                break;
            case FEET:
                armorRightBoot.showModel = true;
                armorLeftBoot.showModel = true;
                break;
            default:
                break;
        }

        return this;
    }

    @SuppressWarnings("unchecked")
	public final BatWingShoesModel applyEntityStats(BipedModel defaultArmor){
        this.isChild = defaultArmor.isChild;
        this.isSneak = defaultArmor.isSneak;
        this.isSitting = defaultArmor.isSitting;
        this.rightArmPose = defaultArmor.rightArmPose;
        this.leftArmPose = defaultArmor.leftArmPose;

        return this;
    }


  /*  public static BatWingShoesModel getModel()
    {
		return model;
    }
   */
    
    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
    {    	
		copyModelAngles(bipedRightLeg, RightLeg);
		copyModelAngles(bipedLeftLeg, LeftLeg);
		
		matrixStack.push();
		
        if(isSneak) {
        	RightLeg.rotationPointY = 12.2F;
            LeftLeg.rotationPointY = 12.2F;
        	RightLeg.rotationPointZ = 4.0F;
            LeftLeg.rotationPointZ = 4.0F;
        } else {
        	RightLeg.rotationPointY = 12.0F;
            LeftLeg.rotationPointY = 12.0F;
            RightLeg.rotationPointZ = 0.0F;
            LeftLeg.rotationPointZ = 0.0F;
        }
        if(isFlying || (!isFlying && (cube_r1.rotateAngleX > 0.5F || cube_r1.rotateAngleY < -0.5F || cube_r2.rotateAngleX > 0.5F || cube_r2.rotateAngleY > 0.5F))) {
        	cube_r1.rotateAngleX = (float) (Math.sin(time)*0.1+0.1) * 3;
        	cube_r1.rotateAngleY = (float) (Math.sin(time)*0.1+0.1) * -3;
        	cube_r2.rotateAngleX = (float) (Math.sin(time)*0.1+0.1) * 3;
        	cube_r2.rotateAngleY = (float) (Math.sin(time)*0.1+0.1) * 3;
        } else {
        	cube_r1.rotateAngleX = 0.0F;
        	cube_r1.rotateAngleY = 0.0F; 
        	cube_r2.rotateAngleX = 0.0F;
        	cube_r2.rotateAngleY = 0.0F;
        }
    	RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		
		matrixStack.pop();
    }

	public final void setRotationAngles(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
	
    private final void copyModelAngles(ModelRenderer in, ModelRenderer out){
        out.rotateAngleX = in.rotateAngleX;
        out.rotateAngleY = in.rotateAngleY;
        out.rotateAngleZ = in.rotateAngleZ;
    }
}