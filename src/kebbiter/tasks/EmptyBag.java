package kebbiter.tasks;

import kebbiter.util.Sleeper;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.node.Item;

class EmptyBag{

    public static void execute() {

        if(!validate())
            return;

		for (Item i : Inventory.getItems()) {
			if (i.getId() == 526) {
				i.getWidgetChild().click(true);
				Sleeper.sleepTwo(Random.nextInt(850, 1000));

			}
		}
		for (Item i : Inventory.getItems()) {
			if (i.getId() == 9986 || i.getId() == 685) {
				i.getWidgetChild().interact("Drop");
				Sleeper.sleepTwo(Random.nextInt(850, 1550));
			}
		}

	}

	private static boolean validate() {

		if (Tabs.getCurrent() != Tabs.INVENTORY) {
			Widgets.get(746).getChild(78).click(true);
		}
		int total = Inventory.getCount(526) + Inventory.getCount(9986)
				+ Inventory.getCount(685);


		return (total > 0);
	}

    public static boolean bagIsFull() {
        return (Inventory.getCount() >= 26);
    }

}