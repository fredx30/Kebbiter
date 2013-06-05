package kebbiter.walk.rta;

import kebbiter.util.ITile;
import kebbiter.util.Sleeper;
import kebbiter.util.Util;

import org.powerbot.game.api.methods.interactive.Players;

import Structure.Job;
import Structure.Task;

public class AscendStepsToArena extends Task {

	private final ITile stepLocation = new ITile(2716, 3799, 0);
	private final ITile endLocation = new ITile(2716, 3802, 1);

	public AscendStepsToArena(String exePath, Job parent) {
		super(exePath, parent);
	}

	@Override
	public void execute() {
		stepLocation.click();
		Sleeper.sleepN(200, 400);
	}

	@Override
	public boolean validate() {
		return true;
	}

	@Override
	public boolean completed() {
        // if player is at top of stairs in kebbit hunting place
        return (Util.getDistanceBetween(Players.getLocal().getLocation(),
                endLocation) < 3);
	}

}
