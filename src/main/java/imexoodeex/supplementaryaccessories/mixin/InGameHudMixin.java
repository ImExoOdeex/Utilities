package imexoodeex.supplementaryaccessories.mixin;

import imexoodeex.supplementaryaccessories.items.trinkets.GPS;
import imexoodeex.supplementaryaccessories.items.trinkets.Radar;
import imexoodeex.supplementaryaccessories.items.trinkets.Watch;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {

    int accessories = 0;

    @Inject(at = @At("TAIL"), method = "render")
    public void render(MatrixStack matrixStack, float tickDelta, CallbackInfo info) {

        int width = MinecraftClient.getInstance().getWindow().getScaledWidth();
        int height = MinecraftClient.getInstance().getWindow().getScaledHeight();
        MinecraftClient client = MinecraftClient.getInstance();

        if (Watch.isEquipped) {
            this.renderText(matrixStack, client.textRenderer, Watch.text, width - 85, height / 2, 0xffffff, 1);
        }
        if (Radar.isEquipped) {
            this.renderText(matrixStack, client.textRenderer, Radar.text, 10, height / 2, 0xffffff, 1);
        }
        if (GPS.isEquipped) {
            accessories = 10;
            this.renderText(matrixStack, client.textRenderer, GPS.text, width - 85, height / 2 - accessories, 0xffffff, 1);
        } else {
            this.renderText(matrixStack, client.textRenderer, "", width - 85, height / 2 - accessories, 0xffffff, 1);
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
