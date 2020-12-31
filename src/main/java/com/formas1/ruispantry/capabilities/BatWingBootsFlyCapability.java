package com.formas1.ruispantry.capabilities;

import com.formas1.ruispantry.RuisPantry;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class BatWingBootsFlyCapability implements Capability.IStorage<BatWingBootsFlyCapability>, ICapabilitySerializable<INBT>{
	
	//put the fields of data your want to store
	public float canLevitate = 10.0F;
	public boolean isPressed1 = false;
	public boolean isPressed2 = true;
	
	//Use this with .getCapability
	@CapabilityInject(BatWingBootsFlyCapability.class)
	public static Capability<BatWingBootsFlyCapability> LEVITATE_CAPABILITY;
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		if(cap == LEVITATE_CAPABILITY) {
			return (LazyOptional<T>)LazyOptional.of(()-> this);
		}else return LazyOptional.empty();
	}
	
	//Call this in FMLCommonSetup
	public static void register() {
	      CapabilityManager.INSTANCE.register(
	              BatWingBootsFlyCapability.class,
	              new BatWingBootsFlyCapability(),
	              BatWingBootsFlyCapability::new);
	}
	
	//put all your fields into the nbt
	@Override
	public INBT serializeNBT() {
		CompoundNBT nbt = new CompoundNBT();
		nbt.putFloat("canLevitate", canLevitate);
		nbt.putBoolean("isPressed1", isPressed1);
		nbt.putBoolean("isPressed2", isPressed2);
		return nbt;
	}
	
	//set all your fields with the nbt
	@Override
	public void deserializeNBT(INBT inbt) {
		CompoundNBT nbt = (CompoundNBT) inbt;
		canLevitate = nbt.getFloat("canLevitate");
		isPressed1 = nbt.getBoolean("isPressed1");
		isPressed2 = nbt.getBoolean("isPressed2");
	}

	@Override
	public INBT writeNBT(Capability<BatWingBootsFlyCapability> capability, BatWingBootsFlyCapability instance, Direction side) {
		return serializeNBT();
	}

	@Override
	public void readNBT(Capability<BatWingBootsFlyCapability> capability, BatWingBootsFlyCapability instance, Direction side,
			INBT nbt) {
		deserializeNBT(nbt);
	}
	
	//Used to actually stick the capability onto things. Change Entity to whichever type you want. Remember to register the Event
	@SubscribeEvent
	public void attachCapabilityEvent(AttachCapabilitiesEvent<Entity> event) {
		event.addCapability(new ResourceLocation(RuisPantry.MOD_ID, "batwingbootsflycapability"), new BatWingBootsFlyCapability());
	}
	
	//Needed for player capabilities if you want the data to persist through death
	@SubscribeEvent
	public void playerClone(PlayerEvent.Clone event) {
		if(!event.isWasDeath()) return;
		BatWingBootsFlyCapability oldCap = event.getOriginal().getCapability(LEVITATE_CAPABILITY).orElse(null);
		BatWingBootsFlyCapability cap = event.getPlayer().getCapability(LEVITATE_CAPABILITY).orElse(null);
		cap.deserializeNBT(oldCap.serializeNBT());
	}

}