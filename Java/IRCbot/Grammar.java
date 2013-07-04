import java.io.IOException;
import java.util.Random;

public class Grammar {
	public static String[] grammarCheck = { "aby jsi", "aby jsme", "aby jste",
			"abysme", "aby sme", "by jste", "by jsi", "hrupka", "hrupki", "hrubki" };
	public static String[] grammarAnswer = { "abys", "abychom", "abyste",
			"aby jsme", "aby jsme", "byste", "bys", "hrubka", "hrubky", "hrubky" };
	public static String[] comment = { "Doporucoval bych se naucit cesky.",
			"Kdo te sakra ucil cesky? ",
			"Bro, do you even Czech your grammar? ",
			"Vypni kompa a jdi se ucit cesky!", "Wow. Takova hrubka...",
			"Kdo to po tobe ma sakra cist?", "OH GOD MY EYES" };

	public static void checkGrammar(String channel) throws IOException {
		for (int i = 0; i < grammarCheck.length; i++) {
			if (IRCbot.buffer.toLowerCase().contains(grammarCheck[i].toLowerCase())) {
				Random random = new Random();
				IRCbot.say(channel, "* " + grammarAnswer[i] + "; "
						+ comment[random.nextInt(comment.length)]);
				break;
			}
		}
	}
}
