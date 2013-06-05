package extraBots;

import org.powerbot.core.event.events.MessageEvent;
import org.powerbot.core.event.listeners.MessageListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.interactive.Players;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fredrik
 */
@Manifest(authors = { "DarkkShadow0 & Fredx30" }, name = "PathRecorder", description = "Used to record kebbit paths, dev-use-only" )
class PathRecorder extends ActiveScript implements  MessageListener{

    private String[] allTiles;
    private int tileLoc;
    private boolean firstRun = true;
    
    @Override
    public int loop() {
        if(firstRun)
        {
            setup();
            firstRun = false;
        }
        
        tileLoc ++;
        return 1;
    }
    
    private void setup() {
        allTiles = new String[1000];
        
    }
    
    @Override
    public void messageReceived(MessageEvent me) {
        System.out.println(me.getSender() + ", " + me.getMessage());
        if (me.getSender().equals(Players.getLocal().getName())) {
            if (me.getMessage().equals(".")){
                System.out.println("new Tile ("+Players.getLocal().getLocation().getX() + "" + ","
                        + Players.getLocal().getLocation().getY() + "" + ","
                        + Players.getLocal().getLocation().getPlane() + ",");
                allTiles[tileLoc] = "new Tile ("+Players.getLocal().getLocation().getX() + "" + ","
                        + Players.getLocal().getLocation().getY() + "" + ","
                        + Players.getLocal().getLocation().getPlane() + ",";
                tileLoc++;
            }
            
            if (me.getMessage().equals("P")){
                System.out.println("printing");
                for (String allTile : allTiles) {
                    System.out.print(allTile);
                }
                System.out.println();
            }
            if (me.getMessage().equals("clear")){
                System.out.println("clearing");
                allTiles = new String[1000];
            }
        }
    }
    
    


}
