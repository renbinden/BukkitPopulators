package io.github.lucariatias.bukkitpopulators;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
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
		getLogger().info("Loaded BukkitPopulators");
	}

	public static List<BlockPopulator> getDefaultPopulators(World world){
		ArrayList<BlockPopulator> populators = new ArrayList<BlockPopulator>();

		switch (world.getEnvironment()){
		case NORMAL:
			populators.add(new BiomePopulator());
			populators.add(new SnowPopulator());
			break;

		case THE_END:
			populators.add(new EndTowerPopulator(world));
			break;

		case NETHER:
			populators.add(new NetherSoulSandPopulator(world));
			populators.add(new NetherFirePopulator(world));
			populators.add(new NetherGlowstonePopulator(world));
			break;
		}

		return populators;
	}

	public static List<BlockPopulator> getAllPopulators(World world) {
		ArrayList<BlockPopulator> populators = new ArrayList<BlockPopulator>();

		populators.add(new BiomePopulator());
		populators.add(new SnowPopulator());
		populators.add(new EndTowerPopulator(world));
		populators.add(new NetherSoulSandPopulator(world));
		populators.add(new NetherFirePopulator(world));
		populators.add(new NetherGlowstonePopulator(world));

		return populators;
	}
}
