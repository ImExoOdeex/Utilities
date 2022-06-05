package imexoodeex.utilities.mixin;

import dev.emi.trinkets.api.TrinketsApi;
import imexoodeex.utilities.config.ClothConfig;
import imexoodeex.utilities.items.trinkets.GPS;
import imexoodeex.utilities.items.trinkets.Radar;
import imexoodeex.utilities.items.trinkets.Stopwatch;
import imexoodeex.utilities.items.trinkets.Watch;
import imexoodeex.utilities.registers.ItemRegister;
import imexoodeex.utilities.utilities;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {

    String TEXT = "";
    String TEXT2 = "";

    @Inject(at = @At("TAIL"), method = "render")
    public void render(MatrixStack matrixStack, float tickDelta, CallbackInfo info) {

        int width = MinecraftClient.getInstance().getWindow().getScaledWidth();
        int height = MinecraftClient.getInstance().getWindow().getScaledHeight();
        MinecraftClient client = MinecraftClient.getInstance();
        PlayerEntity player = client.player;

        boolean isEquipped = TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemRegister.stopwatch) ||
                TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemRegister.gps) ||
                TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemRegister.radar) ||
                TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemRegister.watch);

        if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemRegister.stopwatch)) {
            TEXT = Stopwatch.text;
            TEXT2 = Stopwatch.text1;
        } else if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemRegister.gps)) {
            TEXT = GPS.text;
            TEXT2 = GPS.text1;
        } else if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemRegister.radar)) {
            TEXT = Radar.text;
            TEXT2 = Radar.text1;
        } else if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemRegister.watch)) {
            TEXT = Watch.text;
            TEXT2 = Watch.text1;
        }

        if (isEquipped) {
            if (utilities.CONFIG.text_location.equals(ClothConfig.TEXT_ENUM.LEFT_BOTTOM)) {
                this.renderText(matrixStack, client.textRenderer, TEXT, 10, height - 10, 0xffffff, 1);
                this.renderText(matrixStack, client.textRenderer, TEXT2, 10, height - 20, 0xffffff, 1);
            } // set text to left bottom
            else if (utilities.CONFIG.text_location.equals(ClothConfig.TEXT_ENUM.LEFT_MID)) {
                this.renderText(matrixStack, client.textRenderer, TEXT, 10, height / 2, 0xffffff, 1);
                this.renderText(matrixStack, client.textRenderer, TEXT2, 10, height / 2 - 10, 0xffffff, 1);
            } // set text to left top
            else if (utilities.CONFIG.text_location.equals(ClothConfig.TEXT_ENUM.LEFT_TOP)) {
                this.renderText(matrixStack, client.textRenderer, TEXT, 10, 20, 0xffffff, 1);
                this.renderText(matrixStack, client.textRenderer, TEXT2, 10, 30, 0xffffff, 1);
            } // set text to right bottom
            else if (utilities.CONFIG.text_location.equals(ClothConfig.TEXT_ENUM.RIGHT_BOTTOM)) {
                this.renderText(matrixStack, client.textRenderer, TEXT, width - 60, height - 20, 0xffffff, 1);
                this.renderText(matrixStack, client.textRenderer, TEXT2, width - 60, height - 30, 0xffffff, 1);
            } // set text to right mid
            else if (utilities.CONFIG.text_location.equals(ClothConfig.TEXT_ENUM.RIGHT_MID)) {
                this.renderText(matrixStack, client.textRenderer, TEXT, width - 60, height / 2, 0xffffff, 1);
                this.renderText(matrixStack, client.textRenderer, TEXT2, width - 60, height / 2 - 10, 0xffffff, 1);
            } // set text to right top
            else if (utilities.CONFIG.text_location.equals(ClothConfig.TEXT_ENUM.RIGHT_TOP)) {
                this.renderText(matrixStack, client.textRenderer, TEXT, width - 60, 20, 0xffffff, 1);
                this.renderText(matrixStack, client.textRenderer, TEXT2, width - 60, 30, 0xffffff, 1);
            }
        }

//        TODO: add bars render to this
//        https://github.com/ReviversMC/microDurability/blob/master/microdurability-1.18/src/main/java/com/github/reviversmc/microdurability/mixin/InGameHudMixin118.java


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
