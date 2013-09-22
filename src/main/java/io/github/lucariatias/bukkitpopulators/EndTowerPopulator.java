package io.github.lucariatias.bukkitpopulators;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.EnderDragon;
import org.bukkit.generator.BlockPopulator;

public class EndTowerPopulator extends BlockPopulator {
	
	public void populate(World world, Random random, Chunk chunk){
		if (random.nextInt(100) < 10){
			int x = random.nextInt(8) + 4;
			int z = random.nextInt(8) + 4;
			int y = world.getHighestBlockYAt(chunk.getX() * 16 + x, chunk.getZ() * 16 + z) - 4;
			int height = random.nextInt(30) + 20;
			
			if (y < 80){
				height += 80 - y;
			}
			
			if (chunk.getBlock(x, y, z).getType() == Material.ENDER_STONE){
				for (int i = 0; i < height; ++i){
					chunk.getBlock(x, y + i, z).setType(Material.OBSIDIAN);
					
					chunk.getBlock(x + 1, y + i, z).setType(Material.OBSIDIAN);
					chunk.getBlock(x - 1, y + i, z).setType(Material.OBSIDIAN);
					
					chunk.getBlock(x, y + i, z + 1).setType(Material.OBSIDIAN);
					chunk.getBlock(x, y + i, z - 1).setType(Material.OBSIDIAN);
					
					chunk.getBlock(x + 1, y + i, z - 1).setType(Material.OBSIDIAN);
					chunk.getBlock(x - 1, y + i, z - 1).setType(Material.OBSIDIAN);
					chunk.getBlock(x + 1, y + i, z + 1).setType(Material.OBSIDIAN);
					chunk.getBlock(x - 1, y + i, z + 1).setType(Material.OBSIDIAN);
					
					chunk.getBlock(x + 2, y + i, z).setType(Material.OBSIDIAN);
					chunk.getBlock(x - 2, y + i, z).setType(Material.OBSIDIAN);
					
					chunk.getBlock(x, y + i, z + 2).setType(Material.OBSIDIAN);
					chunk.getBlock(x, y + i, z - 2).setType(Material.OBSIDIAN);
					
					chunk.getBlock(x + 1, y + i, z - 2).setType(Material.OBSIDIAN);
					chunk.getBlock(x - 1, y + i, z - 2).setType(Material.OBSIDIAN);
					chunk.getBlock(x + 1, y + i, z + 2).setType(Material.OBSIDIAN);
					chunk.getBlock(x - 1, y + i, z + 2).setType(Material.OBSIDIAN);
					
					chunk.getBlock(x - 2, y + i, z + 1).setType(Material.OBSIDIAN);
					chunk.getBlock(x - 2, y + i, z - 1).setType(Material.OBSIDIAN);
					chunk.getBlock(x + 2, y + i, z + 1).setType(Material.OBSIDIAN);
					chunk.getBlock(x + 2, y + i, z - 1).setType(Material.OBSIDIAN);
				}
				
				chunk.getBlock(x, y + height, z).setType(Material.BEDROCK);
				chunk.getBlock(x, y + height + 1, z).setType(Material.FIRE);
				world.spawn(chunk.getBlock(x, y + height, z).getLocation().add(0.5, 0, 0.5), EnderCrystal.class);
				
				if (random.nextInt(100) < 10){
					world.spawn(chunk.getBlock(x, y + height + 10, z).getLocation(), EnderDragon.class);
				}
			}
		}
	}
	
}