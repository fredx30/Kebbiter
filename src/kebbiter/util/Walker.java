package kebbiter.util;

import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.Tile;

public class Walker {
	
	private static Tile getNext(final Tile[] tiles) {
		for (int i = tiles.length - 1; i >= 0; --i) {
			if (Calculations.distance(Players.getLocal().getLocation(),
					tiles[i]) < 15) {
				return tiles[i];
			}
		}
		return null;
	}

	private static Tile getStart(final Tile[] tiles) {
		return tiles[0];
	}

	private static Tile getClosestTileOnMap(final Tile tile) {
		if (Game.isLoggedIn()) {
			final Tile loc = Players.getLocal().getLocation();
			final Tile walk = new Tile((loc.getX() + tile.getX()) / 2,
					(loc.getY() + tile.getY()) / 2, Game.getPlane());
			return Calculations.distance(loc, walk) < 15 ? walk
					: getClosestTileOnMap(walk);
		}
		return tile;
	}

	private static boolean walkTile(final Tile tile)
	// changed to public for Walk class
	{
		if ((Walking.getDestination() == null || (Calculations.distance(Players
				.getLocal().getLocation(), Walking.getDestination()) < 6 && Calculations
				.distance(tile, Walking.getDestination()) > 3))) {
			Sleeper.sleepTwo(500);
			if (tile.isOnScreen()) {
				return tile.click(true);
			} else if (Calculations.distance(Players.getLocal().getLocation(),
					tile) < 15) {
				tile.clickOnMap();
			} else {
				return walkTile(getClosestTileOnMap(tile));
			}
		}
		return false;
	}

	public static boolean walkPath(final Tile[] path) {
		boolean a = false;
		final Tile next = getNext(path);
		final Tile start = getStart(path);
		final Tile dest = Walking.getDestination();
		final Tile myTile = Players.getLocal().getLocation();

		if (next == null || myTile == null) {
			return a;
		}

		if ((dest == null || Calculations.distance(myTile, dest) < 6 || Calculations
				.distance(next, dest) > 3)) {
			if (!Walking.walk(next)) {
				if (Walking.walk(start)) {

					Sleeper.sleepTwo(500);
					a = true;
				} else {
					walkTile(getClosestTileOnMap(next));
					Sleeper.sleepTwo(500);
				}
			} else {
				Sleeper.sleepTwo(500);
				a = true;
			}
		}
		return a;
	}
}