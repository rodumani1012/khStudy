package c0719.network.server;

public class LogUtil {

	public static void printInfo(String message) {
		System.out.println(message);
		
	}
	public static void printMsg(String message) {
		System.out.println("[" + CalendarUtil.getDateTime() + "] " + message);
	}
	public static void printMsgGuide(String message) {
		System.out.println("[" + CalendarUtil.getDateTime() + "] " + message);
	}

}
