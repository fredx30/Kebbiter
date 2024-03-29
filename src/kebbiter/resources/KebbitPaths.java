package kebbiter.resources;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Tomek
 */

public abstract class KebbitPaths {

    public static final int KEBBIT_PATH_SETTING = 1216;

	public static final HashMap<Integer, ArrayList<Point>> SOUTH_KEBBIT_DB = iniSouth(); //Creates the DB for all south kebbit paths
	public static final HashMap<Integer, ArrayList<Point>> NORTH_KEBBIT_DB = iniNorth(); //Creates the DB for all north kebbit paths

	private static HashMap<Integer, ArrayList<Point>> iniSouth() {
        HashMap<Integer, ArrayList<Point>> SOUTH_KEBBIT_DB = new HashMap<Integer, ArrayList<Point>>();
		ArrayList<Point> arr0 = new ArrayList<Point>();
		arr0.add(new Point(2718, 3820));
		SOUTH_KEBBIT_DB.put(1610612963, arr0);
		ArrayList<Point> arr1 = new ArrayList<Point>();
		arr1.add(new Point(2718, 3820));
		SOUTH_KEBBIT_DB.put(1611794624, arr1);
		ArrayList<Point> arr2 = new ArrayList<Point>();
		arr2.add(new Point(2712, 3815));
		arr2.add(new Point(2708, 3825));
		SOUTH_KEBBIT_DB.put(1073742106, arr2);
		ArrayList<Point> arr3 = new ArrayList<Point>();
		arr3.add(new Point(2718, 3820));
		SOUTH_KEBBIT_DB.put(1611499264, arr3);
		ArrayList<Point> arr4 = new ArrayList<Point>();
		arr4.add(new Point(2714, 3827));
		arr4.add(new Point(2714, 3821));
		SOUTH_KEBBIT_DB.put(1078986752, arr4);
		ArrayList<Point> arr5 = new ArrayList<Point>();
		arr5.add(new Point(2714, 3827));
		arr5.add(new Point(2718, 3829));
		SOUTH_KEBBIT_DB.put(1074102528, arr5);
		ArrayList<Point> arr6 = new ArrayList<Point>();
		arr6.add(new Point(2718, 3829));
		arr6.add(new Point(2721, 3827));
		SOUTH_KEBBIT_DB.put(1140863491, arr6);
		ArrayList<Point> arr7 = new ArrayList<Point>();
		arr7.add(new Point(2713, 3827));
		arr7.add(new Point(2708, 3827));
		SOUTH_KEBBIT_DB.put(1124083712, arr7);
		ArrayList<Point> arr8 = new ArrayList<Point>();
		arr8.add(new Point(2712, 3831));
		arr8.add(new Point(2713, 3827));
		arr8.add(new Point(2718, 3832));
		SOUTH_KEBBIT_DB.put(1107308547, arr8);
		ArrayList<Point> arr9 = new ArrayList<Point>();
		arr9.add(new Point(2712, 3831));
		arr9.add(new Point(2718, 3832));
		arr9.add(new Point(2713, 3827));
		SOUTH_KEBBIT_DB.put(1075851267, arr9);
		ArrayList<Point> arr10 = new ArrayList<Point>();
		arr10.add(new Point(2718, 3829));
		arr10.add(new Point(2714, 3827));
		SOUTH_KEBBIT_DB.put(1078034688, arr10);
		ArrayList<Point> arr11 = new ArrayList<Point>();
		arr11.add(new Point(2716, 3827));
		SOUTH_KEBBIT_DB.put(1348481027, arr11);
		ArrayList<Point> arr12 = new ArrayList<Point>();
		arr12.add(new Point(2712, 3831));
		SOUTH_KEBBIT_DB.put(1216446720, arr12);
		ArrayList<Point> arr13 = new ArrayList<Point>();
		arr13.add(new Point(2711, 3819));
		arr13.add(new Point(2708, 3825));
		SOUTH_KEBBIT_DB.put(19, arr13);
		ArrayList<Point> arr14 = new ArrayList<Point>();
		arr14.add(new Point(2708, 3819));
		SOUTH_KEBBIT_DB.put(1526745088, arr14);
		ArrayList<Point> arr15 = new ArrayList<Point>();
		arr15.add(new Point(2712, 3831));
		SOUTH_KEBBIT_DB.put(1259176192, arr15);
		ArrayList<Point> arr16 = new ArrayList<Point>();
		arr16.add(new Point(2718, 3829));
		arr16.add(new Point(2718, 3832));
		SOUTH_KEBBIT_DB.put(526336, arr16);
		ArrayList<Point> arr17 = new ArrayList<Point>();
		arr17.add(new Point(2712, 3831));
		SOUTH_KEBBIT_DB.put(1217398784, arr17);
		ArrayList<Point> arr18 = new ArrayList<Point>();
		arr18.add(new Point(2714, 3821));
		arr18.add(new Point(2711, 3819));
		SOUTH_KEBBIT_DB.put(33024, arr18);
		ArrayList<Point> arr19 = new ArrayList<Point>();
		arr19.add(new Point(2714, 3827));
		arr19.add(new Point(2714, 3821));
		SOUTH_KEBBIT_DB.put(1074857984, arr19);
		ArrayList<Point> arr20 = new ArrayList<Point>();
		arr20.add(new Point(2714, 3821));
		arr20.add(new Point(2711, 3819));
		SOUTH_KEBBIT_DB.put(264, arr20);
		ArrayList<Point> arr21 = new ArrayList<Point>();
		arr21.add(new Point(2714, 3821));
		arr21.add(new Point(2715, 3820));
		SOUTH_KEBBIT_DB.put(1073774627, arr21);
		ArrayList<Point> arr22 = new ArrayList<Point>();
		arr22.add(new Point(2715, 3820));
		arr22.add(new Point(2711, 3819));
		SOUTH_KEBBIT_DB.put(1074923528, arr22);
		ArrayList<Point> arr23 = new ArrayList<Point>();
		arr23.add(new Point(2718, 3829));
		arr23.add(new Point(2718, 3832));
		SOUTH_KEBBIT_DB.put(16779264, arr23);
		ArrayList<Point> arr24 = new ArrayList<Point>();
		arr24.add(new Point(2716, 3827));
		SOUTH_KEBBIT_DB.put(1342275619, arr24);
		ArrayList<Point> arr25 = new ArrayList<Point>();
		arr25.add(new Point(2712, 3815));
		arr25.add(new Point(2708, 3825));
		SOUTH_KEBBIT_DB.put(1073746200, arr25);
		ArrayList<Point> arr26 = new ArrayList<Point>();
		arr26.add(new Point(2711, 3819));
		arr26.add(new Point(2708, 3825));
		SOUTH_KEBBIT_DB.put(4099, arr26);
		ArrayList<Point> arr27 = new ArrayList<Point>();
		arr27.add(new Point(2718, 3820));
		SOUTH_KEBBIT_DB.put(1610613020, arr27);
		ArrayList<Point> arr28 = new ArrayList<Point>();
		arr28.add(new Point(2718, 3820));
		SOUTH_KEBBIT_DB.put(1677735427, arr28);
		ArrayList<Point> arr29 = new ArrayList<Point>();
		arr29.add(new Point(2718, 3829));
		arr29.add(new Point(2721, 3827));
		SOUTH_KEBBIT_DB.put(1141387267, arr29);
		ArrayList<Point> arr30 = new ArrayList<Point>();
		arr30.add(new Point(2712, 3831));
		SOUTH_KEBBIT_DB.put(1207972120, arr30);
		ArrayList<Point> arr31 = new ArrayList<Point>();
		arr31.add(new Point(2718, 3832));
		arr31.add(new Point(2721, 3827));
		SOUTH_KEBBIT_DB.put(1074627328, arr31);
		ArrayList<Point> arr32 = new ArrayList<Point>();
		arr32.add(new Point(2708, 3819));
		SOUTH_KEBBIT_DB.put(1477576728, arr32);
		ArrayList<Point> arr33 = new ArrayList<Point>();
		arr33.add(new Point(2716, 3827));
		SOUTH_KEBBIT_DB.put(1410347011, arr33);
		ArrayList<Point> arr34 = new ArrayList<Point>();
		arr34.add(new Point(2714, 3821));
		arr34.add(new Point(2715, 3820));
		SOUTH_KEBBIT_DB.put(1073741923, arr34);
		ArrayList<Point> arr35 = new ArrayList<Point>();
		arr35.add(new Point(2708, 3827));
		arr35.add(new Point(2713, 3827));
		SOUTH_KEBBIT_DB.put(1126172672, arr35);
		ArrayList<Point> arr36 = new ArrayList<Point>();
		arr36.add(new Point(2715, 3820));
		arr36.add(new Point(2711, 3819));
		SOUTH_KEBBIT_DB.put(1074923584, arr36);
		ArrayList<Point> arr37 = new ArrayList<Point>();
		arr37.add(new Point(2716, 3827));
		SOUTH_KEBBIT_DB.put(1398802432, arr37);
		ArrayList<Point> arr38 = new ArrayList<Point>();
		arr38.add(new Point(2721, 3827));
		arr38.add(new Point(2718, 3832));
		SOUTH_KEBBIT_DB.put(1091404032, arr38);
        return SOUTH_KEBBIT_DB;
	}

	private static HashMap<Integer, ArrayList<Point>> iniNorth() {
        HashMap<Integer, ArrayList<Point>> NORTH_KEBBIT_DB = new HashMap<Integer, ArrayList<Point>>();
		ArrayList<Point> arr0 = new ArrayList<Point>();
		arr0.add(new Point(2718, 3820));
		arr0.add(new Point(2715, 3820));
		arr0.add(new Point(2721, 3827));
		NORTH_KEBBIT_DB.put(1073759236, arr0);
		ArrayList<Point> arr1 = new ArrayList<Point>();
		arr1.add(new Point(2718, 3820));
		arr1.add(new Point(2715, 3820));
		arr1.add(new Point(2721, 3827));
		NORTH_KEBBIT_DB.put(1073758340, arr1);
		ArrayList<Point> arr2 = new ArrayList<Point>();
		arr2.add(new Point(2708, 3819));
		NORTH_KEBBIT_DB.put(1482817560, arr2);
		ArrayList<Point> arr3 = new ArrayList<Point>();
		arr3.add(new Point(2712, 3831));
		NORTH_KEBBIT_DB.put(1258309636, arr3);
		ArrayList<Point> arr4 = new ArrayList<Point>();
		arr4.add(new Point(2715, 3820));
		arr4.add(new Point(2711, 3819));
		NORTH_KEBBIT_DB.put(1080164416, arr4);
		ArrayList<Point> arr5 = new ArrayList<Point>();
		arr5.add(new Point(2711, 3819));
		arr5.add(new Point(2712, 3815));
		NORTH_KEBBIT_DB.put(16386, arr5);
		ArrayList<Point> arr6 = new ArrayList<Point>();
		arr6.add(new Point(2718, 3820));
		NORTH_KEBBIT_DB.put(1610629344, arr6);
		ArrayList<Point> arr7 = new ArrayList<Point>();
		arr7.add(new Point(2715, 3820));
		arr7.add(new Point(2711, 3819));
		NORTH_KEBBIT_DB.put(1080164360, arr7);
		ArrayList<Point> arr8 = new ArrayList<Point>();
		arr8.add(new Point(2721, 3827));
		arr8.add(new Point(2718, 3832));
		NORTH_KEBBIT_DB.put(1080820224, arr8);
		ArrayList<Point> arr9 = new ArrayList<Point>();
		arr9.add(new Point(2718, 3829));
		arr9.add(new Point(2721, 3827));
		NORTH_KEBBIT_DB.put(67633152, arr9);
		ArrayList<Point> arr10 = new ArrayList<Point>();
		arr10.add(new Point(2712, 3831));
		NORTH_KEBBIT_DB.put(1284505600, arr10);
		ArrayList<Point> arr11 = new ArrayList<Point>();
		arr11.add(new Point(2714, 3827));
		arr11.add(new Point(2714, 3821));
		NORTH_KEBBIT_DB.put(1141964800, arr11);
		ArrayList<Point> arr12 = new ArrayList<Point>();
		arr12.add(new Point(2718, 3829));
		arr12.add(new Point(2718, 3832));
		NORTH_KEBBIT_DB.put(1074284548, arr12);
		ArrayList<Point> arr13 = new ArrayList<Point>();
		arr13.add(new Point(2716, 3827));
		NORTH_KEBBIT_DB.put(1342292228, arr13);
		ArrayList<Point> arr14 = new ArrayList<Point>();
		arr14.add(new Point(2714, 3821));
		arr14.add(new Point(2711, 3819));
		NORTH_KEBBIT_DB.put(1073758476, arr14);
		ArrayList<Point> arr15 = new ArrayList<Point>();
		arr15.add(new Point(2714, 3821));
		arr15.add(new Point(2711, 3819));
		NORTH_KEBBIT_DB.put(1073791236, arr15);
		ArrayList<Point> arr16 = new ArrayList<Point>();
		arr16.add(new Point(2714, 3827));
		arr16.add(new Point(2714, 3821));
		NORTH_KEBBIT_DB.put(1146093568, arr16);
		ArrayList<Point> arr17 = new ArrayList<Point>();
		arr17.add(new Point(2718, 3820));
		NORTH_KEBBIT_DB.put(1678901440, arr17);
		ArrayList<Point> arr18 = new ArrayList<Point>();
		arr18.add(new Point(2711, 3819));
		arr18.add(new Point(2712, 3815));
		NORTH_KEBBIT_DB.put(16400, arr18);
		ArrayList<Point> arr19 = new ArrayList<Point>();
		arr19.add(new Point(2708, 3819));
		NORTH_KEBBIT_DB.put(1476411676, arr19);
		ArrayList<Point> arr20 = new ArrayList<Point>();
		arr20.add(new Point(2716, 3827));
		NORTH_KEBBIT_DB.put(1343244292, arr20);
		ArrayList<Point> arr21 = new ArrayList<Point>();
		arr21.add(new Point(2721, 3827));
		arr21.add(new Point(2718, 3832));
		NORTH_KEBBIT_DB.put(1097596928, arr21);
		ArrayList<Point> arr22 = new ArrayList<Point>();
		arr22.add(new Point(2718, 3829));
		arr22.add(new Point(2721, 3827));
		NORTH_KEBBIT_DB.put(67109376, arr22);
		ArrayList<Point> arr23 = new ArrayList<Point>();
		arr23.add(new Point(2715, 3820));
		arr23.add(new Point(2714, 3815));
		NORTH_KEBBIT_DB.put(1140852225, arr23);
		ArrayList<Point> arr24 = new ArrayList<Point>();
		arr24.add(new Point(2716, 3827));
		NORTH_KEBBIT_DB.put(1342292000, arr24);
		ArrayList<Point> arr25 = new ArrayList<Point>();
		arr25.add(new Point(2714, 3821));
		arr25.add(new Point(2715, 3820));
		NORTH_KEBBIT_DB.put(1073791008, arr25);
		ArrayList<Point> arr26 = new ArrayList<Point>();
		arr26.add(new Point(2718, 3820));
		NORTH_KEBBIT_DB.put(1617692160, arr26);
		ArrayList<Point> arr27 = new ArrayList<Point>();
		arr27.add(new Point(2715, 3820));
		arr27.add(new Point(2714, 3815));
		NORTH_KEBBIT_DB.put(1140852352, arr27);
		ArrayList<Point> arr28 = new ArrayList<Point>();
		arr28.add(new Point(2718, 3820));
		NORTH_KEBBIT_DB.put(1617035456, arr28);
		ArrayList<Point> arr29 = new ArrayList<Point>();
		arr29.add(new Point(2718, 3829));
		arr29.add(new Point(2718, 3832));
		NORTH_KEBBIT_DB.put(1090537476, arr29);
		ArrayList<Point> arr30 = new ArrayList<Point>();
		arr30.add(new Point(2714, 3821));
		arr30.add(new Point(2715, 3820));
		NORTH_KEBBIT_DB.put(1073758304, arr30);
		ArrayList<Point> arr31 = new ArrayList<Point>();
		arr31.add(new Point(2718, 3829));
		arr31.add(new Point(2714, 3821));
		NORTH_KEBBIT_DB.put(6553600, arr31);
		ArrayList<Point> arr32 = new ArrayList<Point>();
		arr32.add(new Point(2708, 3819));
		NORTH_KEBBIT_DB.put(1543505688, arr32);
		ArrayList<Point> arr33 = new ArrayList<Point>();
		arr33.add(new Point(2712, 3831));
		NORTH_KEBBIT_DB.put(1265369088, arr33);
		ArrayList<Point> arr34 = new ArrayList<Point>();
		arr34.add(new Point(2715, 3820));
		arr34.add(new Point(2711, 3819));
		NORTH_KEBBIT_DB.put(1142030344, arr34);
		ArrayList<Point> arr35 = new ArrayList<Point>();
		arr35.add(new Point(2708, 3819));
		NORTH_KEBBIT_DB.put(1543505411, arr35);
		ArrayList<Point> arr36 = new ArrayList<Point>();
		arr36.add(new Point(2716, 3827));
		NORTH_KEBBIT_DB.put(1409386240, arr36);
		ArrayList<Point> arr37 = new ArrayList<Point>();
		arr37.add(new Point(2715, 3820));
		arr37.add(new Point(2711, 3819));
		NORTH_KEBBIT_DB.put(1142030400, arr37);
		ArrayList<Point> arr38 = new ArrayList<Point>();
		arr38.add(new Point(2714, 3821));
		arr38.add(new Point(2711, 3819));
		NORTH_KEBBIT_DB.put(1140852488, arr38);
		ArrayList<Point> arr39 = new ArrayList<Point>();
		arr39.add(new Point(2714, 3821));
		arr39.add(new Point(2711, 3819));
		NORTH_KEBBIT_DB.put(1140885248, arr39);
		ArrayList<Point> arr40 = new ArrayList<Point>();
		arr40.add(new Point(2718, 3829));
		arr40.add(new Point(2714, 3821));
		NORTH_KEBBIT_DB.put(6356992, arr40);
		ArrayList<Point> arr41 = new ArrayList<Point>();
		arr41.add(new Point(2708, 3819));
		NORTH_KEBBIT_DB.put(1544683544, arr41);
        return NORTH_KEBBIT_DB;
	}
}
