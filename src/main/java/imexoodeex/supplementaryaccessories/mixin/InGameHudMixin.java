package imexoodeex.supplementaryaccessories.mixin;

import imexoodeex.supplementaryaccessories.items.trinkets.GPS;
import imexoodeex.supplementaryaccessories.items.trinkets.Watch;
import net.fabricmc.fabric.mixin.event.lifecycle.client.MinecraftClientMixin;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {

    @Inject(at = @At("TAIL"), method = "render")
    public void render(MatrixStack matrixStack, float tickDelta, CallbackInfo info) {

            int width = MinecraftClient.getInstance().getWindow().getScaledWidth();
            int height = MinecraftClient.getInstance().getWindow().getScaledHeight();
            MinecraftClient client = MinecraftClient.getInstance();

            if (Watch.isEquipped) {
                this.renderText(matrixStack, client.textRenderer, Watch.text, width - 100, height / 2, 0xffffff, 1);
            }
            if (GPS.isEquipped) {
                this.renderText(matrixStack, client.textRenderer, GPS.text, width - 100, height / 2, 0xffffff, 1);
            }
    }

    private void renderText(MatrixStack matrixStack, TextRenderer textRenderer, String text, float x, float y, int color, float scale) {
        matrixStack.push();
        matrixStack.translate(x, y, 0);
        matrixStack.scale(scale, scale, scale);
        matrixStack.translate(-x, -y, 0);

        textRenderer.drawWithShadow(matrixStack, text, x, y - 10, color);

        matrixStack.pop();
    }

}
