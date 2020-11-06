package me.jellysquid.mods.sodium.mixin.features.chunk_rendering;

import me.jellysquid.mods.sodium.client.world.SodiumChunkManager;
import net.minecraft.client.world.ClientChunkManager;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientWorld.class)
public abstract class MixinClientWorld {
    /**
     * Replace the client world chunk manager with our own implementation that is both faster and contains additional
     * features needed to pull off event-based rendering.
     */
    @Dynamic
    @Redirect(method = "method_2940", at = @At(value = "NEW", target = "net/minecraft/client/world/ClientChunkManager"))
    private static ClientChunkManager redirectCreateChunkManager(ClientWorld world, int renderDistance) {
        return new SodiumChunkManager(world, renderDistance);
    }
}
