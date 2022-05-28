package imexoodeex.utilities.network;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;

import static imexoodeex.utilities.utilities.MOD_ID;

public class ServerNetworkHandler {

    public static Identifier ISJUMPING_PACKET = new Identifier(MOD_ID, "isjumping_packet");

}