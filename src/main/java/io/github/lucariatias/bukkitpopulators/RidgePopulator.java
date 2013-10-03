package io.github.lucariatias.bukkitpopulators;

import java.util.Arrays;
import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.generator.BlockPopulator;

public class RidgePopulator extends BlockPopulator {
	
	private Material landMaterial;
	private Material tempMaterial;
	private int ridgeWidth;
	
	public RidgePopulator(Material landMaterial, int ridgeWidth) {
		this(landMaterial, Material.BEDROCK, ridgeWidth);
	}
	
	public RidgePopulator(Material landMaterial, Material tempMaterial, int ridgeWidth) {
		this.landMaterial = landMaterial;
		this.tempMaterial = tempMaterial;
		this.ridgeWidth = ridgeWidth;
	}

	@Override
	public void populate(World world, Random random, Chunk source) {
		int worldChunkX = source.getX() * 16;
		int worldChunkZ = source.getZ() * 16;
		byte[] heights = new byte[256];
		int x = worldChunkX;
		int y = world.getMaxHeight();
		int z = worldChunkZ;
		int height = 0;
		int i = 0;
		for (x = worldChunkX; x < worldChunkX + 16; x++) {
			for (z = worldChunkZ; z < worldChunkZ + 16; z++) {
				y = world.getMaxHeight();
				height = 0;
				while (world.getBlockAt(x, y, z).getType() != Material.AIR && y > 0) {
					y--;
					height++;
				}
				heights[i] = (byte) height;
				i++;
			}
		}
		int medianHeight = getMedian(heights);
		addEdge(world, x, world.getMaxHeight() - medianHeight, z, worldChunkX, worldChunkZ, ridgeWidth);
	}
	
	private byte getMedian(byte[] heights) {
		Arrays.sort(heights);
		return heights[heights.length / 2];
	}
	
	private void addEdge(World world, int x, int y, int z, int worldChunkX, int worldChunkZ, int blocks) {
		for (x = worldChunkX; x < worldChunkX + 16; x++) {
			for (z = worldChunkZ; z < worldChunkZ + 16; z++) {
				if (world.getBlockAt(x, y, z).getType() == landMaterial
						|| world.getBlockAt(x, y, z).getRelative(BlockFace.NORTH).getType() == landMaterial
						|| world.getBlockAt(x, y, z).getRelative(BlockFace.SOUTH).getType() == landMaterial
						|| world.getBlockAt(x, y, z).getRelative(BlockFace.WEST).getType() == landMaterial
						|| world.getBlockAt(x, y, z).getRelative(BlockFace.EAST).getType() == landMaterial) {
					world.getBlockAt(x, y, z).setType(tempMaterial);
				}
			}
		}
		for (x = worldChunkX; x < worldChunkX + 16; x++) {
			for (z = worldChunkZ; z < worldChunkZ + 16; z++) {
				if (world.getBlockAt(x, y, z).getType() == tempMaterial) {
					world.getBlockAt(x, y, z).setType(landMaterial);
				}
			}
		}
		if (blocks > 0) {
			addEdge(world, x, y, z, worldChunkX, worldChunkZ, blocks - 1);
		}
	}

}
