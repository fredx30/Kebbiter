package kebbiter.util;

import java.awt.Point;
import java.awt.Polygon;

import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

public abstract class Util {

	public static boolean semiAccurateClick(Polygon[] location) {
		if (location.length < 1 || location[0].xpoints.length < 1) {
			return false;
		}
		int x = getMidPoint(location[0].xpoints[0], location[0].xpoints[2]);
		int y = getMidPoint(location[0].ypoints[1], location[0].ypoints[3]);
		int precision = (int) (((0.02 * x) + (0.02 * y)) / 2);
		x = x + Random.nextInt(precision * -1, precision);
		y = y + Random.nextInt(precision * -1, precision);

		Mouse.move(x, y, 0, 0);

		return Mouse.click(true);
	}

	private static int getMidPoint(int x1, int x2) {
		int tmp = (x1 + x2) / 2;
		if (tmp < 0) {
			tmp = tmp * -1;
		}

		return tmp;
	}

	public static double getDistanceBetween(Tile tile1,Tile tile2){
		if(tile1.getPlane() != tile2.getPlane())
            return 1000000000;
        return Point.distance(tile1.getX(), tile1.getY(), tile2.getX(), tile2.getY());
	}

	public static void clicker(WidgetChild wc, int times) {
		for (int i = 0; i < times; i++) {
			wc.click(true);
			Sleeper.sleepTwo(200);
		}
	}


}
