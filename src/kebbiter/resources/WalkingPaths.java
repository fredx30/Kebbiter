package kebbiter.resources;

import kebbiter.util.ITile;
import kebbiter.util.TileManipulation;

public class WalkingPaths {

    private static final ITile[] walk_from_arena_to_ring = { new ITile(2715, 3795, 0), new ITile(2714, 3789, 0),
            new ITile(2720, 3787, 0), new ITile(2721, 3779, 0),
            new ITile(2722, 3774, 0), new ITile(2726, 3770, 0),
            new ITile(2727, 3764, 0), new ITile(2726, 3759, 0),
            new ITile(2725, 3755, 0), new ITile(2726, 3750, 0),
            new ITile(2729, 3746, 0), new ITile(2730, 3741, 0),
            new ITile(2729, 3737, 0), new ITile(2726, 3731, 0),
            new ITile(2724, 3724, 0), new ITile(2729, 3721, 0),
            new ITile(2739, 3724, 0), new ITile(2744, 3721, 0) };

    private static final ITile[] walk_from_ring_to_bank = {new ITile(2412, 4435, 0), new ITile(2411, 4438, 0),
            new ITile(2409, 4443, 0), new ITile(2402, 4445, 0),
            new ITile(2393, 4447, 0), new ITile(2387, 4453, 0),
            new ITile(2382, 4458, 0) };

	public static ITile[] walk_from_ring_to_arena(){
		return TileManipulation.randomizeBack(walk_from_arena_to_ring);
	}
	public static ITile[] walk_from_arena_to_ring (){
		return TileManipulation.randomize(walk_from_arena_to_ring);
	}
    public static ITile[] walk_from_ring_to_bank(){
        return TileManipulation.randomize(walk_from_ring_to_bank);
    }
    public static ITile[] walk_from_bank_to_ring (){
        return TileManipulation.randomizeBack(walk_from_ring_to_bank);
    }
    /*
    private static ITile fix(ITile t) //is this still needed with new client version? Yup (Its a problem with Walking.walkpath(), not with client)
    {
        return new ITile(t.getX(), t.getY() + 1, t.getPlane());
    }
    */

	
}
