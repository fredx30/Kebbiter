package kebbiter.tasks;

import org.powerbot.game.api.methods.interactive.Players;

import kebbiter.util.ITile;
import kebbiter.util.Util;
import kebbiter.walk.rtb.ArenaToRing;
import kebbiter.walk.rtb.DescendSteps;
import kebbiter.walk.rtb.GoToBank;
import kebbiter.walk.rtb.UseRing;
import Structure.Job;
import Structure.StepOffice;

public class WalkToBank extends Job {

	private final ITile endLocation = new ITile(2382, 4458, 0);

	public WalkToBank(String exePath, StepOffice parent) {
		super(exePath, parent);

		new DescendSteps(exePath, this);
		new ArenaToRing(exePath, this);
		new UseRing(exePath, this);
		new GoToBank(exePath, this);

	}

	@Override
	public boolean validate() {
		return true;
	}

	@Override
	public boolean completed() {
		return (Util.getDistanceBetween(Players.getLocal().getLocation(),
                endLocation) < 15);
	}
}
