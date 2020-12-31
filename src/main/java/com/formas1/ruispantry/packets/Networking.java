package com.formas1.ruispantry.packets;

import com.formas1.ruispantry.RuisPantry;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class Networking {
    private static SimpleChannel INSTANCE;
    private static int ID = 0;
    private static int nextID() {
        return ID++;
    }
    public static void registerMessages() {
        INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(RuisPantry.MOD_ID + "networking"),
                () -> "1.0", s -> true, s -> true);    
        INSTANCE.messageBuilder(BatWingShoesFlyPacket.class, nextID())
        .encoder(BatWingShoesFlyPacket::toBytes)
        .decoder(BatWingShoesFlyPacket::new)
        .consumer(BatWingShoesFlyPacket::handle)
        .add();
    }

    public static void sendToServer(Object packet) {
        INSTANCE.sendToServer(packet);
    }
    public static void sendToClient(Object packet, ServerPlayerEntity player) {
        INSTANCE.sendTo(packet, player.connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
    }
}