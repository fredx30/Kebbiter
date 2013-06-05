package kebbiter.walk.FairyRing;

import kebbiter.util.Sleeper;
import kebbiter.util.Util;
import Structure.Action;
import Structure.Task;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

public class SetTp extends Action {

	private final int[] numOfClicks;
	
	public SetTp(String exePath, Task parent, int[] numOfClicks) {
		super(exePath, parent);
		this.numOfClicks = numOfClicks;
	}


    @Override
    public boolean validate() {
    	//when tp window == open
    	return Widgets.get(734).getChild(0).validate();
    }

    @Override
    public void reset() {

    }

    @Override
    public boolean completed() {

    	Sleeper.sleepN(100, 200);
    	return true;
    }

    public void execute()
	{
		
		WidgetChild[] p = Widgets.get(734).getChildren();
        Util.clicker(p[23], numOfClicks[0]);
        Sleeper.sleepTwo(1000);
        Util.clicker(p[25], numOfClicks[1]);
        Sleeper.sleepTwo(1000);
        Util.clicker(p[27], numOfClicks[2]);
        Sleeper.sleepTwo(1000);
		
	}

}
