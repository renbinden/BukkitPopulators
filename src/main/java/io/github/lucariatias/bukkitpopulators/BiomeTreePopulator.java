package io.github.lucariatias.bukkitpopulators;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class BiomeTreePopulator extends BlockPopulator {

	@Override
	public void populate(World world, Random random, Chunk chunk) {
		int worldChunkX = chunk.getX();
		int worldChunkZ = chunk.getZ();
		TreeType[] treeTypes = new TreeType[] {};
		int treesPerChunk = 0;
		switch (world.getBiome(worldChunkX, worldChunkZ)) {
			case EXTREME_HILLS:
				treeTypes = new TreeType[] {TreeType.TREE};
				treesPerChunk = 1;
				break;
			case FOREST: case FOREST_HILLS:
				treeTypes = new TreeType[] {TreeType.TREE, TreeType.BIRCH};
				treesPerChunk = 8;
				break;
			case FROZEN_OCEAN:
				treeTypes = new TreeType[] {TreeType.TREE};
				treesPerChunk = 1;
				break;
			case FROZEN_RIVER:
				treeTypes = new TreeType[] {TreeType.TREE};
				treesPerChunk = 1;
				break;
			case ICE_MOUNTAINS:
				treeTypes = new TreeType[] {TreeType.TREE};
				treesPerChunk = 2;
				break;
			case ICE_PLAINS:
				treeTypes = new TreeType[] {TreeType.TREE};
				treesPerChunk = 1;
				break;
			case JUNGLE: case JUNGLE_HILLS:
				treeTypes = new TreeType[] {TreeType.JUNGLE, TreeType.SMALL_JUNGLE, TreeType.JUNGLE_BUSH};
				treesPerChunk = 4;
				break;
			case MUSHROOM_ISLAND: case MUSHROOM_SHORE:
				treeTypes = new TreeType[] {TreeType.RED_MUSHROOM, TreeType.BROWN_MUSHROOM};
				treesPerChunk = 4;
				break;
			case RIVER:
				treeTypes = new TreeType[] {TreeType.TREE};
				treesPerChunk = 4;
				break;
			case SMALL_MOUNTAINS:
				treeTypes = new TreeType[] {TreeType.TREE};
				treesPerChunk = 1;
				break;
			case SWAMPLAND:
				treeTypes = new TreeType[] {TreeType.SWAMP};
				break;
			case TAIGA: case TAIGA_HILLS:
				treeTypes = new TreeType[] {TreeType.REDWOOD, TreeType.TALL_REDWOOD};
				break;
			default:
				break;
		}
		if (treeTypes.length > 0 && treesPerChunk != 0) {
			for (int i = 0; i < treesPerChunk; i++) {
				world.generateTree(world.getHighestBlockAt(worldChunkX + random.nextInt(16), worldChunkZ + random.nextInt(16)).getLocation(), treeTypes[random.nextInt(treeTypes.length)]);
			}
		}
	}

}
