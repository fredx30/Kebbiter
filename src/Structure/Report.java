package Structure;

abstract class Report {

	private static final boolean isDebug = false;
	
	public static void debug(String text)
	{
		if(isDebug)
		{
			System.out.println(text);
		}
	}
	
}
