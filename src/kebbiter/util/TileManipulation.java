package kebbiter.util;

import org.powerbot.game.api.util.Random;

public class TileManipulation {

	public static ITile[] randomize(ITile[] tile) {
		ITile[] out = new ITile[tile.length];
		for (int i = 0; i < tile.length; i++) {

			if (i == tile.length - 1) {
				out[i] = tile[i];
			} else {
				out[i] = new ITile(Random.nextInt(tile[i].getX() - 2,
						tile[i].getX() + 2), Random.nextInt(tile[i].getY() - 2,
						tile[i].getY() + 2), tile[i].getPlane());
			}

		}
		return out;
	}

	public static ITile[] randomizeBack(ITile[] tile) {
		ITile[] out = new ITile[tile.length];
		int p = -1;
		for (int i = tile.length - 1; i >= 0; i--) {

			if (i == 0) {
				p++;
				out[p] = tile[i];
			} else {
				p++;
				out[p] = new ITile(Random.nextInt(tile[i].getX() - 2,
						tile[i].getX() + 2), Random.nextInt(tile[i].getY() - 2,
						tile[i].getY() + 2), tile[i].getPlane());
			}

		}
		return out;
	}
}