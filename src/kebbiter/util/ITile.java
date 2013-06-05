package kebbiter.util;

import org.powerbot.game.api.wrappers.Tile;

/**
 * 
 * @author Tomek
 */

public class ITile extends Tile {

	public ITile(int x, int y, int p) {
		super(x, y, p);
	}

	@Override
	public boolean click(boolean left) {
		return click();
	}

    public boolean click() {
        this.hover();
        return Util.semiAccurateClick(this.getBounds());
    }
}
