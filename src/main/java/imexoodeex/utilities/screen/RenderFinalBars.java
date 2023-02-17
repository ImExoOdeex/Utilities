package imexoodeex.utilities.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.*;

public class RenderFinalBars extends RendererBars {

    @Override
    protected void renderGuiQuad(BufferBuilder buffer, int x, int y, double width, int height, int red, int green, int blue, int alpha) {
        RenderSystem.setShader(GameRenderer::getPositionColorProgram);
        buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        buffer.vertex(x, y, 0.0D).color(red, green, blue, alpha).next();
        buffer.vertex(x, y + height, 0.0D).color(red, green, blue, alpha).next();
        buffer.vertex(x + width, y + height, 0.0D).color(red, green, blue, alpha).next();
        buffer.vertex(x + width, y, 0.0D).color(red, green, blue, alpha).next();
        BufferRenderer.draw(buffer.end());
    }
}
