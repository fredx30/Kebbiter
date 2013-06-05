package kebbiter.tasks;

import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.interactive.NPC;


/**
 * @author Tomek
 */
class Antiban {

	public static void execute() {

		switch (Random.nextInt(0, 30)) {
		case 0:
			Mouse.move(
					Random.nextInt(Mouse.getLocation().x - 100,
							Mouse.getLocation().x + 100),
							Random.nextInt(Mouse.getLocation().y - 100,
									Mouse.getLocation().y + 100));
			break;
		case 1:
			Camera.setAngle(Random.nextInt(-180, 180));
			break;

		case 2:
		{
			NPC[] ranNpc = NPCs.getLoaded();
			try{
				ranNpc[Random.nextInt(0, ranNpc.length-1)].hover();
			}catch(Exception e){
				//we don't care ;)
			}
			break;
		}
		case 3:
		{
			if(Random.nextInt(0, 10)==10){
				//run 1 in 10 times
				NPC[] ranNpc = NPCs.getLoaded();
				try{
					ranNpc[Random.nextInt(0, ranNpc.length-1)].interact("Examine");
				}catch(Exception e){
					//we don't care ;)
				}
			}
			break;
		}
		}


	}
}
