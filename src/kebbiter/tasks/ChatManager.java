package kebbiter.tasks;

import kebbiter.util.Click;
import kebbiter.util.Sleeper;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

/**
 * 
 * @author Fredrik
 */
class ChatManager {

	private final WidgetChild publicChat;
	private final WidgetChild privateChat;
	private final WidgetChild friendsChat;
	private final WidgetChild clanChat;

	private final WidgetChild tradeWidget;
	private final WidgetChild assistWidget;

	private final Click c;

    public boolean validate = true;

	public ChatManager() {
		c = new Click();

		publicChat = Widgets.get(751).getChild(8);
		privateChat = Widgets.get(751).getChild(9);
		friendsChat = Widgets.get(751).getChild(11);
		clanChat = Widgets.get(751).getChild(10);

		tradeWidget = Widgets.get(751).getChild(12);
		assistWidget = Widgets.get(751).getChild(13);
	}

	void chatOff() {
		if (Widgets.get(751).getChild(5).validate()) {
			Sleeper.sleepN(500, 800);

			if (!Widgets.get(751).getChild(31).getText().contains("Off")) {
				c.rightClick(publicChat, "Off Public");
			}
			Sleeper.sleepTwo(Random.nextInt(100, 200));
			if (!Widgets.get(751).getChild(28).getText().contains("Off")) {
				c.rightClick(privateChat, "Off Private");
			}
			Sleeper.sleepTwo(Random.nextInt(100, 200));
			if (!Widgets.get(751).getChild(2).getText().contains("Off")) {
				c.rightClick(friendsChat, "Off Friends Chat");
			}
			Sleeper.sleepTwo(Random.nextInt(100, 200));
			if (!Widgets.get(751).getChild(25).getText().contains("Off")) {
				c.rightClick(clanChat, "Off Clan");
			}
		}
	}

	void tradeOff() {
		if (tradeWidget.validate()) {
			Sleeper.sleepN(100, 200);
			if (!Widgets.get(751).getChild(22).getText().contains("Off")) {
				c.rightClick(tradeWidget, "Off Trade");
			}
		}

	}

	void assistOff() {
		if (assistWidget.validate()) {
			Sleeper.sleepN(100, 200);
			if (!Widgets.get(751).getChild(19).getText().contains("Off")) {
				c.rightClick(assistWidget, "Off Assist");
			}
		}
	}

	public void run() {
		chatOff();
		tradeOff();
		assistOff();
	}
}
