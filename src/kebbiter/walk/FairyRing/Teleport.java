package kebbiter.walk.FairyRing;

import kebbiter.util.ITile;
import kebbiter.util.Sleeper;
import kebbiter.util.Util;
import Structure.Action;
import Structure.Task;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

public class Teleport extends Action {

	private static final ITile MAIN_RING = new ITile(2412, 4434, 0);

	public Teleport(String exePath, Task parent) {
		super(exePath, parent);
	}

	@Override
	public boolean validate() {
        if(completed())
            parent.nextStep();
		return Widgets.get(734).getChild(0).validate();
	}

	@Override
	public void reset() {

	}

	@Override
    protected boolean completed() {
		return Util.getDistanceBetween(Players.getLocal().getLocation(),
				MAIN_RING) > 2;
	}

	public void execute() {
		WidgetChild tpButton = Widgets.get(734).getChild(21);
		tpButton.click(true);
		Sleeper.sleepTwo(5000);
	}

}
