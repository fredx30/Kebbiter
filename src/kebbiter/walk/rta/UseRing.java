package kebbiter.walk.rta;

import kebbiter.util.ITile;
import kebbiter.walk.FairyRing.ClickRing;
import kebbiter.walk.FairyRing.SetTp;
import kebbiter.walk.FairyRing.Teleport;

import org.powerbot.game.api.methods.interactive.Players;


import Structure.Job;
import Structure.Task;

public class UseRing extends Task {
	
	private final ITile endLocation = new ITile(2744, 3719, 0);

	public UseRing(String exePath, Job parent) {
		super(exePath, parent);

		new ClickRing(exePath, this, new ITile(2412, 4434, 0));
		new SetTp(exePath, this, new int[] { 1, 2, 1 });
		new Teleport(exePath, this);
	}

	public boolean completed() {
		return Players.getLocal().getLocation()
				.equals(endLocation);
	}

	@Override
	public boolean validate() {
		return true;
	}

}
