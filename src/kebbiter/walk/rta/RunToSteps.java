package kebbiter.walk.rta;

import kebbiter.resources.WalkingPaths;
import kebbiter.util.ITile;
import kebbiter.util.Util;
import kebbiter.util.Walker;

import org.powerbot.game.api.methods.interactive.Players;

import Structure.Job;
import Structure.Task;

public class RunToSteps extends Task {

    private ITile[] walkPath = WalkingPaths.walk_from_ring_to_arena();

	public RunToSteps(String exePath, Job parent) {
		super(exePath, parent);
	}

	@Override
	public void execute() {
		Walker.walkPath(walkPath);
	}

	@Override
	public boolean validate() {
        return true;
	}

	@Override
	public void reset() {
        walkPath = WalkingPaths.walk_from_ring_to_arena();
	}

	@Override
	public boolean completed() {
        // if player is within 5 blocks of end location proceed
		return (Util.getDistanceBetween((Players.getLocal().getLocation()),
                walkPath[walkPath.length -1]) < 5);
	}

}
