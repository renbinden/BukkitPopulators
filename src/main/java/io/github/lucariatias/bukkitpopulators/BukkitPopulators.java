package io.github.lucariatias.bukkitpopulators;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import uk.co.jacekk.bukkit.skylandsplus.generation.BiomePopulator;
import uk.co.jacekk.bukkit.skylandsplus.generation.EndTowerPopulator;
import uk.co.jacekk.bukkit.skylandsplus.generation.NetherFirePopulator;
import uk.co.jacekk.bukkit.skylandsplus.generation.NetherGlowstonePopulator;
import uk.co.jacekk.bukkit.skylandsplus.generation.NetherSoulSandPopulator;
import uk.co.jacekk.bukkit.skylandsplus.generation.SnowPopulator;

public class BukkitPopulators extends JavaPlugin {


	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		Plugin skylands = pm.getPlugin("SkylandsPlus");
		if(skylands != null) {
			getLogger().info("Loading populators from SkylandsPlus");
		}
	}

	/**
	 * Gets the "normal" populators for a particular world.
	 *
	 * This function works like the ChunkGenerator function, but is not
	 * called by bukkit directly.
	 * @param world
	 * @return
	 * @see ChunkGenerator#getDefaultPopulators(World)
	 */
	public List<BlockPopulator> getDefaultPopulators(World world){
		ArrayList<BlockPopulator> populators = new ArrayList<BlockPopulator>();

		PluginManager pm = getServer().getPluginManager();
		Plugin skylands = pm.getPlugin("SkylandsPlus");

		switch (world.getEnvironment()){
		case NORMAL:
			if(skylands != null) {
				populators.add(new BiomePopulator());
				populators.add(new SnowPopulator());
			}
			break;

		case THE_END:
			if(skylands != null) {
				populators.add(new EndTowerPopulator(world));
			}
			break;

		case NETHER:
			if(skylands != null) {
				populators.add(new NetherSoulSandPopulator(world));
				populators.add(new NetherFirePopulator(world));
				populators.add(new NetherGlowstonePopulator(world));
			}
			break;
		}

		return populators;
	}

	/**
	 * Get all populators available
	 *
	 * @param world
	 * @return
	 */
	public List<BlockPopulator> getAllPopulators(World world) {
		ArrayList<BlockPopulator> populators = new ArrayList<BlockPopulator>();

		PluginManager pm = getServer().getPluginManager();
		Plugin skylands = pm.getPlugin("SkylandsPlus");
		if(skylands != null) {
			populators.add(new BiomePopulator());
			populators.add(new SnowPopulator());
			populators.add(new EndTowerPopulator(world));
			populators.add(new NetherSoulSandPopulator(world));
			populators.add(new NetherFirePopulator(world));
			populators.add(new NetherGlowstonePopulator(world));
		}
		return populators;
	}
}
