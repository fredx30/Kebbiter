package kebbiter.walk.rtb;

import Structure.Job;
import Structure.Task;
import kebbiter.util.ITile;
import kebbiter.walk.FairyRing.ClickRing;
import org.powerbot.game.api.methods.interactive.Players;

public class UseRing extends Task {

	public UseRing(String exePath, Job parent) {
		super(exePath, parent);

		// cords have been corrected
		new ClickRing(exePath, this, new ITile(2744, 3719, 0));

	}

	@Override
	public boolean validate() {
		return true;
	}

	public boolean completed() {
		return Players.getLocal().getLocation()
				.equals(new ITile(2412, 4434, 0));
	}

}
