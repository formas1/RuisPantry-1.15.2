package com.formas1.ruispantry.packets;

import java.util.function.Supplier;

import com.formas1.ruispantry.RuisPantry;
import com.formas1.ruispantry.capabilities.BatWingBootsFlyCapability;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class BatWingShoesFlyPacket {
     private final int id;
        public BatWingShoesFlyPacket(PacketBuffer buf) {
            id = buf.readInt();
        }
        public BatWingShoesFlyPacket(int id) {
            this.id = id;
        }
        public void toBytes(PacketBuffer buf) {
            buf.writeInt(id);    
        }

        public boolean handle(Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
            	BatWingBootsFlyCapability cap = ctx.get().getSender().getCapability(BatWingBootsFlyCapability.LEVITATE_CAPABILITY).orElse(null);
            	if(id == 1) cap.isPressed1 = true;
            	else if(id == 2) cap.isPressed2 = false;
            });
            return true;
        }
}