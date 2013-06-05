package kebbiter.tasks;

import kebbiter.util.ITile;
import kebbiter.util.PaintWindow;
import kebbiter.util.Util;
import Structure.StepOffice;
import org.powerbot.core.event.events.MessageEvent;
import org.powerbot.core.event.listeners.MessageListener;
import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Random;

import java.awt.*;


@Manifest(authors = { "Darkk & Fredx30" }, name = "Kebbiter", version = 2.0, description = "Hunts kebbits at polar hunting arena")
class Kebbiter extends ActiveScript implements MessageListener, PaintListener {
	
	private static final ITile KEBBIT_ARENA = new ITile(2716, 3807, 1);

	private boolean firstRun = true;

	private StepOffice tasks;
	private PaintWindow paintWindow;

	private void startup() {
        //Initialize gui
		paintWindow = new PaintWindow();
		paintWindow.repaint();
        //Prep camera
		Camera.setPitch(95);
        //Initialize main running component
		tasks = new StepOffice();
		//Checks if within 100 blocks of kebbiting area
		//again safe to use large area it is on a different plane
		if (Util.getDistanceBetween(Players.getLocal().getLocation(),
				KEBBIT_ARENA) < 100){
			new Hunt("", tasks);
			new WalkToBank("", tasks);
			new Bank("", tasks);
			new WalkToArena("", tasks);
		}else{
			new WalkToArena("", tasks);
			new Hunt("", tasks);
			new WalkToBank("", tasks);
			new Bank("", tasks);
        }
        //Turn all chats to off
        ChatManager chatManager = new ChatManager();
		chatManager.run();
	}

	@Override
	public int loop() {
		//On first run initialize code
        if (firstRun) {
			startup();
			firstRun = false;
		}
        //Use Structure to execute the right code
		tasks.run();
		return Random.nextInt(10, 50);
	}

	@Override
    public void messageReceived(MessageEvent arg0) {
        if (!arg0.getSender().equals("")) //If the sender is not the server, return
            return;
        Hunt.lastMessage = arg0.getMessage(); //Store the message for use in Hunt

        if (arg0.getMessage().contains("manage to noose a")) //Increment kebbits caught counter
            PaintWindow.kebbitsBagged++;

        if (arg0.getMessage().contains("tracks")                   //Check for flags in messages
                || arg0.getMessage().contains("fur caught")) {
            Hunt.msged = true;
        }

        if (arg0.getMessage().contains(                            //Check for flags in messages
                "Nothing seems to be out of place here.")
                || arg0.getMessage().contains("doesn't appear")
                || arg0.getMessage().contains("boot")
                || arg0.getMessage().contains("poke around")
                || arg0.getMessage().contains("non-existent")) {
            Hunt.msged = true;
        }
    }

    @Override
    public void onRepaint(Graphics g) {
        //Paint the mouse in rsbot window
        g.setColor(Color.RED);

        Point p = Mouse.getLocation();

        if (p != null) {
            g.drawLine((int) p.getX() - 5, (int) p.getY(),
                    (int) p.getX() + 5, (int) p.getY());
            g.drawLine((int) p.getX(), (int) p.getY() - 5, (int) p.getX(),
                    (int) p.getY() + 5);
        }
        if(paintWindow != null)
            paintWindow.repaint();    //Repaint gui
    }
}