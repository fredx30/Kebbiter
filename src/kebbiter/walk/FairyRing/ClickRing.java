package kebbiter.walk.FairyRing;

import kebbiter.util.ITile;
import Structure.Action;
import Structure.Task;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

public class ClickRing extends Action {

	private final ITile ringPosition;
	private long lastClick;
	
	
	public ClickRing(String exePath, Task parent, ITile ringPosition) {
		super(exePath, parent);
		
		this.ringPosition = ringPosition;
		
	}
	
	public boolean validate()
	{
		if(System.currentTimeMillis() - lastClick > 2000  && !Widgets.get(734).getChild(0).validate())
		{
			lastClick = System.currentTimeMillis();
			return true;
		}
        if(completed())
            parent.nextStep();
		return false;
	}

    @Override
    public void reset() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected boolean completed()
	{
		WidgetChild[] p = Widgets.get(734).getChildren();
		return (p.length != 0 && p[0] != null && p[0].validate()) || Players.getLocal().getLocation().equals(new Tile(2412, 4434, 0));
	}
	
	public void execute()
	{
		ringPosition.click(true);
	}

}
