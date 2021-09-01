package industrialeconomy.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.Property;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.block.BlockState;

import java.util.Map;

import industrialeconomy.block.MinerblockBlock;
import industrialeconomy.block.LimestoneinactiveBlock;
import industrialeconomy.block.LimestoneactiveBlock;
import industrialeconomy.block.IronOreNodeBlockInactiveBlock;
import industrialeconomy.block.IronOreNodeBlockBlock;
import industrialeconomy.block.CopperNodeInactveBlock;
import industrialeconomy.block.CopperNodeBlock;
import industrialeconomy.block.CoalNodeInactiveBlock;
import industrialeconomy.block.CoalNodeBlock;
import industrialeconomy.block.CateriumNodeBlockInactiveBlock;
import industrialeconomy.block.CateriumNODEblockBlock;

import industrialeconomy.IndustrialEconomyModVariables;

import industrialeconomy.IndustrialEconomyMod;

public class MinerinactiveUpdateTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				IndustrialEconomyMod.LOGGER.warn("Failed to load dependency x for procedure MinerinactiveUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				IndustrialEconomyMod.LOGGER.warn("Failed to load dependency y for procedure MinerinactiveUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				IndustrialEconomyMod.LOGGER.warn("Failed to load dependency z for procedure MinerinactiveUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				IndustrialEconomyMod.LOGGER.warn("Failed to load dependency world for procedure MinerinactiveUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		String owner = "";
		double players_hub_x = 0;
		double players_hub_y = 0;
		double players_hub_z = 0;
		double miners_level = 0;
		owner = (String) (new Object() {
			public String getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "owner"));
		players_hub_x = (double) (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world,
				new BlockPos((int) IndustrialEconomyModVariables.WorldVariables.get(world).server_x,
						(int) IndustrialEconomyModVariables.WorldVariables.get(world).server_y,
						(int) IndustrialEconomyModVariables.WorldVariables.get(world).server_z),
				((owner) + "" + ("hub_X"))));
		players_hub_y = (double) (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world,
				new BlockPos((int) IndustrialEconomyModVariables.WorldVariables.get(world).server_x,
						(int) IndustrialEconomyModVariables.WorldVariables.get(world).server_y,
						(int) IndustrialEconomyModVariables.WorldVariables.get(world).server_z),
				((owner) + "" + ("hub_Y"))));
		players_hub_z = (double) (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world,
				new BlockPos((int) IndustrialEconomyModVariables.WorldVariables.get(world).server_x,
						(int) IndustrialEconomyModVariables.WorldVariables.get(world).server_y,
						(int) IndustrialEconomyModVariables.WorldVariables.get(world).server_z),
				((owner) + "" + ("hub_Z"))));
		miners_level = (double) (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world,
				new BlockPos((int) IndustrialEconomyModVariables.WorldVariables.get(world).server_x,
						(int) IndustrialEconomyModVariables.WorldVariables.get(world).server_y,
						(int) IndustrialEconomyModVariables.WorldVariables.get(world).server_z),
				((owner) + "" + ("_minerLevel"))));
		if ((((new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) players_hub_x, (int) players_hub_y, (int) players_hub_z), "Energy")) >= (15 * miners_level))
				&& (((new Object() {
					public double getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos((int) x, (int) (y - 1), (int) z), "can_be_mined")) >= 1) && ((LimestoneactiveBlock.block == (world
						.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock())
						|| (((CoalNodeBlock.block == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock())
								|| (IronOreNodeBlockBlock.block == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))
								|| ((CateriumNODEblockBlock.block == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock())
										|| (CopperNodeBlock.block == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)))
												.getBlock()))))))) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = MinerblockBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				TileEntity _te = world.getTileEntity(_bp);
				CompoundNBT _bnbt = null;
				if (_te != null) {
					_bnbt = _te.write(new CompoundNBT());
					_te.remove();
				}
				world.setBlockState(_bp, _bs, 3);
				if (_bnbt != null) {
					_te = world.getTileEntity(_bp);
					if (_te != null) {
						try {
							_te.read(_bso, _bnbt);
						} catch (Exception ignored) {
						}
					}
				}
			}
		} else {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putBoolean("Working", (false));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (((LimestoneactiveBlock.block == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()) && ((new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) (y - 1), (int) z), "can_be_mined")) == 0))) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) z);
					BlockState _bs = LimestoneinactiveBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					TileEntity _te = world.getTileEntity(_bp);
					CompoundNBT _bnbt = null;
					if (_te != null) {
						_bnbt = _te.write(new CompoundNBT());
						_te.remove();
					}
					world.setBlockState(_bp, _bs, 3);
					if (_bnbt != null) {
						_te = world.getTileEntity(_bp);
						if (_te != null) {
							try {
								_te.read(_bso, _bnbt);
							} catch (Exception ignored) {
							}
						}
					}
				}
			}
			if (((CoalNodeBlock.block == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()) && ((new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) (y - 1), (int) z), "can_be_mined")) == 0))) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) z);
					BlockState _bs = CoalNodeInactiveBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					TileEntity _te = world.getTileEntity(_bp);
					CompoundNBT _bnbt = null;
					if (_te != null) {
						_bnbt = _te.write(new CompoundNBT());
						_te.remove();
					}
					world.setBlockState(_bp, _bs, 3);
					if (_bnbt != null) {
						_te = world.getTileEntity(_bp);
						if (_te != null) {
							try {
								_te.read(_bso, _bnbt);
							} catch (Exception ignored) {
							}
						}
					}
				}
			}
			if (((IronOreNodeBlockBlock.block == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()) && ((new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) (y - 1), (int) z), "can_be_mined")) == 0))) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) z);
					BlockState _bs = IronOreNodeBlockInactiveBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					TileEntity _te = world.getTileEntity(_bp);
					CompoundNBT _bnbt = null;
					if (_te != null) {
						_bnbt = _te.write(new CompoundNBT());
						_te.remove();
					}
					world.setBlockState(_bp, _bs, 3);
					if (_bnbt != null) {
						_te = world.getTileEntity(_bp);
						if (_te != null) {
							try {
								_te.read(_bso, _bnbt);
							} catch (Exception ignored) {
							}
						}
					}
				}
			}
			if (((CateriumNODEblockBlock.block == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()) && ((new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) (y - 1), (int) z), "can_be_mined")) == 0))) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) z);
					BlockState _bs = CateriumNodeBlockInactiveBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					TileEntity _te = world.getTileEntity(_bp);
					CompoundNBT _bnbt = null;
					if (_te != null) {
						_bnbt = _te.write(new CompoundNBT());
						_te.remove();
					}
					world.setBlockState(_bp, _bs, 3);
					if (_bnbt != null) {
						_te = world.getTileEntity(_bp);
						if (_te != null) {
							try {
								_te.read(_bso, _bnbt);
							} catch (Exception ignored) {
							}
						}
					}
				}
			}
			if (((CopperNodeBlock.block == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()) && ((new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) (y - 1), (int) z), "can_be_mined")) == 0))) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) z);
					BlockState _bs = CopperNodeInactveBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					TileEntity _te = world.getTileEntity(_bp);
					CompoundNBT _bnbt = null;
					if (_te != null) {
						_bnbt = _te.write(new CompoundNBT());
						_te.remove();
					}
					world.setBlockState(_bp, _bs, 3);
					if (_bnbt != null) {
						_te = world.getTileEntity(_bp);
						if (_te != null) {
							try {
								_te.read(_bso, _bnbt);
							} catch (Exception ignored) {
							}
						}
					}
				}
			}
		}
	}
}
