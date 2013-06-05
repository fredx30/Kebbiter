package kebbiter.util;

import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.node.Menu;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Fredrik
 */
public class Click {
	public void rightClick(WidgetChild target, int optionNum) {
		int widX = unc(target,
				(target.getAbsoluteX() + (target.getWidth() / 2)));
		int widY = unc(target,
				(target.getAbsoluteY() + (target.getHeight() / 2)));
		Mouse.move(widX, widY);
		Sleeper.sleepN(500, 800);
		Mouse.click(false);
		Sleeper.sleepN(300, 500);
		Menu.clickIndex(optionNum);
	}

	public void rightClick(WidgetChild target, String option) {
		int widX = unc(target,
				(target.getAbsoluteX() + (target.getWidth() / 2)));
		int widY = unc(target,
				(target.getAbsoluteY() + (target.getHeight() / 2)));
		Mouse.move(widX, widY);
		Sleeper.sleepN(500, 800);
		Mouse.click(false);
		Sleeper.sleepN(300, 500);
		Menu.clickIndex(optionNumFromString(option));
	}

	private int optionNumFromString(String string) {
		String[] options = Menu.getItems();
		for (int i = 0; i < Menu.getActions().length;) {
			if (options[i].equals(string)) {
				return i;
			}
			i++;
		}
		return (options.length - 1);
	}

	private int unc(WidgetChild target, int i) {
		int multiplier = 0;
		if (target.getWidth() < target.getHeight()) {
			multiplier = target.getWidth();
		} else {
			multiplier = target.getHeight();
		}
		int precision = (int) (0.1 * multiplier); // 10% miss click
		i = i + Random.nextInt(precision * -1, precision);
		return i;
	}
}
