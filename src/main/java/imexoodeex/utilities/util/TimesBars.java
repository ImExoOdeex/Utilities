package imexoodeex.utilities.util;

import com.mojang.blaze3d.systems.RenderSystem;
import imexoodeex.utilities.items.trinkets.RocketBoots;
import imexoodeex.utilities.utilities;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.util.math.MatrixStack;

public abstract class TimesBars extends DrawableHelper implements HudRenderCallback {

    private final MinecraftClient mc;

    public TimesBars() {
        mc = MinecraftClient.getInstance();
    }

    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {

        int width = mc.getWindow().getScaledWidth();
        int height = mc.getWindow().getScaledHeight();
        int x = width / 2 - 7;
        int y = height - 30;

//        if (utilities.CONFIG.display_bars) {
            int ItemInt = (int) RocketBoots.FLIGHTTIME;
//            int item = (int) (ItemInt / RocketBoots.flightTimeMax * 100);
            int item = 100;

            renderBar(item, x, y);
//        }
    }

    public void renderBar(int item, int x, int y) {
        RenderSystem.disableDepthTest();
        RenderSystem.disableTexture();
        RenderSystem.disableBlend();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        int width = item;
        this.renderGuiQuad(bufferBuilder, x, y, 13, 2, 0, 0, 0, 255);
        this.renderGuiQuad(bufferBuilder, x, y, width, 1, 255, 255, 255, 255);
        RenderSystem.enableBlend();
        RenderSystem.enableTexture();
        RenderSystem.enableDepthTest();
    }

    protected abstract void renderGuiQuad(BufferBuilder buffer, int x, int y, int width, int height, int red, int green, int blue, int alpha);
}