
package industrialeconomy.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import industrialeconomy.procedures.GeneratorWorkingLabelProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class ElectricFurnanceGuiWindow extends ContainerScreen<ElectricFurnanceGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = ElectricFurnanceGui.guistate;

	public ElectricFurnanceGuiWindow(ElectricFurnanceGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("industrial_economy:textures/electric_furnance.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		if (GeneratorWorkingLabelProcedure
				.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("industrial_economy:textures/mamguienergy.png"));
			this.blit(ms, this.guiLeft + 58, this.guiTop + 21, 0, 0, 16, 16, 16, 16);
		}

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("industrial_economy:textures/fire.png"));
		this.blit(ms, this.guiLeft + 79, this.guiTop + 41, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("industrial_economy:textures/industrial_diamond_block.png"));
		this.blit(ms, this.guiLeft + 42, this.guiTop + 41, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("industrial_economy:textures/diamond_imitation.png"));
		this.blit(ms, this.guiLeft + 113, this.guiTop + 41, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Electric Furnance", 16, 6, -16777216);
		if (GeneratorWorkingLabelProcedure
				.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Working", 80, 24, -13369600);
		this.font.drawString(ms, "250 MW", 131, 6, -16764007);
		this.font.drawString(ms, "MK2", 109, 6, -15762043);
		this.font.drawString(ms, "+", 67, 44, -12829636);
		this.font.drawString(ms, "=", 102, 44, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
	}
}
