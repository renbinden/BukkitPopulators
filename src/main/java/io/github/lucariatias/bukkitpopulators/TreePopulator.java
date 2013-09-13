package io.github.lucariatias.bukkitpopulators;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class TreePopulator extends BlockPopulator {
	
	private TreeType treeType;
	private int treesPerChunk;
	
	public TreePopulator(TreeType treeType, int treesPerChunk) {
		this.treeType = treeType;
		this.treesPerChunk = treesPerChunk;
	}

	@Override
	public void populate(World world, Random random, Chunk chunk) {
		int worldChunkX = chunk.getX();
		int worldChunkZ = chunk.getZ();
		for (int i = 0; i < treesPerChunk; i++) {
			world.generateTree(world.getHighestBlockAt(worldChunkX + random.nextInt(16), worldChunkZ + random.nextInt(16)).getLocation(), treeType);
		}
	}

}
