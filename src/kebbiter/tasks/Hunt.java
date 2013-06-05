package kebbiter.tasks;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kebbiter.resources.KebbitPaths;
import kebbiter.util.ITile;
import kebbiter.util.Msg;
import kebbiter.util.Sleeper;

import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Settings;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.node.SceneObject;

import Structure.Job;
import Structure.StepOffice;

public class Hunt extends Job {

	private static final boolean TRY_USE_SO = false;

	private final ITile[] start = { new ITile(2711, 3830, 1),
			new ITile(2717, 3819, 1) }; // the two initial hunting mounds
	private int ticks = 0; // Used by internal system to ensure that the bot has
							// not frozen at various stages of execution.
	private boolean destIsEssential; // Used to control player movement
	private boolean jS; // Flag indicating that a search has just ocured
	static boolean msged; // Is set to true externally whenever a new message is
							// relieved from the server.
	static String lastMessage; // Contains the last Message relieved from the
								// server

	public Hunt(String exePath, StepOffice parent) {
		super(exePath, parent);
	}

	public void execute() {

		Antiban.execute();

		if (destIsEssential && Players.getLocal().isMoving()
		// If the player is moving, let him run
				|| Players.getLocal().getAnimation() != -1) {
			Sleeper.sleep(500);
			return;
		}

		if (ticks > 23) {
			// If the bot is stuck/frozen on something. Restart.
			jS = false;
			msged = false;
			ticks = 0;
		}
		if ((jS && !msged)) {
			Msg.msg("Returning; (" + lastMessage + ")");
			ticks++;
			return;
		} else if (jS) {
			ticks = 0;
			jS = false;
			msged = false;
		}

		if (!(CurrentHunt.oldSetting == Settings
				.get(KebbitPaths.KEBBIT_PATH_SETTING))
				&& !((CurrentHunt.step == 0))) {
			CurrentHunt.toSearch.clear();
		}
		if (CurrentHunt.toSearch.size() >= 1 && !(CurrentHunt.step == 0)) {
			CurrentHunt.step = 1;
		} else if (CurrentHunt.toSearch.isEmpty() && !(CurrentHunt.step == 0)) {
			CurrentHunt.step = 2;
		}
		if (CurrentHunt.step == 0
				&& Settings.get(KebbitPaths.KEBBIT_PATH_SETTING) != 0
				&& CurrentHunt.toSearch.size() > 0) {
			CurrentHunt.step = 1;
		} else if (CurrentHunt.step == 0
				&& Settings.get(KebbitPaths.KEBBIT_PATH_SETTING) != 0) {
			CurrentHunt.step = 2;
		}
		if (CurrentHunt.step != 0
				&& Settings.get(KebbitPaths.KEBBIT_PATH_SETTING) == 0) {
			CurrentHunt.step = 0;
		}
		CurrentHunt.oldSetting = Settings.get(KebbitPaths.KEBBIT_PATH_SETTING);

		if (CurrentHunt.step == 0) {
			startHunt();
			return;
		}

		if (CurrentHunt.toSearch.size() > 0) {
			search();
			return;
		}

		if (CurrentHunt.step == 2) {
			track();
		}
	}

	private void waitToLocation(Tile n) {
		long timePass = 0;
		while (true) {
			if (!Players.getLocal().getLocation().equals(n)) {
				while (Players.getLocal().isMoving()) {
					Sleeper.sleep(500);
				}
			}
			Sleeper.sleep(150);
			timePass += 100;

			if (timePass > 3000 && !Players.getLocal().isMoving()) {
				return;
			}
		}
	}

	private void waitToLocationNB(Tile n) {
		// Wait until the player gets somewhere
		long timePass = 0;
		while (true) {
			if (Players.getLocal().getLocation().equals(n)
					&& !Players.getLocal().isMoving())
				return;
			if (Calculations.distanceTo(Players.getLocal().getLocation()) <= 1) {
				while (Players.getLocal().isMoving()) {
					Sleeper.sleep(20);
				}
				if (destIsEssential) {
					Sleeper.sleep(100);

					while (Players.getLocal().getAnimation() != -1) {
						Sleeper.sleep(100);
					}
				}
				return;
			}
			Sleeper.sleep(150);
			timePass += 150;

			if (timePass > 1000 && !Players.getLocal().isMoving()) {
				return;
			}

		}
	}

	private void walkTo(ITile t) {
		ITile nt = getNearestFree(t);
		if (!nt.isOnScreen() || Calculations.distanceTo(t) > 5) {
			ITile n = new ITile(Random.nextInt(t.getX() - 2, t.getX() + 2),
					Random.nextInt(t.getY() - 2, t.getY() + 2), 1);
			n.clickOnMap();
			waitToLocation(n);
		}
		if (Calculations.distanceTo(t) > 5) {
			nt.click(true);
		}

	}

	private ITile getNearestFree(ITile t) {
		// Finds the nearest unoccupied (free to walk on) tile to the tile
		// provided
		ITile[] nearTiles = { new ITile(t.getX() + 1, t.getY(), 1),
				new ITile(t.getX() - 1, t.getY(), 1),
				new ITile(t.getX(), t.getY() + 1, 1),
				new ITile(t.getX(), t.getY() - 1, 1), };

		for (int i = 0; i < 4; i++) {
			try {
				if (t != null) {
					return nearTiles[i];

				}
			} catch (Exception ignored) {
			}

		}

		return t;

	}

	private void search() { // Goto and search a possible hiding spot
		ITile t;
		try {
			t = new ITile(CurrentHunt.toSearch.get(0).getX(), // Tile to be
																// searched
					CurrentHunt.toSearch.get(0).getY(), 1);

		} catch (Exception e) {
			CurrentHunt.toSearch.remove(0);
			return;
		}

		if (Calculations.distanceTo(t.getLocation()) > 5 || !t.isOnScreen()) {
			// If the tile is not on screen, walk to it
			walkTo(CurrentHunt.toSearch.get(0));
		}
		Msg.msg(t.getId() + "");
		if (CurrentHunt.last) {
			// If the kebbit is hiding there. Attack it.
			tryInteract(t, "Attack");
			destIsEssential = false;
			waitToLocationNB(t.getLocation());
			CurrentHunt.ini();
			Sleeper.sleep(Random.nextInt(3500, 4500));
			return;
		} else if ((t.getX() == 2718 && t.getY() == 3820)
		// If the kebbit might be hiding there attack it (looks more
		// non-bot-like)
				|| (t.getX() == 2712 && t.getY() == 3831)) {
			tryInteract(t, "Attack");
			destIsEssential = false;
			waitToLocationNB(t.getLocation());
		} else { // Search the place
			tryInteract(t, "Inspect");
			destIsEssential = true;
			waitToLocationNB(t.getLocation());
		}

		jS = true;
		CurrentHunt.toSearch.remove(0);
		Sleeper.sleep(Random.nextInt(3500, 4500));
	}

	private void tryInteract(ITile tile, String interact) {

		// Because SceneObjects in rsbot are so unreliable this code tries to
		// use them but reverts to tile in case of problem

		boolean doInteract = !interact.equals("");
		boolean soHasFailed = true;
		try {
			if (TRY_USE_SO) {
				SceneObject so = SceneEntities.getAt(tile.getX(), tile.getY());
				if (doInteract) {
					soHasFailed = !so.interact(interact);
				} else {
					soHasFailed = !so.click(true);
				}
			}
		} catch (Exception e) {
			soHasFailed = true;
		}

		if (soHasFailed) {
			if (doInteract) {
				tile.interact(interact);
			} else {
				tile.click(true);
			}
		}
	}

	private void track() {
		// Find the current path in the path DB
		switch (CurrentHunt.nORs) {
		// Is it south or north?
		case 0:
			process(KebbitPaths.NORTH_KEBBIT_DB);
			break;
		case 1:
			process(KebbitPaths.SOUTH_KEBBIT_DB);
			break;
		case -1: // If unknown, check the DB and find out.
			if (check(Settings.get(KebbitPaths.KEBBIT_PATH_SETTING))) {
				CurrentHunt.nORs = 0;
			} else {
				CurrentHunt.nORs = 1;
			}
			break;
		}

	}

	private boolean check(int p) {
		// Checks the DB to find out if north or south
		for (Map.Entry<Integer, ArrayList<Point>> e : KebbitPaths.NORTH_KEBBIT_DB
				.entrySet()) {
			int key = e.getKey();
			if (key == p) {
				return true;
			}
		}
		return false;

	}

	private void process(HashMap<Integer, ArrayList<Point>> h) {
		// Attempts to locate all valid search spots for a given setting
		Integer inte = Settings.get(KebbitPaths.KEBBIT_PATH_SETTING);
		ArrayList<Point> res = h.get(inte);
		if (res == null) {
			Msg.rep("[WARNING] Setting "
					+ Settings.get(KebbitPaths.KEBBIT_PATH_SETTING)
					+ " not found in the DB!");
			CurrentHunt.nORs = -1;
		} else {
			for (Point re : res) {
				CurrentHunt.toSearch.add(new ITile(re.x, re.y, 1));
			}
			CurrentHunt.step = 1;
			if (res.size() == 1) {
				CurrentHunt.last = true;
			}
		}
	}

	private void startHunt() {
		// Start new hunt. Go to one of the beginning spots.
		if (Calculations.distanceTo(start[1]) > Calculations
				.distanceTo(start[0])) {

			if (Calculations.distanceTo(start[0].getLocation()) > 5) {
				walkTo(start[0]);
			}
			tryInteract(start[0], "Inspect");
			waitToLocationNB(start[0].getLocation());
			CurrentHunt.nORs = 0;

		} else {
			if (Calculations.distanceTo(start[1].getLocation()) > 5) {
				walkTo(start[1]);
			}
			tryInteract(start[1], "Inspect");
			waitToLocationNB(start[1].getLocation());
			CurrentHunt.nORs = 1;
		}
		CurrentHunt.step = 2;
		Sleeper.sleep(Random.nextInt(1000, 1500));
	}

	public boolean validate() {
		return true;
	}

	@Override
	public void reset() {
		ticks = 0;
		destIsEssential = false;
		jS = false;
		msged = false;
		lastMessage = "";
		CurrentHunt.ini();
	}

	@Override
	public boolean completed() {
		EmptyBag.execute();
		return EmptyBag.bagIsFull();
	}

}