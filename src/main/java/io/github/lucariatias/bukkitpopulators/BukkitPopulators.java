package io.github.lucariatias.bukkitpopulators;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitPopulators extends JavaPlugin {

	/**
	 * Gets the "normal" populators for a particular world.
	 * 
	 * This function works like the ChunkGenerator function, but is not called
	 * by bukkit directly.
	 * 
	 * @param world the world
	 * @return the normal populators for a world
	 * @see ChunkGenerator#getDefaultPopulators(World)
	 * @see BukkitPopulators#getDefaultPopulators(Environment)
	 */
	public List<BlockPopulator> getDefaultPopulators(World world) {
		return getDefaultPopulators(world.getEnvironment());
	}
	
	/**
	 * Gets the "normal" populators for a particular environment.
	 * 
	 * @param world the world
	 * @return the normal populators for a world
	 * @see ChunkGenerator#getDefaultPopulators(World)
	 */
	public List<BlockPopulator> getDefaultPopulators(Environment environment) {
		ArrayList<BlockPopulator> populators = new ArrayList<BlockPopulator>();

		switch (environment) {
			case NORMAL:
				populators.add(new BiomeTreePopulator());
				populators.add(new OrePopulator(Material.COAL_ORE, Material.STONE, 8, 8));
				populators.add(new OrePopulator(Material.IRON_ORE, Material.STONE, 6, 6));
				populators.add(new OrePopulator(Material.LAPIS_ORE, Material.STONE, 2, 4));
				populators.add(new OrePopulator(Material.GOLD_ORE, Material.STONE, 4, 4));
				populators.add(new OrePopulator(Material.DIAMOND_ORE, Material.STONE, 3, 4));
				populators.add(new OrePopulator(Material.REDSTONE_ORE, Material.STONE, 4, 16));
				populators.add(new OrePopulator(Material.EMERALD_ORE, Material.STONE, 1, 3));
				populators.add(new SnowPopulator());
				break;
			case THE_END:
				populators.add(new EndTowerPopulator());
				break;
			case NETHER:
				populators.add(new OrePopulator(Material.QUARTZ_ORE, Material.NETHERRACK, 16, 8));
				populators.add(new NetherSoulSandPopulator());
				populators.add(new NetherFirePopulator());
				populators.add(new NetherGlowstonePopulator());
				break;
		}

		return populators;
	}

	/**
	 * Get all populators available
	 * 
	 * @param world the world
	 * @return all the populators available
	 * @deprecated World parameter is no longer needed
	 * @see BukkitPopulators#getAllPopulators()
	 */
	@Deprecated
	public List<BlockPopulator> getAllPopulators(World world) {
		return getAllPopulators();
	}
	
	/**
	 * Get all populators available
	 * 
	 * @return all the populators available
	 */
	public List<BlockPopulator> getAllPopulators() {
		ArrayList<BlockPopulator> populators = new ArrayList<BlockPopulator>();

		populators.add(new BiomeTreePopulator());
		populators.add(new BiomeTreePopulator());
		populators.add(new OrePopulator(Material.COAL_ORE, Material.STONE, 8, 8));
		populators.add(new OrePopulator(Material.IRON_ORE, Material.STONE, 6, 6));
		populators.add(new OrePopulator(Material.LAPIS_ORE, Material.STONE, 2, 4));
		populators.add(new OrePopulator(Material.GOLD_ORE, Material.STONE, 4, 4));
		populators.add(new OrePopulator(Material.DIAMOND_ORE, Material.STONE, 3, 4));
		populators.add(new OrePopulator(Material.REDSTONE_ORE, Material.STONE, 4, 16));
		populators.add(new OrePopulator(Material.EMERALD_ORE, Material.STONE, 1, 3));
		populators.add(new OrePopulator(Material.QUARTZ_ORE, Material.NETHERRACK, 16, 8));
		populators.add(new SnowPopulator());
		populators.add(new EndTowerPopulator());
		populators.add(new NetherSoulSandPopulator());
		populators.add(new NetherFirePopulator());
		populators.add(new NetherGlowstonePopulator());
		return populators;
	}
}
