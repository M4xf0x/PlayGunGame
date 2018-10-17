package src.de.m4twaily.tp;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.Skull;

public class SpinningSkull {

	public static void spinSkull(Location loc) {
		System.out.println("Start");
		Bukkit.getScheduler().scheduleSyncRepeatingTask(MainTs.main, new Runnable() {
			int i = 16;

			@Override
			public void run() {

				BlockState bs = loc.getBlock().getState();
				Skull s = (Skull) bs;

				System.out.println("Debug " + i);

				if (i == 1) {
					i = 16;
				}

				i--;

				switch (i) {
				case 1:
					s.setRotation(BlockFace.NORTH);
					break;
				case 2:
					s.setRotation(BlockFace.NORTH_NORTH_EAST);
					break;
				case 3:
					s.setRotation(BlockFace.NORTH_EAST);
					break;
				case 4:
					s.setRotation(BlockFace.EAST_NORTH_EAST);
					break;
				case 5:
					s.setRotation(BlockFace.EAST);
					break;
				case 6:
					s.setRotation(BlockFace.EAST_SOUTH_EAST);
					break;
				case 7:
					s.setRotation(BlockFace.SOUTH_EAST);
					break;
				case 8:
					s.setRotation(BlockFace.SOUTH_SOUTH_EAST);
					break;
				case 9:
					s.setRotation(BlockFace.SOUTH);
					break;
				case 10:
					s.setRotation(BlockFace.SOUTH_SOUTH_WEST);
					break;
				case 11:
					s.setRotation(BlockFace.SOUTH_WEST);
					break;
				case 12:
					s.setRotation(BlockFace.WEST_SOUTH_WEST);
					break;
				case 13:
					s.setRotation(BlockFace.WEST);
					break;
				case 14:
					s.setRotation(BlockFace.WEST_NORTH_WEST);
					break;
				case 15:
					s.setRotation(BlockFace.NORTH_WEST);
					break;
				case 16:
					s.setRotation(BlockFace.NORTH_NORTH_WEST);
					break;

				}

				bs.update(true, true);
			}

		}, 0, 2);

	}
}
