package kebbiter.tasks;


import java.util.ArrayList;

import kebbiter.util.ITile;

class CurrentHunt {

	public static int nORs = -1;
	public static int step = 0;
	public static int oldSetting = -1;
	public static boolean last = false;
	public static ArrayList<ITile> toSearch = new ArrayList<ITile>();

	public static void ini() {
        nORs = -1;
        step = 0;
        oldSetting = -1;
        last = false;
        toSearch = new ArrayList<ITile>();
		//Msg.rep("Tracking new kebbit...");
	}
}
