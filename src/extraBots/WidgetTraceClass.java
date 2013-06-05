package extraBots;

import org.powerbot.core.script.ActiveScript;
import org.powerbot.game.api.Manifest;


/**
 * @author Tomek
 */
@Manifest(authors = { "Darkk" }, name = "WidgetHelper", description = "Helps work out widgets, dec-use-only")
class WidgetTraceClass extends ActiveScript {

	private long lastMs;

	@Override
	public int loop() {
		if (System.currentTimeMillis() - lastMs > 10000) {
			// bounds();
			System.out.println("------------------------------");
			lastMs = System.currentTimeMillis();
		}
		return 5;
	}
}
