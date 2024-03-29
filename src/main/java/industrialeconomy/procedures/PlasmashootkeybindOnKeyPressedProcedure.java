package industrialeconomy.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import java.util.Random;
import java.util.Map;

import industrialeconomy.item.PlasmaRANGEDITEMItem;
import industrialeconomy.item.DiamondSteelArmorItem;

import industrialeconomy.enchantment.CheapPlasmaEnchantment;
import industrialeconomy.enchantment.BetterCoolDownEnchantmentEnchantment;

import industrialeconomy.IndustrialEconomyModVariables;

import industrialeconomy.IndustrialEconomyMod;

public class PlasmashootkeybindOnKeyPressedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				IndustrialEconomyMod.LOGGER.warn("Failed to load dependency entity for procedure PlasmashootkeybindOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new IndustrialEconomyModVariables.PlayerVariables())).DSA_PlasmaShoot_Cooldown == 0
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST) : ItemStack.EMPTY)
						.getItem() == DiamondSteelArmorItem.body
				&& (entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new IndustrialEconomyModVariables.PlayerVariables())).DSA_PlasmaShoot == true
				&& (entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new IndustrialEconomyModVariables.PlayerVariables())).DSA_energy > 300) {
			if (entity instanceof LivingEntity) {
				Entity _ent = entity;
				if (!_ent.world.isRemote()) {
					PlasmaRANGEDITEMItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 5, (float) 5, (int) 6);
				}
			}
			if (EnchantmentHelper.getEnchantmentLevel(BetterCoolDownEnchantmentEnchantment.enchantment,
					((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST)
							: ItemStack.EMPTY)) == 0) {
				{
					double _setval = 200;
					entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DSA_PlasmaShoot_Cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (EnchantmentHelper.getEnchantmentLevel(BetterCoolDownEnchantmentEnchantment.enchantment,
					((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST)
							: ItemStack.EMPTY)) == 1) {
				{
					double _setval = 150;
					entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DSA_PlasmaShoot_Cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (EnchantmentHelper.getEnchantmentLevel(BetterCoolDownEnchantmentEnchantment.enchantment,
					((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST)
							: ItemStack.EMPTY)) == 2) {
				{
					double _setval = 110;
					entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DSA_PlasmaShoot_Cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (EnchantmentHelper.getEnchantmentLevel(BetterCoolDownEnchantmentEnchantment.enchantment,
					((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST)
							: ItemStack.EMPTY)) == 3) {
				{
					double _setval = 85;
					entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DSA_PlasmaShoot_Cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (EnchantmentHelper.getEnchantmentLevel(CheapPlasmaEnchantment.enchantment,
					((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST)
							: ItemStack.EMPTY)) == 0) {
				{
					double _setval = ((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new IndustrialEconomyModVariables.PlayerVariables())).DSA_energy - 300);
					entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DSA_energy = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (EnchantmentHelper.getEnchantmentLevel(CheapPlasmaEnchantment.enchantment,
					((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST)
							: ItemStack.EMPTY)) == 1) {
				{
					double _setval = ((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new IndustrialEconomyModVariables.PlayerVariables())).DSA_energy - 220);
					entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DSA_energy = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (EnchantmentHelper.getEnchantmentLevel(CheapPlasmaEnchantment.enchantment,
					((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST)
							: ItemStack.EMPTY)) == 2) {
				{
					double _setval = ((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new IndustrialEconomyModVariables.PlayerVariables())).DSA_energy - 150);
					entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DSA_energy = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
