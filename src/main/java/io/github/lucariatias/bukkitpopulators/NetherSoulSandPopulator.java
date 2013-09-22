package io.github.lucariatias.bukkitpopulators;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

public class NetherSoulSandPopulator extends BlockPopulator {
	
	public void populate(World world, Random rand, Chunk chunk){
		int chunkX = chunk.getX();
		int chunkZ = chunk.getZ();
		
		SimplexOctaveGenerator soulSandNoise = new SimplexOctaveGenerator(world, 8);
		soulSandNoise.setScale(1 / 32.0);
		
		for (int x = 0; x < 16; ++x){
			for (int z = 0; z < 16; ++z){
				int blockX = x + chunkX * 16;
				int blockZ = z + chunkZ * 16;
				
				if (soulSandNoise.noise(blockX, blockZ, 0.5, 0.5) > 0.25D){
					for (int y = 128; y > 0; --y){
						Block block = world.getBlockAt(blockX, y, blockZ);
						
						if (block.getType() == Material.NETHERRACK && block.getRelative(BlockFace.UP).getType() == Material.AIR){
							block.setType(Material.SOUL_SAND);
						}
					}
				}
			}
		}
	}
	
}
