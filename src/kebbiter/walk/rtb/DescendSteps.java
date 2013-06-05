package kebbiter.walk.rtb;

import kebbiter.util.ITile;
import kebbiter.util.Msg;
import kebbiter.util.Sleeper;
import kebbiter.util.Util;

import org.powerbot.game.api.methods.interactive.Players;

import Structure.Job;
import Structure.Task;

public class DescendSteps extends Task {

	private final ITile stepLocation = new ITile(2716, 3801, 1);
	private final ITile endLocation = new ITile(2716, 3798, 0);

	public DescendSteps(String exePath, Job parent) {
		super(exePath, parent);
	}

	@Override
	public void execute() {
        if(Util.getDistanceBetween(Players.getLocal().getLocation(), stepLocation) > 5) {
            stepLocation.clickOnMap();
        } else {
            stepLocation.interact("Descend");
        }
		Sleeper.sleepN(200, 400);
        Msg.msg("descSteps");
	}

	@Override
	public boolean validate() {
		return true;
	}

	@Override
	public boolean completed() {
        return ((Util.getDistanceBetween(Players.getLocal().getLocation(),
                endLocation) < 3));

	}

}
