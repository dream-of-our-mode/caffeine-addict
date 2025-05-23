package com.caffeineaddict.caffeineaddictmode.blocks.CoffeeMachine;

import static com.caffeineaddict.caffeineaddictmode.CaffeineAddictMode.MOD_ID;

import com.caffeineaddict.caffeineaddictmode.CaffeineAddictMode;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CoffeeMachineScreen extends AbstractContainerScreen<CoffeeMachineMenu> {

    private static final ResourceLocation GUI = new ResourceLocation(MOD_ID, "/textures/gui/shotmachine_v1.png");
    private static final ResourceLocation PLAYER_INVENTORY_TEXTURE = new ResourceLocation("minecraft", "textures/gui/container/generic_54.png");

    public CoffeeMachineScreen(CoffeeMachineMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 256;
        this.imageHeight = 256;
    }

    @Override
    protected void renderBg(PoseStack poseStack, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;
        this.blit(poseStack, x,y, 0, 0, imageWidth, imageHeight);

        RenderSystem.setShaderTexture(0, PLAYER_INVENTORY_TEXTURE);
        this.blit(poseStack, x + 8, y + 84, 0, 71, 162, 86);

        // Draw animated gauge bar for each input slot
        for (int i = 0; i < 2; i++) {
            int fill = menu.getProgressForSlot(i); // progress: 0-24
            int barWidth = (int)(13 * fill / 25.0); // 13 px max bar height
            int barX = x + (i == 0 ? 51 : 105);
            int barY = y + 63;
            this.blit(poseStack, barX, barY,
                    176, 0, barWidth, 6); // x, y, u, v, width, height
        }
    }

    @Override
    protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
        this.font.draw(poseStack, title, 8, 6, 4210752);
        this.font.draw(poseStack, this.playerInventoryTitle, 8, imageHeight - 94, 4210752);
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTick);
        this.renderTooltip(poseStack, mouseX, mouseY);
    }
}