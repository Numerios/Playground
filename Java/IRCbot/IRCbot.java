import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class IRCbot {
	private static String SERVER = "efnet.xs4all.nl";
	private static int PORT = 6667;
	private static String NICK = "NumiBot";

	public static ArrayList<String> channelList = new ArrayList<String>();

	private static boolean running = false;
	private static Socket socket;
	private static BufferedReader in;
	private static BufferedWriter out;
	
	public static String buffer;
	/**
	 * A stupid little bot I created in a few hours.
	 * TODO: Responding to the exact person, using regex to search for stuff;
	 */
	public static void main(String[] args) throws IOException {
		socket = new Socket(SERVER, PORT);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(
				socket.getOutputStream()));
		if (socket.isConnected()) {
			login(NICK);

			channelList.add("technicraft.game");
			join(channelList);

			running = true;
			new Thread().start();
		}
		while (running) {
			try {
				while ((buffer = in.readLine()) != null) {
					respond(buffer, channelList.get(0), "\'o", "Nazdar! :)");
					respond(buffer, channelList.get(0), "ahoj", "Nazdar! :)");
					respond(buffer, channelList.get(0), "zdravim", "Nazdar! :)");
					respond(buffer, channelList.get(0), "zdar", "Nazdar! :)");
					respond(buffer, channelList.get(0), "helou", "Nazdar! :)");
					Grammar.checkGrammar(channelList.get(0));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void login(String nick) throws IOException {
		out.write("USER Q Q Q :Q\n".replaceAll("Q", nick));
		out.write("NICK " + nick + "\n");
		out.flush();
	}

	public static void join(ArrayList<String> chanList) throws IOException {
		for (String channel : chanList) {
			out.write("JOIN #" + channel + "\n");
		}
		out.flush();
	}

	public static void say(String channel, String msg) throws IOException {
		out.write("PRIVMSG #" + channel + " :" + msg + "\n");
		out.flush();
	}
	
	public static void respond(String b, String channel, String event, String response) throws IOException {
		if (b.toLowerCase().contains(event.toLowerCase())) {
			say(channel, response);
		}
	}
	
	public static void quit(String channel) throws IOException {
		out.write("Ja jeste nechci odejit :(");
		out.write("QUIT #" + channel + "\n");
		out.flush();
	}
}
