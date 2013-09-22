package io.github.lucariatias.bukkitpopulators;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.generator.BlockPopulator;

public class NetherFirePopulator extends BlockPopulator {
	
	private double getDistanceSquared(double x, double z){
		return (x * x) + (z * z); 
	}
	
	private void ignite(Block block, Random random){
		if (block.getType() == Material.AIR && block.getRelative(BlockFace.DOWN).getType() == Material.NETHERRACK && random.nextInt(100) < 25){
			block.setType(Material.FIRE);
		}
	}
	
	public void populate(World world, Random random, Chunk chunk){
		if (random.nextInt(100) < 25){
			Integer x = 5 + random.nextInt(6);
			Integer z = 5 + random.nextInt(6);
			
			int radius = (int) Math.ceil(6D + 0.5);
			int radiusSq = radius * radius;
			
			for (int sx = 0; sx < radius; ++sx){
				for (int sz = 0; sz < radius; ++sz){
					if (this.getDistanceSquared(sx, sz) < radiusSq){
						for (int y = 100; y > 30; --y){
							this.ignite(chunk.getBlock(x + sx, y, z + sz), random);
							this.ignite(chunk.getBlock(x + sx, y, z - sz), random);
							this.ignite(chunk.getBlock(x - sx, y, z + sz), random);
							this.ignite(chunk.getBlock(x - sx, y, z - sz), random);
						}
					}
				}
			}
		}
	}
	
}
