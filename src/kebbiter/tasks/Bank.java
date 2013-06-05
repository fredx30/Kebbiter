package kebbiter.tasks;

import kebbiter.util.ITile;
import kebbiter.util.Msg;
import kebbiter.util.Sleeper;
import Structure.Job;
import Structure.StepOffice;

import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.node.Item;

public class Bank extends Job {

	private static final int KEBBIT_FUR_ID = 10117;
	private final ITile[] BANKING_LOCATIONS = {new ITile(2380,4457,0),new ITile(2380,4456,0),new ITile(2380,4458,0)};

    public Bank(String exePath, StepOffice parent) {
		super(exePath, parent);
	}

	public void execute() {

		BANKING_LOCATIONS[Random.nextInt(0, 2)].interact("Bank");
		for (Item i : Inventory.getItems()) {
			if (i.getId() == 10117) {
				i.getWidgetChild().interact("Deposit-All");
				Sleeper.sleepTwo(Random.nextInt(484, 608));
				return;
			}

		}
	}

	public boolean validate() {
		if (Inventory.getCount(10117) <= 0) {
			Msg.rep("Skipping bank -> No furs in bag");
			parent.nextStep();
			return false;
		}
		Msg.rep("Banking...");
		return true;
	}

    @Override
    public boolean completed() {
        if(Inventory.getCount(KEBBIT_FUR_ID) == 0){
        	org.powerbot.game.api.methods.widget.Bank.close();
        	return true;
        }
        return false;
    }

}