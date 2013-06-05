package kebbiter.util;


/**
 * @author fredrik
 */
public class Msg {

    private static final boolean ENABLE_DEBUG = false;
    public static String lastRep = "";

    public static void msg(String string){
        if(ENABLE_DEBUG)
            System.out.println(string);
    }

    public static void rep(String rep){
        if (!lastRep.equals(rep)){
            lastRep = rep;
            System.out.println("[KEBBITER] " + rep);
        }
    }
}
