package ru.alfomine.afmtm.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IRenderHandler;
import org.lwjgl.opengl.GL11;

public class RenderColiseumSky extends IRenderHandler {
    private static RenderColiseumSky INSTANCE = null;

    private final ResourceLocation[] textureSkyBox = new ResourceLocation[]{
            new ResourceLocation("afmtm", "textures/skybox_coliseum/0.png"),
            new ResourceLocation("afmtm", "textures/skybox_coliseum/1.png"),
            new ResourceLocation("afmtm", "textures/skybox_coliseum/2.png"),
            new ResourceLocation("afmtm", "textures/skybox_coliseum/3.png"),
            new ResourceLocation("afmtm", "textures/skybox_coliseum/4.png"),
            new ResourceLocation("afmtm", "textures/skybox_coliseum/5.png")};

    public static RenderColiseumSky getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RenderColiseumSky();
        }

        return INSTANCE;
    }

    @Override
    public void render(float partialTicks, WorldClient world, Minecraft mc) {
        Tessellator tessellator = Tessellator.getInstance();

        BufferBuilder bufferbuilder = tessellator.getBuffer();
        double maxUV = 1.0D;
        int BOX_RENDER_RANGE = 100;

        GlStateManager.disableFog();
        GlStateManager.disableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

        // bottom
        Minecraft.getMinecraft().getTextureManager().bindTexture(textureSkyBox[0]);
        bufferbuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_COLOR);
        bufferbuilder.pos(BOX_RENDER_RANGE, -BOX_RENDER_RANGE, BOX_RENDER_RANGE).tex(0.0D, 0.0D).color(1, 1, 1, 1.0F).endVertex();
        bufferbuilder.pos(BOX_RENDER_RANGE, -BOX_RENDER_RANGE, -BOX_RENDER_RANGE).tex(0.0D, maxUV).color(1, 1, 1, 1.0F).endVertex();
        bufferbuilder.pos(-BOX_RENDER_RANGE, -BOX_RENDER_RANGE, -BOX_RENDER_RANGE).tex(maxUV, maxUV).color(1, 1, 1, 1.0F).endVertex();
        bufferbuilder.pos(-BOX_RENDER_RANGE, -BOX_RENDER_RANGE, BOX_RENDER_RANGE).tex(maxUV, 0.0D).color(1, 1, 1, 1.0F).endVertex();
        tessellator.draw();

        // front
        if (textureSkyBox.length > 1) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(textureSkyBox[1]);
        }
        bufferbuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_COLOR);
        bufferbuilder.pos(-BOX_RENDER_RANGE, BOX_RENDER_RANGE, -BOX_RENDER_RANGE).tex(0.0D, 0.0D).color(1, 1, 1, 1.0F).endVertex();
        bufferbuilder.pos(-BOX_RENDER_RANGE, -BOX_RENDER_RANGE, -BOX_RENDER_RANGE).tex(0.0D, maxUV).color(1, 1, 1, 1.0F).endVertex();
        bufferbuilder.pos(BOX_RENDER_RANGE, -BOX_RENDER_RANGE, -BOX_RENDER_RANGE).tex(maxUV, maxUV).color(1, 1, 1, 1.0F).endVertex();
        bufferbuilder.pos(BOX_RENDER_RANGE, BOX_RENDER_RANGE, -BOX_RENDER_RANGE).tex(maxUV, 0.0D).color(1, 1, 1, 1.0F).endVertex();
        tessellator.draw();

        // back
        if (textureSkyBox.length > 1) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(textureSkyBox[2]);
        }
        bufferbuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_COLOR);
        bufferbuilder.pos(BOX_RENDER_RANGE, BOX_RENDER_RANGE, BOX_RENDER_RANGE).tex(0.0D, 0.0D).color(1, 1, 1, 1.0F).endVertex();
        bufferbuilder.pos(BOX_RENDER_RANGE, -BOX_RENDER_RANGE, BOX_RENDER_RANGE).tex(0.0D, maxUV).color(1, 1, 1, 1.0F).endVertex();
        bufferbuilder.pos(-BOX_RENDER_RANGE, -BOX_RENDER_RANGE, BOX_RENDER_RANGE).tex(maxUV, maxUV).color(1, 1, 1, 1.0F).endVertex();
        bufferbuilder.pos(-BOX_RENDER_RANGE, BOX_RENDER_RANGE, BOX_RENDER_RANGE).tex(maxUV, 0.0D).color(1, 1, 1, 1.0F).endVertex();
        tessellator.draw();

        // top
        if (textureSkyBox.length > 1) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(textureSkyBox[3]);
        }
        bufferbuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_COLOR);
        bufferbuilder.pos(BOX_RENDER_RANGE, BOX_RENDER_RANGE, BOX_RENDER_RANGE).tex(0.0D, maxUV).color(1, 1, 1, 1.0F).endVertex();
        bufferbuilder.pos(-BOX_RENDER_RANGE, BOX_RENDER_RANGE, BOX_RENDER_RANGE).tex(maxUV, maxUV).color(1, 1, 1, 1.0F).endVertex();
        bufferbuilder.pos(-BOX_RENDER_RANGE, BOX_RENDER_RANGE, -BOX_RENDER_RANGE).tex(maxUV, 0.0D).color(1, 1, 1, 1.0F).endVertex();
        bufferbuilder.pos(BOX_RENDER_RANGE, BOX_RENDER_RANGE, -BOX_RENDER_RANGE).tex(0.0D, 0.0D).color(1, 1, 1, 1.0F).endVertex();
        tessellator.draw();

        // right
        if (textureSkyBox.length > 1) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(textureSkyBox[4]);
        }
        bufferbuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_COLOR);
        bufferbuilder.pos(BOX_RENDER_RANGE, BOX_RENDER_RANGE, -BOX_RENDER_RANGE).tex(0.0D, 0.0D).color(1, 1, 1, 1.0F).endVertex();
        bufferbuilder.pos(BOX_RENDER_RANGE, -BOX_RENDER_RANGE, -BOX_RENDER_RANGE).tex(0.0D, maxUV).color(1, 1, 1, 1.0F).endVertex();
        bufferbuilder.pos(BOX_RENDER_RANGE, -BOX_RENDER_RANGE, BOX_RENDER_RANGE).tex(maxUV, maxUV).color(1, 1, 1, 1.0F).endVertex();
        bufferbuilder.pos(BOX_RENDER_RANGE, BOX_RENDER_RANGE, BOX_RENDER_RANGE).tex(maxUV, 0.0D).color(1, 1, 1, 1.0F).endVertex();
        tessellator.draw();

        // left
        if (textureSkyBox.length > 1) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(textureSkyBox[5]);
        }
        bufferbuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_COLOR);
        bufferbuilder.pos(-BOX_RENDER_RANGE, BOX_RENDER_RANGE, BOX_RENDER_RANGE).tex(0.0D, 0.0D).color(1, 1, 1, 1.0F).endVertex();
        bufferbuilder.pos(-BOX_RENDER_RANGE, -BOX_RENDER_RANGE, BOX_RENDER_RANGE).tex(0.0D, maxUV).color(1, 1, 1, 1.0F).endVertex();
        bufferbuilder.pos(-BOX_RENDER_RANGE, -BOX_RENDER_RANGE, -BOX_RENDER_RANGE).tex(maxUV, maxUV).color(1, 1, 1, 1.0F).endVertex();
        bufferbuilder.pos(-BOX_RENDER_RANGE, BOX_RENDER_RANGE, -BOX_RENDER_RANGE).tex(maxUV, 0.0D).color(1, 1, 1, 1.0F).endVertex();
        tessellator.draw();

        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
    }
}
