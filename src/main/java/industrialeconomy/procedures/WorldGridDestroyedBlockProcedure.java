package industrialeconomy.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import industrialeconomy.IndustrialEconomyModVariables;

import industrialeconomy.IndustrialEconomyMod;

public class WorldGridDestroyedBlockProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onBlockBreak(BlockEvent.BreakEvent event) {
			Entity entity = event.getPlayer();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("xpAmount", event.getExpToDrop());
			dependencies.put("x", event.getPos().getX());
			dependencies.put("y", event.getPos().getY());
			dependencies.put("z", event.getPos().getZ());
			dependencies.put("px", entity.getPosX());
			dependencies.put("py", entity.getPosY());
			dependencies.put("pz", entity.getPosZ());
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("blockstate", event.getState());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				IndustrialEconomyMod.LOGGER.warn("Failed to load dependency entity for procedure WorldGridDestroyedBlock!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				IndustrialEconomyMod.LOGGER.warn("Failed to load dependency x for procedure WorldGridDestroyedBlock!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				IndustrialEconomyMod.LOGGER.warn("Failed to load dependency z for procedure WorldGridDestroyedBlock!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				IndustrialEconomyMod.LOGGER.warn("Failed to load dependency world for procedure WorldGridDestroyedBlock!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double grid_X = 0;
		double grid_Z = 0;
		String player_name = "";
		if ((((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new IndustrialEconomyModVariables.PlayerVariables())).admin_editor) == (false))) {
			if (((entity instanceof PlayerEntity) || (entity instanceof ServerPlayerEntity))) {
				player_name = (String) (entity.getDisplayName().getString());
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(new StringTextComponent((("Playername: ") + "" + (player_name))), ChatType.SYSTEM,
								Util.DUMMY_UUID);
				}
				grid_X = (double) Math.floor((x / 20));
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(new StringTextComponent((("land X grid: ") + "" + (grid_X))), ChatType.SYSTEM,
								Util.DUMMY_UUID);
				}
				grid_Z = (double) Math.floor((z / 20));
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(new StringTextComponent((("Land Z grid: ") + "" + (grid_Z))), ChatType.SYSTEM,
								Util.DUMMY_UUID);
				}
				if (((IndustrialEconomyModVariables.WorldVariables.get(world).lands
						.contains(((player_name) + "" + (":") + "" + (grid_X) + "" + (":") + "" + (grid_Z) + "" + (","))))
						&& (IndustrialEconomyModVariables.WorldVariables.get(world).is_city
								.contains(((":") + "" + (grid_X) + "" + (":") + "" + (grid_Z) + "" + (",")))))) {
					return (true);
				} else if (((!(IndustrialEconomyModVariables.WorldVariables.get(world).lands
						.contains(((player_name) + "" + (":") + "" + (grid_X) + "" + (":") + "" + (grid_Z) + "" + (",")))))
						&& (IndustrialEconomyModVariables.WorldVariables.get(world).is_city
								.contains(((":") + "" + (grid_X) + "" + (":") + "" + (grid_Z) + "" + (",")))))) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You dont own this land"), (true));
					}
					if (dependencies.get("event") != null) {
						Object _obj = dependencies.get("event");
						if (_obj instanceof Event) {
							Event _evt = (Event) _obj;
							if (_evt.isCancelable())
								_evt.setCanceled(true);
						}
					}
				} else {
					return (true);
				}
			}
			return (false);
		}
		return (false);
	}
}