package imexoodeex.utilities.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.emi.trinkets.api.TrinketsApi;
import imexoodeex.utilities.config.ClothConfig;
import imexoodeex.utilities.items.trinkets.CloudInABottle;
import imexoodeex.utilities.items.trinkets.RocketBoots;
import imexoodeex.utilities.items.trinkets.SpectreBoots;
import imexoodeex.utilities.registers.ItemRegister;
import imexoodeex.utilities.utilities;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import static imexoodeex.utilities.utilities.LOGGER;

public abstract class RendererBars extends DrawableHelper implements HudRenderCallback {

    private final MinecraftClient mc;

    public RendererBars() {
        mc = MinecraftClient.getInstance();
    }

    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {

        PlayerEntity player = mc.player;
        if ((TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemRegister.rocket_boots) || TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemRegister.spectre_boots))
                && ClothConfig.BarStuff.display_bars) {

            int w = mc.getWindow().getScaledWidth();
            int h = mc.getWindow().getScaledHeight();
            double ItemInt = 0;
            double ItemIntMax = 0;
            double ItemInt2 = 0;
            double ItemIntMax2 = 0;

            if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemRegister.rocket_boots)) {
                ItemInt = RocketBoots.FLIGHTTIME;
                ItemIntMax = RocketBoots.flightTimeMax;
            } else if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemRegister.spectre_boots)) {
                ItemInt = SpectreBoots.FLIGHTTIME;
                ItemIntMax = SpectreBoots.flightTimeMax;
            }
            if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemRegister.cloudinabottle)) {
                ItemInt2 = CloudInABottle.a;
                ItemIntMax2 = utilities.CONFIG.cooldown;
            }

            // TODO: add cloud in a bottle

            int x = (int) (w / 2 - ((ClothConfig.BarStuff.bar_size * 100) / 2) + ClothConfig.BarStuff.x);
            int y = h - 45 + ClothConfig.BarStuff.y;

            // TODO: change bar size in config from x.x to x

            double width = (ItemInt * 100 / ItemIntMax) * (0. + ClothConfig.BarStuff.bar_size);
            double width2 = (ItemInt2 * 100 / ItemIntMax2) * (0. + ClothConfig.BarStuff.bar_size);
            renderBar(width, width2, x, y);
        }
    }

    public void renderBar(double width, double width2, int x, int y) {
        RenderSystem.disableDepthTest();
        RenderSystem.disableTexture();
        RenderSystem.disableBlend();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        this.renderGuiQuad(bufferBuilder, x, y, width, 1, 255, 255, 255, 255);
        this.renderGuiQuad(bufferBuilder, x, y + 1, width2, 1, 0, 0, 0, 20);
        RenderSystem.enableBlend();
        RenderSystem.enableTexture();
        RenderSystem.enableDepthTest();
    }

    protected abstract void renderGuiQuad(BufferBuilder buffer, int x, int y, double width, int height, int red, int green, int blue, int alpha);
}