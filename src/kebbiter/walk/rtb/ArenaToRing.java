package kebbiter.walk.rtb;

import Structure.Job;
import Structure.Task;
import kebbiter.resources.WalkingPaths;
import kebbiter.util.ITile;
import kebbiter.util.Msg;
import kebbiter.util.Util;
import kebbiter.util.Walker;
import org.powerbot.game.api.methods.interactive.Players;

public class ArenaToRing extends Task {

	private ITile[] walkPath = WalkingPaths.walk_from_arena_to_ring();

	public ArenaToRing(String exePath, Job parent) {
		super(exePath, parent);
	}

	@Override
	public void execute() {
        Msg.msg("AtB");
		Walker.walkPath(walkPath);
	}

	@Override
	public boolean validate() {
		return true;
	}

	@Override
	public void reset() {
        walkPath = WalkingPaths.walk_from_arena_to_ring();
	}

	@Override
	public boolean completed() {
        return Util.getDistanceBetween((Players.getLocal().getLocation()),
                walkPath[walkPath.length - 1]) < 5;
    }

}
