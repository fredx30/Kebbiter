package kebbiter.tasks;

import org.powerbot.game.api.methods.interactive.Players;

import kebbiter.util.ITile;
import kebbiter.util.Util;
import kebbiter.walk.rta.AscendStepsToArena;
import kebbiter.walk.rta.RunToRing;
import kebbiter.walk.rta.RunToSteps;
import kebbiter.walk.rta.UseRing;
import Structure.Job;
import Structure.StepOffice;


public class WalkToArena extends Job {

	private final ITile endLocation = new ITile(2716, 3807, 1);

	public WalkToArena(String exePath, StepOffice parent) {
		super(exePath, parent);

		new RunToRing(exePath, this);
		new UseRing(exePath, this);
        new RunToSteps(exePath, this);
        new AscendStepsToArena(exePath, this);


	}

	@Override
	public boolean validate() {
        return true;
	}

	@Override
	public boolean completed() {
        // it is safe to use a large area because it is ona different plane
        return (Util.getDistanceBetween(Players.getLocal().getLocation(),
                endLocation) < 50);
	}
}
