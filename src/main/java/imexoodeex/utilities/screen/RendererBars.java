package imexoodeex.utilities.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.emi.trinkets.api.TrinketsApi;
import imexoodeex.utilities.items.trinkets.CloudInABalloon;
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

import java.awt.*;

public abstract class RendererBars extends DrawableHelper implements HudRenderCallback {

    private final MinecraftClient mc;

    public RendererBars() {
        mc = MinecraftClient.getInstance();
    }

    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {

        PlayerEntity player = mc.player;
        if ((TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemRegister.rocket_boots) || TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemRegister.spectre_boots)
                || TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemRegister.cloudinabottle) || TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemRegister.cloudinaballoon))
                && utilities.CONFIG.barStuff.display_bars) {

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
            } else if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemRegister.cloudinaballoon) || CloudInABalloon.isSelected) {
                ItemInt2 = CloudInABalloon.a;
                ItemIntMax2 = utilities.CONFIG.cooldown;
            }

            int x = (w / 2 - ((utilities.CONFIG.barStuff.bar_size) / 2) + utilities.CONFIG.barStuff.x);
            int y = h - 45 + utilities.CONFIG.barStuff.y;

            double width = (ItemInt * 100 / ItemIntMax) * ((double) utilities.CONFIG.barStuff.bar_size / 100);
            double width2 = (ItemInt2 * 100 / ItemIntMax2) * ((double) utilities.CONFIG.barStuff.bar_size / 100);
            renderBars(width, width2, x, y, player);
        }
    }

    public void renderBars(double width, double width2, int x, int y, PlayerEntity player) {
        RenderSystem.disableDepthTest();
//        RenderSystem.disable();
        RenderSystem.disableBlend();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();

        Color color1 = new Color(utilities.CONFIG.barStuff.bar_color1);
        int red1 = color1.getRed();
        int green1 = color1.getGreen();
        int blue1 = color1.getBlue();

        Color color2 = new Color(utilities.CONFIG.barStuff.bar_color2);
        int red2 = color2.getRed();
        int green2 = color2.getGreen();
        int blue2 = color2.getBlue();

        if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemRegister.rocket_boots) || TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemRegister.spectre_boots)) {
            this.renderGuiQuad(bufferBuilder, x, y, width, 1, red1, green1, blue1, 255);
        }
        this.renderGuiQuad(bufferBuilder, x, y + 1, width2, 1, red2, green2, blue2, 255);

        RenderSystem.enableBlend();
//        RenderSystem.enableTexture();
        RenderSystem.enableDepthTest();
    }

    protected abstract void renderGuiQuad(BufferBuilder buffer, int x, int y, double width, int height, int red, int green, int blue, int alpha);
}