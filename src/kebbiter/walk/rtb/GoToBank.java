package kebbiter.walk.rtb;

import kebbiter.resources.WalkingPaths;
import kebbiter.util.*;

import org.powerbot.game.api.methods.interactive.Players;

import Structure.Job;
import Structure.Task;

public class GoToBank extends Task {

    private ITile[] walkPath = WalkingPaths.walk_from_ring_to_bank();

	public GoToBank(String exePath, Job parent) {
		super(exePath, parent);
	}

	@Override
	public boolean validate() {
		return true;
	}

	@Override
	public void reset() {
        walkPath = WalkingPaths.walk_from_ring_to_bank();
	}

	public void execute() {
		Walker.walkPath(walkPath);
    }

	public boolean completed() {
		return (Util.getDistanceBetween(
                Players.getLocal().getLocation(),
                walkPath[walkPath.length -1]) < 5);
	}
}
