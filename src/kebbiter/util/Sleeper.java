package kebbiter.util;

import org.powerbot.game.api.util.Random;

/**
 * @author fredrik_dyrvold
 */
public class Sleeper {
	public static void sleepTwo(int time) {
		time = Random.nextInt(Math.abs(time - 100), time + 100);
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			Msg.rep("{Error} " + e.getMessage());
		}
	}

	public static void sleepN(int i, int ii) {
		int iii = Random.nextInt(i, ii);
		try {
			Thread.sleep(iii);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			Msg.rep("{Error} " + e.getMessage());
		}
	}
}
