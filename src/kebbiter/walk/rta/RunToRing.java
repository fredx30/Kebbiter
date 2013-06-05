package kebbiter.walk.rta;

import kebbiter.resources.WalkingPaths;
import kebbiter.util.ITile;
import kebbiter.util.Util;
import kebbiter.util.Walker;

import org.powerbot.game.api.methods.interactive.Players;

import Structure.Job;
import Structure.Task;

public class RunToRing extends Task {

    private ITile[] walkPath = WalkingPaths.walk_from_bank_to_ring();

	public RunToRing(String exePath, Job parent) {
		super(exePath, parent);
	}

	public void execute() {
		Walker.walkPath(walkPath);
	}

	@Override
	public boolean validate() {
		return true;
	}

	@Override
	public void reset() {
        walkPath = WalkingPaths.walk_from_bank_to_ring();
	}

	@Override
	public boolean completed() {
		return (Util.getDistanceBetween(Players.getLocal().getLocation(),
                walkPath[walkPath.length -1]) < 5);
	}

}
